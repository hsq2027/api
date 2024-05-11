package com.ldrobot.bean;

/**
 * 创建时间：2020/4/2  0:29
 * 作者：5#
 * 描述：TODO
 */
public class MsgDeviceBean {
    /**
     * deviceType : ALL
     * eventId : 88593
     * gmtModified : 1650873361000
     * isRead : 0
     * keyId : 3041552807937167360
     * messageId : -1
     * gmtCreate : 1650873361000
     * type : MESSAGE
     * title : 清扫完成
     * body : G1-商用G1·清扫完成。
     * target : ACCOUNT
     * iotId : UJmYiV1GtOS3vucQprhM000000
     * messageType : device
     * extData : {"iotId":"UJmYiV1GtOS3vucQprhM000000","icon":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1585735710192.png","productKey":"a1fToOzPEpA","productName":"G1-商用G1","categoryId":158}
     * targetValue : 50bfopb5120406583edf1cf4a98330bed8d96408
     * id : 3041552807937167360
     * tag : 0
     */

    private String deviceType;
    private String eventId;
    private long gmtModified;
    private int isRead;
    private String keyId;
    private String messageId;
    private long gmtCreate;
    private String type;
    private String title;
    private String body;
    private String target;
    private String iotId;
    private String messageType;
    private ExtDataBean extData;
    private String targetValue;
    private String id;
    private int tag;
    private int itemType;//本地
    private int bgType;//本地

    private String body_en; //仅用于虚拟设备，英文显示

    public String getBody_en() {
        return body_en;
    }

    public void setBody_en(String body_en) {
        this.body_en = body_en;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIotId() {
        return iotId;
    }

    public void setIotId(String iotId) {
        this.iotId = iotId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public ExtDataBean getExtData() {
        return extData;
    }

    public void setExtData(ExtDataBean extData) {
        this.extData = extData;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getBgType() {
        return bgType;
    }

    public void setBgType(int bgType) {
        this.bgType = bgType;
    }

    public static class ExtDataBean {
        /**
         * iotId : UJmYiV1GtOS3vucQprhM000000
         * icon : http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1585735710192.png
         * productKey : a1fToOzPEpA
         * productName : G1-商用G1
         * categoryId : 158
         */

        private String iotId;
        private String icon;
        private String productKey;
        private String productName;
        private int categoryId;

        public String getIotId() {
            return iotId;
        }

        public void setIotId(String iotId) {
            this.iotId = iotId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getProductKey() {
            return productKey;
        }

        public void setProductKey(String productKey) {
            this.productKey = productKey;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }
    }
}