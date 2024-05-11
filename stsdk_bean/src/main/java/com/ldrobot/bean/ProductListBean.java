package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/1 19:27
 * @Description: java类作用描述
 */
public class ProductListBean implements Parcelable {
    private String productKey;
    private String categoryName;
    private String productImg;
    private String productName;
    private int status;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.productKey);
        dest.writeString(this.categoryName);
        dest.writeString(this.productImg);
        dest.writeString(this.productName);
        dest.writeInt(this.status);
    }

    public ProductListBean() {
    }

    protected ProductListBean(Parcel in) {
        this.productKey = in.readString();
        this.categoryName = in.readString();
        this.productImg = in.readString();
        this.productName = in.readString();
        this.status = in.readInt();
    }

    public static final Creator<ProductListBean> CREATOR = new Creator<ProductListBean>() {
        @Override
        public ProductListBean createFromParcel(Parcel source) {
            return new ProductListBean(source);
        }

        @Override
        public ProductListBean[] newArray(int size) {
            return new ProductListBean[size];
        }
    };
}