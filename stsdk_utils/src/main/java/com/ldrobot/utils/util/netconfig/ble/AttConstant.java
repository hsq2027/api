package com.ldrobot.utils.util.netconfig.ble;


import com.google.gson.Gson;
import com.ldrobot.utils.bean.ble.RealDataBean;
import com.ldrobot.utils.util.StringUtil;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class AttConstant {
    public static final UUID M_SERVICE_UUID = UUID.fromString("00010203-0405-0607-0809-0a0b0c0d4c44");
    public static final UUID M_CHARACTERISTIC_UUID_R = UUID.fromString("00010203-0405-0607-0809-0a0b0c0d4c64");//读
    public static final UUID M_CHARACTERISTIC_UUID_W = UUID.fromString("00010203-0405-0607-0809-0a0b0c0d6c64");//写

    public static final String SPLIT_CMD = "\r\n";
    public static final String TEMP_CMD = "";

    public class BleCmd {
        //app-->robot
        public static final String CONFIG_WIFI = "config_wifi";
        public static final String GET_WIFI_LIST = "get_wifi_list";
        public static final String GET_WIFI_STATE = "get_wifi_state";
        public static final String GET_LOG = "get_log";
        //robot-->app
        public static final String UPLOAD_WIFI_LIST = "upload_wifi_list";
        public static final String UPLOAD_WIFI_STATE = "upload_wifi_state";
        public static final String UPLOAD_LOG = "upload_log";
    }

    public class RobotWifiState {
        public static final int WIFI_CONFIG_BEGIN = 100;
        public static final int WIFI_GET_IP_SUCCESS = 101;
        public static final int WIFI_GET_IP_DEFAIL = 200;
        public static final int WIFI_CONNECT_NET = 102;
        public static final int WIFI_CONNECT_OUTTIME = 201;
    }

    public static String getCmdStr(String cmd, Object value) {
        RealDataBean realDataBean = new RealDataBean();
        realDataBean.setCmd(cmd);
        realDataBean.setValue(value);
        return new Gson().toJson(realDataBean);
    }

    /**
     * 生成Token
     *
     * @return
     */
    public static String createToken(String random,String wifiPwd) {
        String temp = random + StringUtil.toHex(wifiPwd);
        return StringUtil.shaEncrypt(temp);
    }

    /**
     * 创建3个字节的随机数
     *
     * @return
     */
    public static String createRandom() {
        byte[] bytes = new byte[3];
        Random random = ThreadLocalRandom.current();
        random.nextBytes(bytes);
        return StringUtil.bytes2Hex(bytes);
    }

}