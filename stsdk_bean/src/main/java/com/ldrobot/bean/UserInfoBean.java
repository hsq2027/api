package com.ldrobot.bean;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/14 17:22
 * @Description: java类作用描述
 */
public class UserInfoBean {
    private String productId;
    private String userId;
    private String userName;
    private String nickName;
    private String email;
    private String phone;
    private String areaCode;
    private String password;
    private String sex;
    private String avatar;
    private String aliIdentityId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAliIdentityId() {
        return aliIdentityId;
    }

    public void setAliIdentityId(String aliIdentityId) {
        this.aliIdentityId = aliIdentityId;
    }
}