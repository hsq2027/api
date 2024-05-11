package com.ldrobot.bean;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/15 17:31
 * @Description: java类作用描述
 */
public class GetVerificationCodeParams {
    private String username;
    private int type;
    private String areaCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}