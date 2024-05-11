package com.ldrobot.utils.util.netconfig.wifi;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.NetworkSpecifier;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import android.os.PatternMatcher;
import android.util.Log;

import com.ldrobot.utils.util.LogUtils;
import com.ldrobot.utils.util.SystemUtil;
import com.ldrobot.utils.util.WriteLogUtil;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * wifi 设置的公共方法
 *
 * @author Administrator21324324
 */

public class WifiFunction {
    private static final String TAG = "WifiFunction";
    private WifiManager mWifiManager;
    private Context mContext;
    private ConnectivityManager mConnectivityManager;

    public final static int WIFICIPHER_NOPASS = 1;
    public final static int WIFICIPHER_WEP = 2;
    public final static int WIFICIPHER_WPA = 3;

    private OnWifiFunctionListener mOnWifiFunctionListener;

    private boolean mStopConnect = false;
    private WifiScanReceiver mWifiScanReceiver;
    private List<ConnectivityManager.NetworkCallback> mNetworkCallbacks = new ArrayList<>();

    public interface OnWifiFunctionListener {
        void onConnectFinish(boolean isSuccess, String msg, String tag, Network network);
    }

    public void setOnWifiFunctionListener(OnWifiFunctionListener onWifiFunctionListener) {
        LogUtils.e("设置回调：" + onWifiFunctionListener);
        this.mOnWifiFunctionListener = onWifiFunctionListener;
    }

    private interface Callback {
        void onBack(int type, boolean isConnect, Network network);
    }

    /**
     * 初始化
     *
     * @param context
     */
    public WifiFunction(Context context) {
        mWifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mContext = context;
        mConnectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        setWifiEnabled();
    }

    public ConnectivityManager getConnectivityManager() {
        return mConnectivityManager;
    }

    /**
     * 扫描，通过wifiScanReceiver监听扫描到的结果
     * 需要
     * 1.android.Manifest.permission#CHANGE_WIFI_STATE
     * 2.ACCESS_FINE_LOCATION 或 ACCESS_COARSE_LOCATION 权限
     * 3.设备已启动位置信息服务
     * <p>
     * getScanResults 追加：
     * ACCESS_WIFI_STATE
     * 注意：
     * 1.短时间扫描多次，扫描请求可能遭到节流
     * 2.设备处理空闲状态，扫描已经停用
     * 3.WLAN 硬件报告扫描失败
     */
    public void startScan(WifiScanResultCallback wifiScanResultCallback) {
        try {
            if (mWifiScanReceiver == null) {
                //注册广播接受者，监听Wifi的扫描结果
                mWifiScanReceiver = new WifiScanReceiver();
                mWifiScanReceiver.setWifiScanResultCallback(this, wifiScanResultCallback);
                IntentFilter filter = new IntentFilter();
                filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
                mContext.registerReceiver(mWifiScanReceiver, filter);
            }
        } catch (Exception e) {
            e.printStackTrace();
            WriteLogUtil.getInstance().writeLog("注册广播异常：" + e, WriteLogUtil.CREAT_TYPE);
        }
        if (mWifiManager != null && isWifiEnabled()) {
            boolean success = mWifiManager.startScan();
            if (!success) {
                //扫描失败，取旧的结果
                List<ScanResult> results = mWifiManager.getScanResults();
                if (wifiScanResultCallback != null) {
                    wifiScanResultCallback.onScanNotify(results);
                }
            }
        } else {
            Log.e("startScan", "Scan Error isWifiEnabled is " + isWifiEnabled());
        }
    }

    /**
     * 停止wifi扫描
     */
    public void stopScan() {
        if (mWifiScanReceiver != null) {
            mWifiScanReceiver.setWifiScanResultCallback(null, null);
            mContext.unregisterReceiver(mWifiScanReceiver);
            mWifiScanReceiver = null;
        }
    }

    /**
     * 获取WifiManager
     *
     * @return
     */
    public WifiManager getWifiManager() {
        return mWifiManager;
    }

