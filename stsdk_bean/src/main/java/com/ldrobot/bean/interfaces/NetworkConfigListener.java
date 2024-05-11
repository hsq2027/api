package com.ldrobot.bean.interfaces;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/6 11:45
 * @Description: java类作用描述
 */
public interface NetworkConfigListener {

    void onSuccess(String devId);

    void onFailure(String errorCode, String errorMsg);

    void onProgress(int progress);

    /**
     * @param toWifiSettingsType 具体参考{@link ToWifiSettingsType}
     */
    void onNeedGoToWifiSettings(int toWifiSettingsType);

    /**
     * 跳转设置连接的WiFi类型，根据次参数提示用户连接那种WiFi
     */
    interface ToWifiSettingsType {
        int CONNECT_ROBOT_HOTSPOT = 1;//连接扫地机热点
        int CONNECT_FAMILY_WIFI = 2;//连接回家庭WiFi
        int CONNECT_FAMILY_WIFI_BEFORE_CONFIG = 3;//配网前连接家庭WiFi，防止部分手机自动切换到扫地机热点而导致配网失败
    }
}