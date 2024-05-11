package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/5/10 15:12
 * @Description: java类作用描述
 */
public class DeviceMessageBean {

    private boolean isExpand;
    private String deviceNickname;
    private String devId;
    private String iconUrl;
    private List<MsgDeviceBean> msgDeviceBeanList;

    public String getDeviceNickname() {
        return deviceNickname;
    }

    public void setDeviceNickname(String deviceNickname) {
        this.deviceNickname = deviceNickname;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public List<MsgDeviceBean> getMsgDeviceBeanList() {
        return msgDeviceBeanList;
    }

    public void setMsgDeviceBeanList(List<MsgDeviceBean> msgDeviceBeanList) {
        this.msgDeviceBeanList = msgDeviceBeanList;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}