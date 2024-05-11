package com.ldrobot.utils.util.netconfig.ble;


import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;

import com.ldrobot.utils.util.LogUtils;

import java.util.StringTokenizer;

import static com.ldrobot.utils.util.netconfig.ble.AttConstant.M_CHARACTERISTIC_UUID_R;
import static com.ldrobot.utils.util.netconfig.ble.AttConstant.M_SERVICE_UUID;

/**
 * 蓝牙连接状态和数据监听回调
 */
public class LDGattCallBack extends BluetoothGattCallback {
    //定义重连次数
    private int reConnectionNum = 0;
    //最多重连次数
    private static int maxConnectionNum = 3;
    private BleCallBack bleCallBack;

    public void setBleCallBack(BleCallBack bleCallBack) {
        this.bleCallBack = bleCallBack;
    }

    private StringBuffer sb = new StringBuffer();

    /**
     * 连接成功后，触发
     *
     * @param gatt
     * @param status
     * @param newState
     */
    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        super.onConnectionStateChange(gatt, status, newState);
        LogUtils.e("连接成功" + status + "==" + newState + gatt.toString());
        // status 用于返回操作是否成功,会返回异常码。
        // newState 返回连接状态，如BluetoothProfile#STATE_DISCONNECTED、BluetoothProfile#STATE_CONNECTED
        //操作成功的情况下
        if (status == BluetoothGatt.GATT_SUCCESS) {//gatt 服务成功
            //判断是否连接码
            if (newState == BluetoothProfile.STATE_CONNECTED) {//连接成功
                //发现服务
                gatt.discoverServices();
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                //判断是否断开连接码
                if (gatt != null) {
                    gatt.disconnect();
                    gatt.close();
                }
                if (bleCallBack != null) {
                    bleCallBack.onConnectState(1);
                }
            }
        } else {
            //现释放上一次的连接
            gatt.disconnect();
            gatt.close();
            gatt = null;
            //异常码
            //重连次数不大于最大重连次数
            if (reConnectionNum < maxConnectionNum) {
                //重连次数自增
                reConnectionNum++;
                if (bleCallBack != null) {
                    bleCallBack.onConnectState(2);
                }
            } else {
                //断开连接，返回连接失败回调
                reConnectionNum = 0;
                if (bleCallBack != null) {
                    bleCallBack.onConnectState(3);
                }
            }
        }
    }

    /**
     * gatt.discoverServices();
     * 当发现服务成功后，会触发
     */
    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        super.onServicesDiscovered(gatt, status);
        LogUtils.e("==onServicesDiscovered");
        if (status == BluetoothGatt.GATT_SUCCESS) {
            //获取指定uuid的service
            BluetoothGattService gattService = gatt.getService(M_SERVICE_UUID);
            //获取到特定的服务不为空
            if (gattService != null) {
                //获取指定uuid的Characteristic
                BluetoothGattCharacteristic gattCharacteristic = gattService.getCharacteristic(M_CHARACTERISTIC_UUID_R);
                //获取特定特征成功
                if (gattCharacteristic != null) {
                    //订阅  具有NOTIFY属性
                    int properties = gattCharacteristic.getProperties();
                    LogUtils.e("properties===" + properties); //PROPERTY_NOTIFY
                    boolean b = gatt.setCharacteristicNotification(gattCharacteristic, true);
                    LogUtils.e("properties===" + b);
                    //可以发数据
                    if (bleCallBack != null) {
                        bleCallBack.onConnectState(4);
                    }
                }
            }
        }
    }

    /**
     * 当成功写入特征值到外设时，会触发
     */
    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicWrite(gatt, characteristic, status);
        LogUtils.e("==onCharacteristicWrite");
        if (status == BluetoothGatt.GATT_SUCCESS) {
            //获取读取到的特征值
            byte[] value = characteristic.getValue();
            String s = new String(value);
            LogUtils.e("onCharacteristicWrite", s);
        }
    }

    /**
     * 当成功读取特征值时，会触发
     *
     * @param gatt
     * @param characteristic
     * @param status
     */
    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicRead(gatt, characteristic, status);
        if (status == BluetoothGatt.GATT_SUCCESS) {
            //获取读取到的特征值
            byte[] value = characteristic.getValue();
            String s = new String(value);
            LogUtils.e("onCharacteristicRead", s);
        }
    }

    /**
     * 具有NOTIFY属性 当写入完特征值后，外设修改自己的特征值进行回复时，手机端会触发
     * setCharacteristicNotification   “#\t#” 230923
     */
    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        super.onCharacteristicChanged(gatt, characteristic);
        //获取读取到的特征值
        byte[] value = characteristic.getValue();
        String temp = new String(value);
        LogUtils.e(hashCode() + "====temp==" + temp);
        sb.append(temp);
        String result = sb.toString();
        if (result.contains(AttConstant.SPLIT_CMD)) {
            sb.setLength(0);
            parsePackage(result);
        }
    }

    /**
     * 开始标志是 “\r\n”后的第一个“{”,结束标志是 “\r\n”
     *
     * @param result
     */
    private synchronized void parsePackage(String result) {
        try {
            int start;
            int position;
            StringTokenizer stringTokenizer = new StringTokenizer(result, AttConstant.SPLIT_CMD);
            while (stringTokenizer.hasMoreTokens()) {
                String responseString = stringTokenizer.nextToken();
                if ((position = responseString.indexOf("}")) >= 0 && (start = responseString.indexOf('{')) >= 0 && start < position) {
                    String substring = responseString.substring(start, position + 1);
                    if (bleCallBack != null) {
                        bleCallBack.onReceiver(substring);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //描述写入回调
    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorWrite(gatt, descriptor, status);
        LogUtils.e("==onDescriptorWrite");
    }

    @Override
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorRead(gatt, descriptor, status);
        LogUtils.e("==onDescriptorRead");
        byte[] value = descriptor.getValue();
        String s = new String(value);
        LogUtils.e("onDescriptorRead", s);
    }

    @Override
    public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        super.onMtuChanged(gatt, mtu, status);
    }
}