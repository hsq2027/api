package com.ldrobot.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DeviceBean implements Serializable {


    /**
     * gmtModified : 1531360639000
     * categoryImage : http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1526474704326.png
     * netType : NET_WIFI
     * nodeType : DEVICE
     * productKey : a1XoFUJWkPr
     * deviceName : VD_l2c4LuifwY
     * productName : 风扇-Demo
     * identityAlias : 15700192592
     * iotId : g1VQsQvQvHdkuGjI5unE0010eedc00
     * owned : 0
     * identityId : 5072op548214e63f60e5c5bb17631d9201ea1295
     * thingType : VIRTUAL
     * status : 1
     */

    private String deviceId;
    private String deviceName;
    private String deviceImg;
    private String productKey;
    private int owned;  //0:分享者；1：拥有者
    private int status;  //设备的状态，可取值：0（未激活），1（在线），3（离线），8（禁用）
    private long statusTimestamp;
    private String nickName;

    private boolean isSweeping;//本地状态
    private boolean isBackCharging;//本地状态
    private boolean isOpen;//本地状态
    private String subMode;
    private String mode;
    private int led;
    private int volume;
    private int elecReal;
    private String modeStr;
    private String appointStr;//预约、勿扰
    private String productId;

    private int viewType;//设备列表item类型，默认为0：扫地机设备列表。1：模拟扫地机预览模式体验入口
    private List<?> dataList;//viewType为1时的数据列表

    private Map<String, Object> dps;//涂鸦使用

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getModeStr() {
        return modeStr;
    }

    public void setModeStr(String modeStr) {
        this.modeStr = modeStr;
    }

    public int getElecReal() {
        return elecReal;
    }

    public void setElecReal(int elecReal) {
        this.elecReal = elecReal;
    }

    public boolean isSweeping() {
        return isSweeping;
    }

    public void setSweeping(boolean sweeping) {
        isSweeping = sweeping;
    }

    public String getSubMode() {
        return subMode;
    }

    public void setSubMode(String subMode) {
        this.subMode = subMode;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DeviceBean{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceImg='" + deviceImg + '\'' +
                ", productKey='" + productKey + '\'' +
                ", owned=" + owned +
                ", status=" + status +
                ", timestamp=" + statusTimestamp +
                ", nickName='" + nickName + '\'' +
                ", isSweeping=" + isSweeping +
                ", isBackCharging=" + isBackCharging +
                ", isOpen=" + isOpen +
                ", subMode='" + subMode + '\'' +
                ", mode='" + mode + '\'' +
                ", led=" + led +
                ", volume=" + volume +
                ", elecReal=" + elecReal +
                ", modeStr='" + modeStr + '\'' +
                ", appointStr='" + appointStr + '\'' +
                ", productId='" + productId + '\'' +
                ", viewType=" + viewType +
                ", dataList=" + dataList +
                ", dps=" + dps +
                '}';
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public String getDeviceImg() {
        return deviceImg;
    }

    public void setDeviceImg(String deviceImg) {
        this.deviceImg = deviceImg;
    }

    public Map<String, Object> getDps() {
        return dps;
    }

    public void setDps(Map<String, Object> dps) {
        this.dps = dps;
    }

    public boolean isBackCharging() {
        return isBackCharging;
    }

    public void setBackCharging(boolean backCharging) {
        isBackCharging = backCharging;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getLed() {
        return led;
    }

    public void setLed(int led) {
        this.led = led;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getAppointStr() {
        return appointStr;
    }

    public void setAppointStr(String appointStr) {
        this.appointStr = appointStr;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getStatusTimestamp() {
        return statusTimestamp;
    }

    public void setStatusTimestamp(long statusTimestamp) {
        this.statusTimestamp = statusTimestamp;
    }
}