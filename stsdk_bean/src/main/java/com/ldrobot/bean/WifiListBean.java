package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/6 16:19
 * @Description: java类作用描述
 */
public class WifiListBean implements Parcelable {
    private String wifiName;//设备热点名称
    private String robotHotspotId;//设备热点id，从扫描的设备模型中获取（阿里）

    public WifiListBean(String wifiName, String robotHotspotId) {
        this.wifiName = wifiName;
        this.robotHotspotId = robotHotspotId;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getRobotHotspotId() {
        return robotHotspotId;
    }

    public void setRobotHotspotId(String robotHotspotId) {
        this.robotHotspotId = robotHotspotId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.wifiName);
        dest.writeString(this.robotHotspotId);
    }

    protected WifiListBean(Parcel in) {
        this.wifiName = in.readString();
        this.robotHotspotId = in.readString();
    }

    public static final Creator<WifiListBean> CREATOR = new Creator<WifiListBean>() {
        @Override
        public WifiListBean createFromParcel(Parcel source) {
            return new WifiListBean(source);
        }

        @Override
        public WifiListBean[] newArray(int size) {
            return new WifiListBean[size];
        }
    };
}