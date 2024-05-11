package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/8 17:10
 * @Description: java类作用描述
 */
public class ShareMemberBean implements Parcelable {
    private long time;
    private String userId;
    private String userName;
    private String email;
    private String phone;
    private String nickname;
    private String avatar;
    private String aliIdentityId;
    private boolean isAdmin;
    private boolean isSelect;
    private boolean canSelect = true;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAliIdentityId() {
        return aliIdentityId;
    }

    public void setAliIdentityId(String aliIdentityId) {
        this.aliIdentityId = aliIdentityId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCanSelect() {
        return canSelect;
    }

    public void setCanSelect(boolean canSelect) {
        this.canSelect = canSelect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.time);
        dest.writeString(this.userId);
        dest.writeString(this.userName);
        dest.writeString(this.email);
        dest.writeString(this.phone);
        dest.writeString(this.nickname);
        dest.writeString(this.avatar);
        dest.writeString(this.aliIdentityId);
        dest.writeByte(this.isAdmin ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSelect ? (byte) 1 : (byte) 0);
        dest.writeByte(this.canSelect ? (byte) 1 : (byte) 0);
    }

    public ShareMemberBean() {
    }

    protected ShareMemberBean(Parcel in) {
        this.time = in.readLong();
        this.userId = in.readString();
        this.userName = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.nickname = in.readString();
        this.avatar = in.readString();
        this.aliIdentityId = in.readString();
        this.isAdmin = in.readByte() != 0;
        this.isSelect = in.readByte() != 0;
        this.canSelect = in.readByte() != 0;
    }

    public static final Creator<ShareMemberBean> CREATOR = new Creator<ShareMemberBean>() {
        @Override
        public ShareMemberBean createFromParcel(Parcel source) {
            return new ShareMemberBean(source);
        }

        @Override
        public ShareMemberBean[] newArray(int size) {
            return new ShareMemberBean[size];
        }
    };
}