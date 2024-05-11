package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: hsq
 * @CreateTime: 2022/11/16 14:03
 * @Description: java类作用描述
 */
public class PrivacyPointBean implements Parcelable {
    /**
     * height : 24
     * width : 70
     * x : 680
     * y : 300
     */

    private int height;
    private int width;
    private int x;
    private int y;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.height);
        dest.writeInt(this.width);
        dest.writeInt(this.x);
        dest.writeInt(this.y);
    }

    public PrivacyPointBean() {
    }

    protected PrivacyPointBean(Parcel in) {
        this.height = in.readInt();
        this.width = in.readInt();
        this.x = in.readInt();
        this.y = in.readInt();
    }

    public static final Creator<PrivacyPointBean> CREATOR = new Creator<PrivacyPointBean>() {
        @Override
        public PrivacyPointBean createFromParcel(Parcel source) {
            return new PrivacyPointBean(source);
        }

        @Override
        public PrivacyPointBean[] newArray(int size) {
            return new PrivacyPointBean[size];
        }
    };
}