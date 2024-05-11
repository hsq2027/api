package com.ldrobot.bean.interfaces;

import android.net.Network;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/6 15:28
 * @Description: java类作用描述
 */
public interface WifiConnectListener {
    void onConnectFinish(boolean isSuccess, String msg, String tag, Network network);
}