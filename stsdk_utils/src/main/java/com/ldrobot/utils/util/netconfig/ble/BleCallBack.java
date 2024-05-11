package com.ldrobot.utils.util.netconfig.ble;

public interface BleCallBack {
    void onConnectState(int state); // state 1：断开连接  2:需要重连  3.连接失败  4.可以发数据

    void onReceiver(String msg);
}