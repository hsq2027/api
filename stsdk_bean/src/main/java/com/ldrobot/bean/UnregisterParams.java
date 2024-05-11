package com.ldrobot.bean;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/17 11:41
 * @Description: java类作用描述
 */
public class UnregisterParams {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}