    /**
     * 判断Wifi是否可用
     *
     * @return
     */
    public boolean isWifiEnabled() {
        return mWifiManager.isWifiEnabled();
    }

    public boolean setWifiEnabled() {
        if (!isWifiEnabled()) {
            return mWifiManager.setWifiEnabled(true);
        }
        return true;
    }

    /**
     * 获取当前连接wifi的ssid
     *
     * @return
     */
    public String getCurrentWifiName() {
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        String curSsid = "";
        if (wifiInfo != null) {
            String ssid = wifiInfo.getSSID();
            if ("<unknown ssid>".equals(ssid)) {
                curSsid = ssid;
            } else if (ssid.startsWith("0x")) {
                curSsid = ssid;
            } else {
                //"\"" + unicode + "\""
                if (ssid.length() > 1) {
                    curSsid = ssid.substring(1, ssid.length() - 1);
                }
            }
        }
        return curSsid;
    }

    /**
     * 判断是否是5G
     *
     * @return
     */
    public boolean is5GHz() {
        WifiInfo connectionInfo = mWifiManager.getConnectionInfo();
        int frequency = connectionInfo.getFrequency();
        return frequency > 4900 && frequency < 5900;
    }

    /**
     * 判断是否是2.4G
     *
     * @return
     */
    public boolean is24GHz() {
        WifiInfo connectionInfo = mWifiManager.getConnectionInfo();
        int frequency = connectionInfo.getFrequency();
        return frequency > 2400 && frequency < 2500;
    }


