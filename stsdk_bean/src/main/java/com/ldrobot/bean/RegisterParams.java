package com.ldrobot.bean;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/15 18:55
 * @Description: java类作用描述
 */
public class RegisterParams {
    private String areaCode;
    private String userName;
    private String password;
    private String verificationCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}