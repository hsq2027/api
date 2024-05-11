package com.ldrobot.bean.interfaces;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/7 14:10
 * @Description: 配网步骤回调
 */
public interface NetworkConfigStepListener {
    void sendMsgToRobot();

    void appConnectToFamilyWifi();

    void robotConnectToFamilyWifi();

    void bindDevice();
}