package com.ldrobot.bean;

import java.util.List;

/**
 * 创建时间：2019/11/7  9:25
 * 作者：5#
 * 描述：TODO
 * 注意：
 * initiatorAlias 	String 	发起分享用户别名
 * receiverAlias 	String 	被分享用户别名
 * targetId 	String 	共享的物的ID
 * targetType 	String 	共享的物的类型
 * productImage 	String 	设备产品图片
 * deviceName 	String 	设备的deviceName
 * isReceiver 	Integer 	当前用户是否是消息接收者
 * gmtCreate 	Long 	创建时间
 * gmtModified 	Long 	修改时间
 * recordId 	String 	分享记录唯一标识
 * status 	Integer 	状态: -1: 初始化; 0:同意; 1:拒绝; 2:取消; 3:过期; 4:抢占; 5:删除; 6:发起者已解绑; 99:异常
 * description 	String 	描述
 * categoryImage 	String 	品类图标
 * productName 	String 	产品名称
 */
public class ShareBean {

    /**
     * total : 1
     * data : [{"gmtModified":1573089818000,"targetId":"Xd2AbE3moxbQ7RTqibj2000100","categoryImage":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631104386.png","description":"13627296710共享的设备已超时","targetType":"DEVICE","gmtCreate":1573089818000,"deviceName":"LD_ABC002","productName":"乐动机器人LD-ROBOTA0","recordId":"29c645cbabfe4a5098bd5629664b726b","productImage":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631109790.png","isReceiver":1,"receiverAlias":"13058056542","initiatorAlias":"13627296710","status":3}]
     * pageNo : 1
     * pageSize : 10
     */

    private int total;
    private int pageNo;
    private int pageSize;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * gmtModified : 1573089818000
         * targetId : Xd2AbE3moxbQ7RTqibj2000100
         * categoryImage : http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631104386.png
         * description : 13627296710共享的设备已超时
         * targetType : DEVICE
         * gmtCreate : 1573089818000
         * deviceName : LD_ABC002
         * productName : 乐动机器人LD-ROBOTA0
         * recordId : 29c645cbabfe4a5098bd5629664b726b
         * productImage : http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631109790.png
         * isReceiver : 1
         * receiverAlias : 13058056542
         * initiatorAlias : 13627296710
         * status : 3
         */

        private long gmtModified;
        private String targetId;
        private String categoryImage;
        private String description;
        private String targetType;
        private long gmtCreate;
        private String deviceName;
        private String productName;
        private String recordId;
        private String productImage;
        private int isReceiver;  //当前用户是否是消息接收者  0 否  1是
        private String receiverAlias;
        private String initiatorAlias;
        private int status;

        public long getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(long gmtModified) {
            this.gmtModified = gmtModified;
        }

        public String getTargetId() {
            return targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

        public void setCategoryImage(String categoryImage) {
            this.categoryImage = categoryImage;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTargetType() {
            return targetType;
        }

        public void setTargetType(String targetType) {
            this.targetType = targetType;
        }

        public long getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(long gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public int getIsReceiver() {
            return isReceiver;
        }

        public void setIsReceiver(int isReceiver) {
            this.isReceiver = isReceiver;
        }

        public String getReceiverAlias() {
            return receiverAlias;
        }

        public void setReceiverAlias(String receiverAlias) {
            this.receiverAlias = receiverAlias;
        }

        public String getInitiatorAlias() {
            return initiatorAlias;
        }

        public void setInitiatorAlias(String initiatorAlias) {
            this.initiatorAlias = initiatorAlias;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}