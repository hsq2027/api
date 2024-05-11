package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MOSL
 * Date 2021/4/2
 */
public class FeedbackDataBean implements Parcelable {
    /**
     * gmtModified : 1617331429
     * appVersion : V1.6.3000
     * gmtLastFeedback : 1617268652000
     * type : 1
     * productKey : a2e3nbNt4Kz
     * content : 1Router model (optional)2Product model (optional)4
     * uid : 5047opc3f5e72c4cccd4ae9a7959400fca936373
     * gmtLastReply : 1617331429000
     * mobileModel : MIX 2
     * contact : 3
     * id : 11671
     * feedbackStatus : 0
     * mobileSystem : Android9
     * isolationId : a203jvmvfkpGgaB8
     * gmtCreate : 1617268652000
     * iotId : HpFG7NeTOkNzxXveXO97000000
     * lastFeedback : 1Router model (optional)2Product model (optional)4
     * lastReply : 121313
     * tenantId : 8F5DA61EFE2D47C7BB8E62289C041323
     * topic :
     * replyStatus : 0
     * devicename : RV507W2007002003
     */

    private long gmtModified;
    private String appVersion;
    private long gmtLastFeedback;
    private int type;
    private String productKey;
    private String content;
    private String uid;
    private long gmtLastReply;
    private String mobileModel;
    private String contact;
    private String id;
    private int feedbackStatus;
    private String mobileSystem;
    private String isolationId;
    private long gmtCreate;
    private String iotId;
    private String lastFeedback;
    private String lastReply;
    private String tenantId;
    private String topic;
    private int replyStatus;
    private String devicename;

    public FeedbackDataBean() {

    }

    protected FeedbackDataBean(Parcel in) {
        gmtModified = in.readLong();
        appVersion = in.readString();
        gmtLastFeedback = in.readLong();
        type = in.readInt();
        productKey = in.readString();
        content = in.readString();
        uid = in.readString();
        gmtLastReply = in.readLong();
        mobileModel = in.readString();
        contact = in.readString();
        id = in.readString();
        feedbackStatus = in.readInt();
        mobileSystem = in.readString();
        isolationId = in.readString();
        gmtCreate = in.readLong();
        iotId = in.readString();
        lastFeedback = in.readString();
        lastReply = in.readString();
        tenantId = in.readString();
        topic = in.readString();
        replyStatus = in.readInt();
        devicename = in.readString();
    }

    public static final Creator<FeedbackDataBean> CREATOR = new Creator<FeedbackDataBean>() {
        @Override
        public FeedbackDataBean createFromParcel(Parcel in) {
            return new FeedbackDataBean(in);
        }

        @Override
        public FeedbackDataBean[] newArray(int size) {
            return new FeedbackDataBean[size];
        }
    };

    public long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public long getGmtLastFeedback() {
        return gmtLastFeedback;
    }

    public void setGmtLastFeedback(long gmtLastFeedback) {
        this.gmtLastFeedback = gmtLastFeedback;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getGmtLastReply() {
        return gmtLastReply;
    }

    public void setGmtLastReply(long gmtLastReply) {
        this.gmtLastReply = gmtLastReply;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(int feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public String getMobileSystem() {
        return mobileSystem;
    }

    public void setMobileSystem(String mobileSystem) {
        this.mobileSystem = mobileSystem;
    }

    public String getIsolationId() {
        return isolationId;
    }

    public void setIsolationId(String isolationId) {
        this.isolationId = isolationId;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getIotId() {
        return iotId;
    }

    public void setIotId(String iotId) {
        this.iotId = iotId;
    }

    public String getLastFeedback() {
        return lastFeedback;
    }

    public void setLastFeedback(String lastFeedback) {
        this.lastFeedback = lastFeedback;
    }

    public String getLastReply() {
        return lastReply;
    }

    public void setLastReply(String lastReply) {
        this.lastReply = lastReply;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(int replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(gmtModified);
        dest.writeString(appVersion);
        dest.writeLong(gmtLastFeedback);
        dest.writeInt(type);
        dest.writeString(productKey);
        dest.writeString(content);
        dest.writeString(uid);
        dest.writeLong(gmtLastReply);
        dest.writeString(mobileModel);
        dest.writeString(contact);
        dest.writeString(id);
        dest.writeInt(feedbackStatus);
        dest.writeString(mobileSystem);
        dest.writeString(isolationId);
        dest.writeLong(gmtCreate);
        dest.writeString(iotId);
        dest.writeString(lastFeedback);
        dest.writeString(lastReply);
        dest.writeString(tenantId);
        dest.writeString(topic);
        dest.writeInt(replyStatus);
        dest.writeString(devicename);
    }
}