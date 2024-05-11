package com.ldrobot.bean;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/9/29 11:11
 * @Description: java类作用描述
 */
public class LDObstacle implements Parcelable {
    private String id;
    private int obstacleType;
    private int confidence;
    private String fileName;
    private PointF pos;
    private PointF rectPos;
    private float rectWidth;
    private float rectHeight;
    private List<PrivacyPointBean> privacyPointList;

    private String name;//障碍物名称（本地）
    private Bitmap realisticPhoto;//实景照片（本地）
    private Bitmap placeHolderPicture;//实景照片加载成功之前的占位图

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getObstacleType() {
        return obstacleType;
    }

    public void setObstacleType(int obstacleType) {
        this.obstacleType = obstacleType;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public PointF getPos() {
        return pos;
    }

    public void setPos(PointF pos) {
        this.pos = pos;
    }

    public PointF getRectPos() {
        return rectPos;
    }

    public void setRectPos(PointF rectPos) {
        this.rectPos = rectPos;
    }

    public float getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(float rectWidth) {
        this.rectWidth = rectWidth;
    }

    public float getRectHeight() {
        return rectHeight;
    }

    public void setRectHeight(float rectHeight) {
        this.rectHeight = rectHeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getRealisticPhoto() {
        return realisticPhoto;
    }

    public void setRealisticPhoto(Bitmap realisticPhoto) {
        this.realisticPhoto = realisticPhoto;
    }

    public Bitmap getPlaceHolderPicture() {
        return placeHolderPicture;
    }

    public void setPlaceHolderPicture(Bitmap placeHolderPicture) {
        this.placeHolderPicture = placeHolderPicture;
    }

    public LDObstacle() {
    }

    public List<PrivacyPointBean> getPrivacyPointList() {
        return privacyPointList;
    }

    public void setPrivacyPointList(List<PrivacyPointBean> privacyPointList) {
        this.privacyPointList = privacyPointList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeInt(this.obstacleType);
        dest.writeInt(this.confidence);
        dest.writeString(this.fileName);
        dest.writeParcelable(this.pos, flags);
        dest.writeParcelable(this.rectPos, flags);
        dest.writeFloat(this.rectWidth);
        dest.writeFloat(this.rectHeight);
        dest.writeList(this.privacyPointList);
        dest.writeString(this.name);
        dest.writeParcelable(this.realisticPhoto, flags);
        dest.writeParcelable(this.placeHolderPicture, flags);
    }

    protected LDObstacle(Parcel in) {
        this.id = in.readString();
        this.obstacleType = in.readInt();
        this.confidence = in.readInt();
        this.fileName = in.readString();
        this.pos = in.readParcelable(PointF.class.getClassLoader());
        this.rectPos = in.readParcelable(PointF.class.getClassLoader());
        this.rectWidth = in.readFloat();
        this.rectHeight = in.readFloat();
        this.privacyPointList = new ArrayList<PrivacyPointBean>();
        in.readList(this.privacyPointList, PrivacyPointBean.class.getClassLoader());
        this.name = in.readString();
        this.realisticPhoto = in.readParcelable(Bitmap.class.getClassLoader());
        this.placeHolderPicture = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<LDObstacle> CREATOR = new Creator<LDObstacle>() {
        @Override
        public LDObstacle createFromParcel(Parcel source) {
            return new LDObstacle(source);
        }

        @Override
        public LDObstacle[] newArray(int size) {
            return new LDObstacle[size];
        }
    };
}