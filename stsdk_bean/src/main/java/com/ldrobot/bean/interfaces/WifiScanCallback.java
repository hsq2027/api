package com.ldrobot.bean.interfaces;

import com.ldrobot.bean.WifiListBean;

import java.util.ArrayList;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/6 11:28
 * @Description: java类作用描述
 */
public interface WifiScanCallback {
    void onScanNotify(ArrayList<WifiListBean> wifiList);

    void onTick(long millisUntilFinished);

    void onScanFinish(int scanTimes);
}