package com.ldrobot.utils.util.netconfig.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;
import com.ldrobot.utils.bean.ble.BleRequest;
import com.ldrobot.utils.util.AES;
import com.ldrobot.utils.util.LogUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

import static android.bluetooth.le.ScanSettings.SCAN_MODE_LOW_LATENCY;

/**
 * 蓝牙工具类
 */
public class BluetoothUtils {
    private BluetoothManager manager;
    private BluetoothAdapter mBleAdapter;
    private boolean mScanning;
    private BluetoothLeScanner mBLEScanner;
    private BluetoothGatt mBluetoothGatt;
    private long HONEY_CMD_TIMEOUT = 2 * 1000l;
    private Timer timer;
    private Context mContext;
    private static final AtomicReference<BluetoothUtils> INSTANCE = new AtomicReference<>();
    private ScanCallback mScanCallback;
    private BluetoothAdapter.LeScanCallback leScanCallback;

    public static BluetoothUtils getInstance(Context context) {
        BluetoothUtils singleton = INSTANCE.get();
        if (singleton == null) {
            singleton = new BluetoothUtils(context);
            if (!INSTANCE.compareAndSet(null, singleton)) {
                singleton = INSTANCE.get();
            }
        }
        return singleton;
    }

    /**
     * 初始化   获取BluetoothManager 和 BluetoothAdapter
     * 也可以用：BluetoothAdapter bleAdapter = BluetoothAdapter.getDefaultAdapter();
     *
     * @param context
     */
    private BluetoothUtils(Context context) {
        mContext = context;
        manager = (BluetoothManager) mContext.getSystemService(Context.BLUETOOTH_SERVICE);
        mBleAdapter = manager.getAdapter();
//        context.registerReceiver(mBroadcastReceiver, makeFilters());
    }

