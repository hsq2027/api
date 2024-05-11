package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: HSQ
 * @CreateTime: 2021/4/1 16:38
 * @Description: java类作用描述
 */
public class FeedbackMessageBean {
    /**
     * gmtModified : 1617263749000
     * appVersion : V1.6.3
     * gmtLastFeedback : 1617263749000
     * type : 1
     * productKey : a2e3nbNt4Kz
     * content : BbbbbbbbbbbbhRouter model (optional)BhhhProduct model (optional)99999
     * uid : 50eeop7c1716c3769e6c5664837cacafc4258096
     * gmtLastReply : 1617186861000
     * mobileModel : MIX 2
     * contact : Bbbjjjj
     * tenantNickName : 乐动机器人
     * userNickName : shuai
     * id : 11660
     * feedbackStatus : 0
     * mobileSystem : Android9
     * isolationId : a203jvmvfkpGgaB8
     * gmtCreate : 1617186861000
     * iotId : RxLEDVHGeaAUusCYDbKT000102
     * lastFeedback : GgRouter model (optional)GProduct model (optional)Q
     * tenantId : 8F5DA61EFE2D47C7BB8E62289C041323
     * topic :
     * replyStatus : 1
     * devicename :
     * feedBackReplyList : [{"mobileSystem":"Android9","gmtModified":1617263749000,"appVersion":"V1.6.3","type":1,"gmtCreate":1617263749000,"content":"GgRouter model (optional)GProduct model (optional)Q","uid":"50eeop7c1716c3769e6c5664837cacafc4258096","topicid":11660,"mobileModel":"MIX 2","id":4827},{"mobileSystem":"Android9","gmtModified":1617258537000,"appVersion":"V1.6.3","type":1,"gmtCreate":1617258537000,"content":"BhhhjjjRouter model (optional)HvvhhProduct model (optional)Nnnn","uid":"50eeop7c1716c3769e6c5664837cacafc4258096","topicid":11660,"mobileModel":"MIX 2","id":4826}]
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
    private String tenantNickName;
    private String userNickName;
    private int id;
    private int feedbackStatus;
    private String mobileSystem;
    private String isolationId;
    private long gmtCreate;
    private String iotId;
    private String lastFeedback;
    private String tenantId;
    private String topic;
    private int replyStatus;
    private String devicename;
    private List<FeedBackReplyListBean> feedBackReplyList;

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

    public String getTenantNickName() {
        return tenantNickName;
    }

    public void setTenantNickName(String tenantNickName) {
        this.tenantNickName = tenantNickName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<FeedBackReplyListBean> getFeedBackReplyList() {
        return feedBackReplyList;
    }

    public void setFeedBackReplyList(List<FeedBackReplyListBean> feedBackReplyList) {
        this.feedBackReplyList = feedBackReplyList;
    }

    public static class FeedBackReplyListBean {
        /**
         * mobileSystem : Android9
         * gmtModified : 1617263749000
         * appVersion : V1.6.3
         * type : 1
         * gmtCreate : 1617263749000
         * content : GgRouter model (optional)GProduct model (optional)Q
         * uid : 50eeop7c1716c3769e6c5664837cacafc4258096
         * topicid : 11660
         * mobileModel : MIX 2
         * id : 4827
         */

        private String mobileSystem;
        private long gmtModified;
        private String appVersion;
        private int type;
        private long gmtCreate;
        private String content;
        private String uid;
        private int topicid;
        private String mobileModel;
        private int id;

        public String getMobileSystem() {
            return mobileSystem;
        }

        public void setMobileSystem(String mobileSystem) {
            this.mobileSystem = mobileSystem;
        }

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public long getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(long gmtCreate) {
            this.gmtCreate = gmtCreate;
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

        public int getTopicid() {
            return topicid;
        }

        public void setTopicid(int topicid) {
            this.topicid = topicid;
        }

        public String getMobileModel() {
            return mobileModel;
        }

        public void setMobileModel(String mobileModel) {
            this.mobileModel = mobileModel;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}