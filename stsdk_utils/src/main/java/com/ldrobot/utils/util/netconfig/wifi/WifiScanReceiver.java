package com.ldrobot.utils.util.netconfig.wifi;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import com.google.gson.Gson;
import com.ldrobot.utils.util.LogUtils;
import com.ldrobot.utils.util.WriteLogUtil;

import java.util.List;

public class WifiScanReceiver extends BroadcastReceiver {

    private final String TAG = "WifiScanReceiver";
    private WifiFunction wifiFunction;
    private WifiScanResultCallback wifiScanResultCallback;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            boolean success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false);
            if (wifiFunction != null) {
                List<ScanResult> scanResults = wifiFunction.getCurrentWifiScanResult();
                if (wifiScanResultCallback != null) {
                    wifiScanResultCallback.onScanNotify(scanResults);
                }
                try {
                    String resultList = new Gson().toJson(scanResults);
                    if (success) {
                        //使用新的结果
                        LogUtils.e("scan wifi list：new=====" + resultList);
                        WriteLogUtil.getInstance().writeLog("scan wifi list：new=====" + resultList, WriteLogUtil.CREAT_TYPE);
                    } else {
                        //失败，使用旧的结果
                        LogUtils.e("scan wifi list：old=====" + resultList);
                        WriteLogUtil.getInstance().writeLog("scan wifi list：old=====" + resultList, WriteLogUtil.CREAT_TYPE);
                    }
                } catch (Exception e) {
                    WriteLogUtil.getInstance().writeLog("scan wifi list log error：" + e, WriteLogUtil.CREAT_TYPE);
                }
            }
        }
    }

    public void setWifiScanResultCallback(WifiFunction wifiFunction, WifiScanResultCallback wifiScanResultCallback) {
        this.wifiFunction = wifiFunction;
        this.wifiScanResultCallback = wifiScanResultCallback;
    }
}