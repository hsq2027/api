package com.ldrobot.utils.util.socketudpconnect;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lenovo on 2016/4/1.
 */
public class SocketUdpPackageManager {
    public static final String SET_ID = "setID";
    public static final String GET_ID = "getID";
    public static final String SET_AP = "setAp";
    public static final String SET_STA = "setSta";
    public static final String APPLY_CFG = "applyCfg";
    public static final String GET_SN = "getSn";
    public static final String GET_WIFI = "getWifi";

    private static Gson mGson = new Gson();

    public static String setId(String userId, String sn) {
        Map<String, String> map = new HashMap<>();
        map.put("cmd", SET_ID);
        map.put("id", userId);
        map.put("deviceSN", sn);
        String data = mGson.toJson(map);
        return data;
    }

    public static String setAp(String SSID, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("cmd", SET_AP);
        map.put("apName", SSID);
        map.put("apPwd", password);
        String data = mGson.toJson(map);
        return data;
    }

    public static String setSta(String SSID, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("cmd", SET_STA);
        map.put("staName", SSID);
        map.put("staPwd", password);
        String data = mGson.toJson(map);
        return data;
    }

    public static String applyCfg() {
        Map<String, String> map = new HashMap<>();
        map.put("cmd", APPLY_CFG);
        String data = mGson.toJson(map);
        return data;
    }

    public static String getSN() {
        Map<String, String> map = new HashMap<>();
        map.put("cmd", GET_SN);
        String data = mGson.toJson(map);
        return data;
    }

    public static String getWifi() {
        Map<String, String> map = new HashMap<>();
        map.put("cmd", GET_WIFI);
        String data = mGson.toJson(map);
        return data;
    }
}