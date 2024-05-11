package com.ldrobot.bean;

import java.io.Serializable;

/**
 * 创建时间：2019/12/17  18:01
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class FirmwareUpdateBean implements Serializable {

    /**
     * size : 3405781
     * name : ldcp3
     * sign : 4470f4beab8ec863d7e1b004de674423
     * version : 0.11.61_1111
     * url : https://ota.iot-thing.cn-shanghai.aliyuncs.com/ota/03ac8f6c46d380b0dd6e002f8e7c740b/ck42g08kv0000366juq286cfe.gz?Expires=1576663232&OSSAccessKeyId=cS8uRRy54RszYWna&Signature=tk9qvvgqg%2FaI8hLSrx20eNJoYs8%3D
     * signMethod : MD5
     * currentVersion : 0.11.59_1108
     * desc :
     * timestamp : 1576138235000
     * md5 : 4470f4beab8ec863d7e1b004de674423
     */

    private String size;
    private String name;
    private String sign;
    private String version;
    private String url;
    private String signMethod;
    private String currentVersion;
    private String desc;
    private long timestamp;
    private String md5;

    private boolean hseNewVersion;//本地标记位

    public boolean isHseNewVersion() {
        return hseNewVersion;
    }

    public void setHseNewVersion(boolean hseNewVersion) {
        this.hseNewVersion = hseNewVersion;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "FirwareUpdateBean{" +
                "size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                ", version='" + version + '\'' +
                ", url='" + url + '\'' +
                ", signMethod='" + signMethod + '\'' +
                ", currentVersion='" + currentVersion + '\'' +
                ", desc='" + desc + '\'' +
                ", timestamp=" + timestamp +
                ", md5='" + md5 + '\'' +
                ", hseNewVersion=" + hseNewVersion +
                '}';
    }
}