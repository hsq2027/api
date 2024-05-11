package com.ldrobot.bean;

import java.io.File;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/17 11:41
 * @Description: java类作用描述
 */
public class UploadUserAvatarParams {
    private String userId;
    private File avatar;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public File getAvatar() {
        return avatar;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }
}