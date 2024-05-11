package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/29 14:53
 * @Description: java类作用描述
 */
public class FirmwareVersionBean {
    /**
     * gmtModified : 1632797381000
     * activeTime : 1632797381504
     * deviceKey : UJmYiV1GtOS3vucQprhM
     * statusLast : 3
     * gmtCreate : 1632795862000
     * productKey : a1fToOzPEpA
     * mac : 03:AC:DE:FF:00:32
     * netAddress : 113.110.230.163
     * iotId : UJmYiV1GtOS3vucQprhM000000
     * deviceSecret : e199fc2b3f4e158a3e7bdcac43a94350
     * name : apptest2021092801
     * thingType : DEVICE
     * region : cn-shanghai
     * firmwareVersion : 0.1.0_2138
     * rbacTenantId : 94F88A6CE9104015A5645B6B581EE108
     * status : 1
     */

    private long gmtModified;
    private long activeTime;
    private String deviceKey;
    private int statusLast;
    private long gmtCreate;
    private String productKey;
    private String mac;
    private String netAddress;
    private String iotId;
    private String deviceSecret;
    private String name;
    private String thingType;
    private String region;
    private String firmwareVersion;
    private String rbacTenantId;
    private int status;

    public long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(long activeTime) {
        this.activeTime = activeTime;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public int getStatusLast() {
        return statusLast;
    }

    public void setStatusLast(int statusLast) {
        this.statusLast = statusLast;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getNetAddress() {
        return netAddress;
    }

    public void setNetAddress(String netAddress) {
        this.netAddress = netAddress;
    }

    public String getIotId() {
        return iotId;
    }

    public void setIotId(String iotId) {
        this.iotId = iotId;
    }

    public String getDeviceSecret() {
        return deviceSecret;
    }

    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThingType() {
        return thingType;
    }

    public void setThingType(String thingType) {
        this.thingType = thingType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getRbacTenantId() {
        return rbacTenantId;
    }

    public void setRbacTenantId(String rbacTenantId) {
        this.rbacTenantId = rbacTenantId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}