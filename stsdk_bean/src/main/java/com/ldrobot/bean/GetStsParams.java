package com.ldrobot.bean;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/30 11:59
 * @Description: java类作用描述
 */
public class GetStsParams {
    private String deviceName;//设备SN
    private String deviceSecret;//从接口AliApi.GET_DEVICE_INFO接口中获取

    public GetStsParams(String deviceName, String deviceSecret) {
        this.deviceName = deviceName;
        this.deviceSecret = deviceSecret;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSecret() {
        return deviceSecret;
    }

    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }
}