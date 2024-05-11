package com.ldrobot.utils.bean.ble;

/**
 * {
 * "cmd":"config_wifi",
 * "value":{
     * "wifi_name":"my_name",
     * "wifi_pwd":"12345678",
     * "random":"010203"
 * }
 * }
 */
public class SendBleBean {
    private String wifi_name;
    private String wifi_pwd;
    private String random;
    private int regionId;


    public SendBleBean(String wifi_name, String wifi_pwd, String random,int regionId) {
        this.wifi_name = wifi_name;
        this.wifi_pwd = wifi_pwd;
        this.random = random;
        this.regionId = regionId;
    }

    public String getWifi_name() {
        return wifi_name;
    }

    public void setWifi_name(String wifi_name) {
        this.wifi_name = wifi_name;
    }

    public String getWifi_pwd() {
        return wifi_pwd;
    }

    public void setWifi_pwd(String wifi_pwd) {
        this.wifi_pwd = wifi_pwd;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}