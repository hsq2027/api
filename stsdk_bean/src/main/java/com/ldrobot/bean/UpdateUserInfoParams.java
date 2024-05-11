package com.ldrobot.bean;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/17 9:31
 * @Description: java类作用描述
 */
public class UpdateUserInfoParams {
    private String userId;
    private String nickname;
    private String sex;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}