    /**
     * 连接WiFi
     *
     * @param SSID     wifi名称
     * @param Password wifi 密码
     * @param Type     密码类型
     */
    public void connect(final String SSID, final String Password, final int Type, String tag) {
        LogUtils.e("connect：SSID：" + SSID + "，Password：" + Password + "，Type：" + Type + "，tag：" + tag);
        //没有开启Wifi直接返回失败
        if (!setWifiEnabled()) {
            if (mOnWifiFunctionListener != null) {
                mOnWifiFunctionListener.onConnectFinish(false, "Wifi is unable", tag, null);
            }
            return;
        }

        //获取当前连接的Wifi,是否是目标wifi; 是，返回连接成功，不是，下一步
        WifiInfo info = mWifiManager.getConnectionInfo();
        if (info != null) {
            String SSIDCurrent = info.getSSID();
            if (SSIDCurrent != null) {
                if (SSIDCurrent.equals("\"" + SSID + "\"")) {
                    if (mOnWifiFunctionListener != null) {
                        mOnWifiFunctionListener.onConnectFinish(true, "Current wifi is right", tag, null);
                    }
                    return;
                }
            }
        }

        //连接前，禁掉所有wifi，防止自动跳转   小米手机权限问题
        String deviceBrand = SystemUtil.getDeviceBrand();
        if (deviceBrand != null) {
            String lowerCase = deviceBrand.toLowerCase();
            if (!lowerCase.contains("xiaomi")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (mContext.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Log.e("Connect", "not permission!!!");
                        if (mOnWifiFunctionListener != null) {
                            mOnWifiFunctionListener.onConnectFinish(false, "not permission!!!", tag, null);
                        }
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S_V2) {
                    for (WifiConfiguration c : mWifiManager.getConfiguredNetworks()) {
                        if (!(c.SSID.equals(SSID))) {
                            mWifiManager.disableNetwork(c.networkId);
                        }
                    }
                }
            }
        }
        //开始连接
        new Thread(new Runnable() {
            @Override
            public void run() {
                connectNetWork(SSID, Password, Type, new Callback() {

                    @Override
                    public void onBack(int type, boolean isConnect, Network network) {
                        LogUtils.e(type + "，connectNetWork.onBack：" + isConnect + "，mOnWifiFunctionListener：" + mOnWifiFunctionListener);
                        if (type == 1) {
                            if (!isConnect || !isWifiEnabled()) {
                                if (mOnWifiFunctionListener != null) {
                                    mOnWifiFunctionListener.onConnectFinish(false, "enableNetwork fail !", tag, null);
                                }
                                return;
                            }
                            //等待3秒连接
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ie) {
                                ie.printStackTrace();
                                Thread.currentThread().interrupt();
                            }
                            int trytimes = 0;
                            while (!mStopConnect) {
                                WifiInfo info = mWifiManager.getConnectionInfo();
                                if (info != null) {
                                    String ssid = info.getSSID();
                                    NetworkInfo networkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                                    if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED
                                            && ssid != null && ssid.equals("\"" + SSID + "\"")) {
                                        if (mOnWifiFunctionListener != null) {
                                            mOnWifiFunctionListener.onConnectFinish(true, "", tag, null);
                                        }
                                        return;
                                    }
                                }
                                trytimes++;
                                if (trytimes > 7) {
                                    if (mOnWifiFunctionListener != null) {
                                        mOnWifiFunctionListener.onConnectFinish(false, "trytimes == 7 and connect fail", tag, null);
                                    }
                                    return;
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ie) {
                                    Log.v("Search", "wifi not connected111111");
                                    ie.printStackTrace();
                                    Thread.currentThread().interrupt();
                                }
                            }
                        } else {
                            if (isConnect) {
                                if (mOnWifiFunctionListener != null) {
                                    mOnWifiFunctionListener.onConnectFinish(true, "", tag, network);
                                }
                            } else {
                                if (mOnWifiFunctionListener != null) {
                                    mOnWifiFunctionListener.onConnectFinish(false, "p2p connect fail", tag, null);
                                }
                            }
                        }
                    }
                });

            }
        }).start();
    }

    public void stopConnect() {
        mStopConnect = true;
    }

    /**
     * 真正的开始连接
     *
     * @param SSID     wifi名称
     * @param Password wifi密码
     * @param Type     密码类型
     * @return 是否连接成功
     * <p>
     * android10 连接成功后，一定要使用该网络:
     * connectivityManager.bindProcessToNetwork(network);表示使用该wifi网络
     * connectivityManager.bindProcessToNetwork(null);表示不在使用该网络
     */
    public void connectNetWork(String SSID, String Password, int Type, Callback callback) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            NetworkSpecifier specifier = new WifiNetworkSpecifier.Builder()
                    .setSsidPattern(new PatternMatcher(SSID, PatternMatcher.PATTERN_PREFIX))
                    .setWpa2Passphrase(Password)
                    .build();

            NetworkRequest request = new NetworkRequest.Builder()
                    .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                    .removeCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    .setNetworkSpecifier(specifier)
                    .build();

            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    // do success processing here..
                    LogUtils.e("onAvailable==" + network.toString());
