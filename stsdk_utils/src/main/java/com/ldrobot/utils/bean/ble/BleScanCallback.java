package com.ldrobot.utils.bean.ble;

import java.util.ArrayList;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/6 11:28
 * @Description: java类作用描述
 */
public interface BleScanCallback {
    void onScanNotify(ArrayList<BleDeviceBean> bluetoothDevices);

    void onTick(long millisUntilFinished);

    void onScanFinish(int scanTimes);
}