    //蓝牙监听需要添加的Action
    private IntentFilter makeFilters() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        intentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        intentFilter.addAction("android.bluetooth.BluetoothAdapter.STATE_OFF");
        intentFilter.addAction("android.bluetooth.BluetoothAdapter.STATE_ON");
        return intentFilter;
    }

    /**
     * 检测蓝牙是否打开或可用
     *
     * @return true 可用  false需要手动打开
     */
    public boolean checkBleEnable() {
        return (null != mBleAdapter && mBleAdapter.isEnabled() && !mBleAdapter.isDiscovering());
    }

    /**
     * 通过mac地址获取蓝牙对象
     *
     * @param address
     * @return
     */
    public BluetoothDevice getBluetoothDevice(String address) {
        if (mBleAdapter != null) {
            BluetoothDevice remoteDevice = mBleAdapter.getRemoteDevice(address);
            return remoteDevice;
        }
        return null;
    }

    /**
     * 开始扫描
     */
    public void startScan(List<ScanFilter> bleScanFilters, ScanCallback mScanCallback1, BluetoothAdapter.LeScanCallback leScanCallback1, long delayTime) {
        if (!checkBleEnable()) return;  // 检测蓝牙
        this.mScanCallback = mScanCallback1;
        this.leScanCallback = leScanCallback1;
        //处于未扫描的状态
        if (!mScanning) {
            //android 5.0后
            if (Build.VERSION.SDK_INT >= 21) {
                //标记当前的为扫描状态
                mScanning = true;
                //获取5.0新添的扫描类
                if (mBLEScanner == null) {
                    //mBLEScanner是5.0新添加的扫描类，通过BluetoothAdapter实例获取。
                    mBLEScanner = mBleAdapter.getBluetoothLeScanner();
                }
                //开始扫描 先设置过滤器和扫描参数
                ScanSettings scanSettings = getBuilder();
                if (mBleAdapter.isEnabled() && mBleAdapter.getState() == BluetoothAdapter.STATE_ON) {
                    mBLEScanner.startScan(bleScanFilters, scanSettings, mScanCallback);
                } else {
                    LogUtils.e("startScan前置条件不够！上次资源占用");
                }
            } else {
                //标记当前的为扫描状态
                mScanning = true;
                //5.0以下  开始扫描
                if (mBleAdapter.isEnabled() && mBleAdapter.getState() == BluetoothAdapter.STATE_ON) {
                    mBleAdapter.startLeScan(leScanCallback);
                } else {
                    LogUtils.e("startScan前置条件不够！上次资源占用");
                }
            }
            //可以设置固定的时间后，关闭
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (mScanCallback != null) {
                        mScanCallback.onScanFailed(-1);
                    }
                    disconnect();
                }
            }, delayTime);
        }
    }

    /**
     * 扫描参数的配置
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private ScanSettings getBuilder() {
        ScanSettings.Builder builder = new ScanSettings.Builder()
                //低功耗模式 SCAN_MODE_LOW_POWER 平衡模式：SCAN_MODE_BALANCED  高功耗模式：SCAN_MODE_LOW_LATENCY
                //设置高功耗模式
                .setScanMode(SCAN_MODE_LOW_LATENCY);
        //android 6.0添加设置回调类型、匹配模式等
        if (Build.VERSION.SDK_INT >= 23) {
            //定义回调类型 返回符合过滤条件的蓝牙广播。无过滤条件时，返回全部蓝牙广播。
            builder.setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES);
            //设置蓝牙LE扫描滤波器硬件匹配的匹配模式 有过滤条件时过滤，
            builder.setMatchMode(ScanSettings.MATCH_MODE_STICKY);
        }
        //芯片组支持批处理芯片上的扫描
        if (mBleAdapter.isOffloadedScanBatchingSupported()) {
            //设置蓝牙LE扫描的报告延迟的时间（以毫秒为单位）
            //设置为0以立即通知结果
            builder.setReportDelay(0L);
        }
        return builder.build();
    }

    /**
     * 停止扫描
     */
    public void stopScan() {
        mScanning = false;
        if (Build.VERSION.SDK_INT >= 21) {
            if (mBLEScanner != null) {
                if (mScanCallback != null) {
                    mBLEScanner.flushPendingScanResults(mScanCallback);
                    if (mBleAdapter.isEnabled() && mBleAdapter.getState() == BluetoothAdapter.STATE_ON) {
                        mBLEScanner.stopScan(mScanCallback);
                    }
                }
            }
        } else {
            if (mBleAdapter != null) {
                if (mBleAdapter.isEnabled() && mBleAdapter.getState() == BluetoothAdapter.STATE_ON) {
                    if (leScanCallback != null) {
                        mBleAdapter.stopLeScan(leScanCallback);
                    }
                }
            }
        }
    }


    /**
     * 连接
     *
     * @param device
     * @param LDGattCallBack
     */
    public void connectGatt(BluetoothDevice device, LDGattCallBack LDGattCallBack) {
        Log.e("TAG", "connectGatt");
        //连接设备
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mBluetoothGatt = device.connectGatt(mContext, false, LDGattCallBack, BluetoothDevice.TRANSPORT_LE);
        } else {
            mBluetoothGatt = device.connectGatt(mContext, false, LDGattCallBack);
        }
    }

    /**
     * 断开连接
     */
    public void disconnect() {
        if (mBluetoothGatt != null) {
            mBluetoothGatt.disconnect();
            mBluetoothGatt.close();
            mBluetoothGatt = null;
        }
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        mScanCallback = null;
        leScanCallback = null;
        LogUtils.e("断开连接，销毁回调");
    }

    /**
     * 发送数据
     * 分包发送，一次20个字符
     * 同步锁，防止多线程调用，多线程写characteristic，导致数据混乱
     *
     * @param msg
     */
    public synchronized void sendData(String msg) {
        if (mBluetoothGatt != null) {
            BluetoothGattService service = mBluetoothGatt.getService(AttConstant.M_SERVICE_UUID);
            if (service != null) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(AttConstant.M_CHARACTERISTIC_UUID_W);
                if (characteristic != null) {
                    LogUtils.e("origin==" + msg);
                    String encrypt = AES.encrypt(msg, "3J74PRUE5TKPJP32", "QB8GC2X6WK39FF93");
                    LogUtils.e("encrypt==" + encrypt);
                    if (encrypt != null) {
                        BleRequest bleResponse = new BleRequest();
                        bleResponse.setData(encrypt);
                        bleResponse.setLen(encrypt.length());
                        String finalStr = JSON.toJSONString(bleResponse) + AttConstant.SPLIT_CMD;
                        int alpha = 20;
                        for (int i = 0; i < finalStr.length(); ) {
                            int endIndex = i + alpha;
                            if (endIndex > finalStr.length()) {
                                endIndex = finalStr.length();
                            }
                            String substring = finalStr.substring(i, endIndex);
                            LogUtils.e("value==" + substring);
                            characteristic.setValue(substring);
                            long enterTime = System.currentTimeMillis();
                            while ((System.currentTimeMillis() - enterTime) < HONEY_CMD_TIMEOUT) {
                                if (isDeviceBusy()) {
                                    try {
//                                        Thread.sleep(10);
                                        wait(10);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                        Thread.currentThread().interrupt();
                                    }
                                } else {
                                    break;
                                }
                            }
                            boolean flag = mBluetoothGatt.writeCharacteristic(characteristic);
                            i += alpha;
                        }
                    }
                }
            }
        }
    }

    private boolean isDeviceBusy() {
        boolean state = false;
        try {
            state = (boolean) readField(mBluetoothGatt, "mDeviceBusy");
            Log.e("TAG", "isDeviceBusy:" + state);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return state;
    }

    public Object readField(Object object, String name) throws IllegalAccessException, NoSuchFieldException {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return field.get(object);
    }


//    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            //获取蓝牙广播  本地蓝牙适配器的状态改变时触发
//            String action = intent.getAction();
//            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
//                //获取蓝牙广播中的蓝牙新状态
//                int blueNewState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0);
//                //获取蓝牙广播中的蓝牙旧状态
//                int blueOldState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0);
//                switch (blueNewState) {
//                    //正在打开蓝牙
//                    case BluetoothAdapter.STATE_TURNING_ON:
//                        LogUtils.e("STATE_TURNING_ON");
//                        break;
//                    //蓝牙已打开
//                    case BluetoothAdapter.STATE_ON:
//                        LogUtils.e("STATE_ON");
//                        break;
//                    //正在关闭蓝牙
//                    case BluetoothAdapter.STATE_TURNING_OFF:
//                        LogUtils.e("STATE_TURNING_OFF");
//                        break;
//                    //蓝牙已关闭
//                    case BluetoothAdapter.STATE_OFF:
//                        LogUtils.e("STATE_OFF");
//                        disconnect();
//                        break;
//                }
//            }
//        }
//    };

}