//                    if (CheckFastDoubleClick.isFastDoubleClick()) {
//                        LogUtils.e("repeat callback");
//                        return;
//                    }
//                    network.getByName()
                    callback.onBack(2, true, network);
                }

                @Override
                public void onUnavailable() {
                    // do failure processing here..
                    LogUtils.e("onUnavailable==");
                    callback.onBack(2, false, null);
                }
            };
            mNetworkCallbacks.add(networkCallback);
            mConnectivityManager.requestNetwork(request, networkCallback);
        } else {
            boolean success = true;
            WifiConfiguration configuration = isExists(SSID);

            if (configuration == null) {
                //创建一个新的WifiConfiguration ，CreateWifiInfo()需要自己实现
                configuration = CreateWifiInfo(SSID, Password, Type);
                int wcgID = mWifiManager.addNetwork(configuration);
                LogUtils.e("wcgID==" + wcgID);
                success = mWifiManager.enableNetwork(wcgID, true);
            } else {
                success = mWifiManager.enableNetwork(configuration.networkId, true);
            }
            callback.onBack(1, success, null);
        }
    }

    public void unregisterNetworkCallback() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mConnectivityManager != null) {
                mConnectivityManager.bindProcessToNetwork(null);
                if (mNetworkCallbacks != null) {
                    for (ConnectivityManager.NetworkCallback networkCallback : mNetworkCallbacks) {
                        if (networkCallback != null) {
                            mConnectivityManager.unregisterNetworkCallback(networkCallback);
                            networkCallback = null;
                        }
                    }
                    mNetworkCallbacks.clear();
                }
            }
        }
    }


    /**
     * 系统是否保存着当前Wifi的信息
     *
     * @param SSID wifi 名称
     * @return 如果存在, 代表之前连接过，就返回wifi配置信息;否则 null
     */
    public WifiConfiguration isExists(String SSID) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mContext.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.e("isExits", "没有权限！");
                return null;
            }
        }
        List<WifiConfiguration> configuredNetworks = mWifiManager.getConfiguredNetworks();
        if (configuredNetworks != null) {
            for (WifiConfiguration configuredNetwork : configuredNetworks) {
                if (configuredNetwork.SSID.equals("\"" + SSID + "\"")) {
                    return configuredNetwork;
                }
            }
        }
        return null;
    }


    /**
     * 创建一个新的wifi描述信息
     *
     * @param SSID
     * @param Password
     * @param Type
     * @return
     */
    public static WifiConfiguration CreateWifiInfo(String SSID, String Password, int Type) {
        WifiConfiguration config = new WifiConfiguration();
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        config.SSID = "\"" + SSID + "\"";

        switch (Type) {
            case WIFICIPHER_NOPASS:
                config.hiddenSSID = true;
                config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                break;
            case WIFICIPHER_WEP:
                config.wepTxKeyIndex = 0;
                config.wepKeys[0] = "\"" + Password + "\"";// "1234567890";//
                // 10位密码不加转义字符 5位的要加
                // s config.preSharedKey = "\"" + 1234567890 + "\"";
                config.allowedAuthAlgorithms
                        .set(WifiConfiguration.AuthAlgorithm.OPEN);
                config.allowedAuthAlgorithms
                        .set(WifiConfiguration.AuthAlgorithm.SHARED);
                config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                break;
            case WIFICIPHER_WPA:
                config.preSharedKey = "\"" + Password + "\"";
                config.hiddenSSID = true;
                config.allowedAuthAlgorithms
                        .set(WifiConfiguration.AuthAlgorithm.OPEN);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
                config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
                config.allowedPairwiseCiphers
                        .set(WifiConfiguration.PairwiseCipher.TKIP);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
                config.allowedPairwiseCiphers
                        .set(WifiConfiguration.PairwiseCipher.CCMP);
                config.status = WifiConfiguration.Status.ENABLED;
                break;
        }
        return config;
    }

    public void disConnectionWifi() {
        try {
            mWifiManager.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("网络断开异常：" + e);
        }
    }


    /**
     * 获取扫描wifi的加密方式
     *
     * @return wifi的三种加密方式  wpa  wep 无密码
     */
    public int getWifiEncryptType(ScanResult scanResult) {
        int encryptType = -1;
        if (scanResult.capabilities.contains("WPA") || scanResult.capabilities.contains("wpa")) {
            encryptType = WIFICIPHER_WPA;
        } else if (scanResult.capabilities.contains("WEP") || scanResult.capabilities.contains("wep")) {
            encryptType = WIFICIPHER_WEP;
        } else {
            encryptType = WIFICIPHER_NOPASS;
        }
        return encryptType;
    }

    public List<ScanResult> getCurrentWifiScanResult() {
        if (mWifiManager == null) {
            return null;
        }
        return mWifiManager.getScanResults();
    }

    /**
     * 获得IP地址，分为两种情况，一是wifi下，二是移动网络下，得到的ip地址是不一样的
     *
     * @return
     */
    public String getIPAddress(Context context) {
        NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                //调用方法将int转换为地址字符串
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

}