package com.ldrobot.utils.bean.ble;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class BleDeviceBean implements Parcelable {
    String id;
    String name;
    String providerName;
    String data;
    String configType;
    String productId;
    String uuid;
    String mac;
    String address;
    int deviceType;
    boolean isbind = false;
    int flag = 0;
    private byte[] raw;
    private boolean isShare;
    private boolean isRoam;
    private byte[] pidRaw;
    int rssi = 0;

    public BleDeviceBean() {
    }

    public boolean isRoam() {
        return this.isRoam;
    }

    public void setRoam(boolean roam) {
        this.isRoam = roam;
    }

    public boolean getIsbind() {
        return this.isbind;
    }

    public void setIsbind(boolean isbind) {
        this.isbind = isbind;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String parmId) {
        this.id = parmId;
    }

    /** @deprecated */
    @Deprecated
    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String name) {
        this.providerName = name;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String d) {
        this.data = d;
    }

    public String getConfigType() {
        return this.configType;
    }

    public void setConfigType(String type) {
        this.configType = type;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setRaw(byte[] raw) {
        this.raw = raw;
    }

    public byte[] getRaw() {
        return this.raw;
    }

    public void setShare(boolean isShare) {
        this.isShare = isShare;
    }

    public boolean isShare() {
        return this.isShare;
    }

    public String toString() {
        return "ScanDeviceBean{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", providerName='" + this.providerName + '\'' + ", data='" + this.data + '\'' + ", configType='" + this.configType + '\'' + ", productId='" + this.productId + '\'' + ", uuid='" + this.uuid + '\'' + ", mac='" + this.mac + '\'' + ", address='" + this.address + '\'' + ", deviceType='" + this.deviceType + '\'' + ", isbind=" + this.isbind + ", flag=" + this.flag + ", rssi='" + this.rssi + '\'' + '}';
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public byte[] getPidRaw() {
        return this.pidRaw;
    }

    public void setPidRaw(byte[] pidRaw) {
        this.pidRaw = pidRaw;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.providerName);
        dest.writeString(this.data);
        dest.writeString(this.configType);
        dest.writeString(this.productId);
        dest.writeString(this.uuid);
        dest.writeString(this.mac);
        dest.writeString(this.address);
        dest.writeInt(this.deviceType);
        dest.writeByte(this.isbind ? (byte) 1 : (byte) 0);
        dest.writeInt(this.flag);
        dest.writeByteArray(this.raw);
        dest.writeByte(this.isShare ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isRoam ? (byte) 1 : (byte) 0);
        dest.writeByteArray(this.pidRaw);
        dest.writeInt(this.rssi);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readString();
        this.name = source.readString();
        this.providerName = source.readString();
        this.data = source.readString();
        this.configType = source.readString();
        this.productId = source.readString();
        this.uuid = source.readString();
        this.mac = source.readString();
        this.address = source.readString();
        this.deviceType = source.readInt();
        this.isbind = source.readByte() != 0;
        this.flag = source.readInt();
        this.raw = source.createByteArray();
        this.isShare = source.readByte() != 0;
        this.isRoam = source.readByte() != 0;
        this.pidRaw = source.createByteArray();
        this.rssi = source.readInt();
    }

    protected BleDeviceBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.providerName = in.readString();
        this.data = in.readString();
        this.configType = in.readString();
        this.productId = in.readString();
        this.uuid = in.readString();
        this.mac = in.readString();
        this.address = in.readString();
        this.deviceType = in.readInt();
        this.isbind = in.readByte() != 0;
        this.flag = in.readInt();
        this.raw = in.createByteArray();
        this.isShare = in.readByte() != 0;
        this.isRoam = in.readByte() != 0;
        this.pidRaw = in.createByteArray();
        this.rssi = in.readInt();
    }

    public static final Creator<BleDeviceBean> CREATOR = new Creator<BleDeviceBean>() {
        @Override
        public BleDeviceBean createFromParcel(Parcel source) {
            return new BleDeviceBean(source);
        }

        @Override
        public BleDeviceBean[] newArray(int size) {
            return new BleDeviceBean[size];
        }
    };
}
