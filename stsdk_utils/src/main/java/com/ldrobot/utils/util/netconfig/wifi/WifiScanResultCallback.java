package com.ldrobot.utils.util.netconfig.wifi;

import android.net.wifi.ScanResult;

import java.util.List;

/**
 * @author 5#
 * @time 2021/5/12 11:12
 */
public interface WifiScanResultCallback {
    void onScanNotify(List<ScanResult> scanResults);
}