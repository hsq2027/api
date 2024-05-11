package com.ldrobot.utils.bean;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/28 20:29
 * @Description: java类作用描述
 */
public class EventBusBean {
    private int code;
    private String msg;
    private Object data;
    private boolean booleanData;
    private int intData;
    private String stringData;

    public interface EventCode {
        int DEVICE_NICKNAME_CHANGE = 1;//设备昵称修改广播
        int REFRESH_BIND_DEVICE = 2;//刷新设备列表广播
        int RECEIVE_PUSH_MESSAGE = 3;//收到推送消息广播
        int APP_NETWORK_CHANGE = 4;//APP网络状态变化广播
        int DEVICE_NETWORK_CHANGE = 5;//设备网络状态变化广播
        int LOGIN_EXPIRE = 6;//登录过期
        int ROBOT_FAULT = 7;//机器故障推送（涂鸦）
        int ROBOT_WARN_MSG = 8;//机器告警推送（涂鸦）
        int USER_NICKNAME_CHANGE = 9;//用户昵称修改广播
        int APP_FOREGROUND_CHANGE = 10;//APP前后太切换变化
    }

    public EventBusBean(int code) {
        this.code = code;
    }

    public EventBusBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public EventBusBean(int code, int intData) {
        this.code = code;
        this.intData = intData;
    }

    public EventBusBean(int code, boolean booleanData) {
        this.code = code;
        this.booleanData = booleanData;
    }

    public EventBusBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public EventBusBean(int code, String msg, boolean booleanData) {
        this.code = code;
        this.msg = msg;
        this.booleanData = booleanData;
    }

    public EventBusBean(int code, String msg, int intData, boolean booleanData) {
        this.code = code;
        this.msg = msg;
        this.intData = intData;
        this.booleanData = booleanData;
    }

    public EventBusBean(int code, String msg, String stringData, boolean booleanData) {
        this.code = code;
        this.msg = msg;
        this.stringData = stringData;
        this.booleanData = booleanData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean getBooleanData() {
        return booleanData;
    }

    public void setBooleanData(boolean booleanData) {
        this.booleanData = booleanData;
    }

    public int getIntData() {
        return intData;
    }

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

}