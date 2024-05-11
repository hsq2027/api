package com.ldrobot.utils.util.socketudpconnect;

import java.util.ArrayList;

/**
 * Created by Emiya on 17/3/1.
 */

public class SocketUdpResponse {
    public static final String INVALUE = "invalue cmd";
    public static final String OK = "ok";

    private String cmd;
    private String result;
    private String sn;
    //    private String wifi_list;
    private ArrayList<String> wifi_list;
    private boolean isTimeOut;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isTimeOut() {
        return isTimeOut;
    }

    public void setTimeOut(boolean timeOut) {
        isTimeOut = timeOut;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public ArrayList<String> getWifi_list() {
        return wifi_list;
    }

    public void setWifi_list(ArrayList<String> wifi_list) {
        this.wifi_list = wifi_list;
    }

//    public String getWifi_list() {
//        return wifi_list;
//    }
//
//    public void setWifi_list(String wifi_list) {
//        this.wifi_list = wifi_list;
//    }
}