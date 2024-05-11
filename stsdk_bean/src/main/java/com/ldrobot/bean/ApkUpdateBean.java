package com.ldrobot.bean;

import java.io.Serializable;

/**
 * 创建时间：2019/12/12  16:01
 * 作者：5#
 * 描述：{"versionCode": 119,"des":"1.test..\n 2.","versionName":"B0.0.1"}
 * 注意：
 */
public class ApkUpdateBean implements Serializable {
    private int versionCode;
    private String des;
    private String versionName;
    private boolean hasNewVersion;
    private int updateType = 1;//  1代表全量升级  2 代表定向升级
    private String accounts; //定向升级才会有意义   账号之间用英文,隔开
    private int targetVersionCode;//要升级的版本 app_release_xxx  用于升级指定的版本   如果这个值不是0，就用用这个值，否则用versionCode
    private String apkName = "ld_ali_release_416_V1.2.4.apk";
    private String apkUrl;//apk下载URL

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isHasNewVersion() {
        return hasNewVersion;
    }

    public void setHasNewVersion(boolean hasNewVersion) {
        this.hasNewVersion = hasNewVersion;
    }

    public int getUpdateType() {
        return updateType;
    }

    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }


    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public int getTargetVersionCode() {
        return targetVersionCode;
    }

    public void setTargetVersionCode(int targetVersionCode) {
        this.targetVersionCode = targetVersionCode;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    @Override
    public String toString() {
        return "ApkUpdateBean{" +
                "versionCode=" + versionCode +
                ", des='" + des + '\'' +
                ", versionName='" + versionName + '\'' +
                ", hasNewVersion=" + hasNewVersion +
                ", updateType=" + updateType +
                ", accounts='" + accounts + '\'' +
                ", targetVersionCode=" + targetVersionCode +
                ", apkName='" + apkName + '\'' +
                '}';
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }
}