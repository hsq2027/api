package com.ldrobot.bean;

import java.util.List;

/**
 * 创建时间：2019/11/7  11:39
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class DeviceBindBean {

    /**
     * total : 2
     * data : [{"productModel":"A0","gmtModified":1573039076000,"categoryImage":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631104386.png","netType":"NET_WIFI","description":"2019年11月4日 下午01时42分32秒 管理员","nodeType":"DEVICE","productKey":"a1AqHQUFWB1","deviceName":"LD_ABC002","productName":"乐动机器人LD-ROBOTA0","identityAlias":"13627296710","iotId":"Xd2AbE3moxbQ7RTqibj2000100","productImage":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631109790.png","owned":1,"identityId":"5075opbff3902d0e79058f4c3678b514fe848036","thingType":"DEVICE","status":1},{"productModel":"A0","gmtModified":1573094853000,"categoryImage":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631104386.png","netType":"NET_WIFI","description":"2019年11月7日 上午10时47分33秒添加共享","nodeType":"DEVICE","productKey":"a1AqHQUFWB1","deviceName":"LD_ABC002","productName":"乐动机器人LD-ROBOTA0","identityAlias":"13058056542","iotId":"Xd2AbE3moxbQ7RTqibj2000100","productImage":"http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631109790.png","owned":0,"identityId":"5037op216ada39927034625d36bfa279e1710180","thingType":"DEVICE","status":1}]
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
         * productModel : A0
         * gmtModified : 1573039076000
         * categoryImage : http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631104386.png
         * netType : NET_WIFI
         * description : 2019年11月4日 下午01时42分32秒 管理员
         * nodeType : DEVICE
         * productKey : a1AqHQUFWB1
         * deviceName : LD_ABC002
         * productName : 乐动机器人LD-ROBOTA0
         * identityAlias : 13627296710
         * iotId : Xd2AbE3moxbQ7RTqibj2000100
         * productImage : http://iotx-paas-admin.oss-cn-shanghai.aliyuncs.com/publish/image/1559631109790.png
         * owned : 1
         * identityId : 5075opbff3902d0e79058f4c3678b514fe848036
         * thingType : DEVICE
         * status : 1
         */

        private String productModel;
        private long gmtModified;
        private String categoryImage;
        private String netType;
        private String description;
        private String nodeType;
        private String productKey;
        private String deviceName;
        private String productName;
        private String identityAlias;
        private String iotId;
        private String productImage;
        private int owned;
        private String identityId;
        private String thingType;
        private int status;
        private String nickName;

        private String avatar; //本地字段
        private String userName;
        private boolean isDelete; //本地字段

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public boolean isDelete() {
            return isDelete;
        }

        public void setDelete(boolean delete) {
            isDelete = delete;
        }

        public String getProductModel() {
            return productModel;
        }

        public void setProductModel(String productModel) {
            this.productModel = productModel;
        }

        public long getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(long gmtModified) {
            this.gmtModified = gmtModified;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

        public void setCategoryImage(String categoryImage) {
            this.categoryImage = categoryImage;
        }

        public String getNetType() {
            return netType;
        }

        public void setNetType(String netType) {
            this.netType = netType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getNodeType() {
            return nodeType;
        }

        public void setNodeType(String nodeType) {
            this.nodeType = nodeType;
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

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getIdentityAlias() {
            return identityAlias;
        }

        public void setIdentityAlias(String identityAlias) {
            this.identityAlias = identityAlias;
        }

        public String getIotId() {
            return iotId;
        }

        public void setIotId(String iotId) {
            this.iotId = iotId;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public int getOwned() {
            return owned;
        }

        public void setOwned(int owned) {
            this.owned = owned;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }

        public String getThingType() {
            return thingType;
        }

        public void setThingType(String thingType) {
            this.thingType = thingType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}