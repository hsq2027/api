package com.ldrobot.bean;


import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 创建时间：2020/9/2  14:20
 * 作者：5#
 * 描述：统计同一个id出现的次数和下标总和
 * 注意：
 */
public class LDRoom implements Parcelable {

    private int id;
    private String tag;
    private String name;
    private String active = LDArea.ACTIVE_NORMAL;
    private ArrayList<Integer> pos;
    private int cleanOrder = -1;
    private String cleanType;
    private String mode;
    private int[][] vertexs;
    private String workNoisy;
    private int cleanCount = -1;//清扫次数。代表定制模式打开后单个区域清扫的次数。一下几项属性都是数组，其中数组最大不能超过清扫次数的个数，数组中对应序号的值分别对应清扫次数中的第几次清扫。
    private int[] fanLevel;//区域风力设置
    private int[] waterPump;//区域水量设置

    private int yMop = -1;//Y字形拖地，0x00：关闭，0x01：打开，0xff：未设置

    private int sumX;
    private int sumY;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private int num;
    private PointF finalPos;
    private int floortype = -1;


    public LDRoom(){}

    public ArrayList<Integer> getPos() {
        return pos;
    }

    public void setPos(ArrayList<Integer> pos) {
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public int getSumX() {
        return sumX;
    }

    public void setSumX(int sumX) {
        this.sumX = sumX;
    }

    public int getSumY() {
        return sumY;
    }

    public void setSumY(int sumY) {
        this.sumY = sumY;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public PointF getFinalPos() {
        return finalPos;
    }

    public void setFinalPos(PointF finalPos) {
        this.finalPos = finalPos;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCleanOrder() {
        return cleanOrder;
    }

    public void setCleanOrder(int cleanOrder) {
        this.cleanOrder = cleanOrder;
    }

    public String getCleanType() {
        return cleanType;
    }

    public void setCleanType(String cleanType) {
        this.cleanType = cleanType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int[][] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[][] vertexs) {
        this.vertexs = vertexs;
    }

    public String getWorkNoisy() {
        return workNoisy;
    }

    public void setWorkNoisy(String workNoisy) {
        this.workNoisy = workNoisy;
    }

    public int getCleanCount() {
        return cleanCount;
    }

    public void setCleanCount(int cleanCount) {
        this.cleanCount = cleanCount;
    }

    public int[] getFanLevel() {
        return fanLevel;
    }

    public void setFanLevel(int[] fanLevel) {
        this.fanLevel = fanLevel;
    }

    public int[] getWaterPump() {
        return waterPump;
    }

    public void setWaterPump(int[] waterPump) {
        this.waterPump = waterPump;
    }

    public int getyMop() {
        return yMop;
    }

    public void setyMop(int yMop) {
        this.yMop = yMop;
    }

    public int getFloortype() {
        return floortype;
    }

    public void setFloortype(int floortype) {
        this.floortype = floortype;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.tag);
        dest.writeString(this.name);
        dest.writeString(this.active);
        dest.writeList(this.pos);
        dest.writeInt(this.cleanOrder);
        dest.writeString(this.cleanType);
        dest.writeString(this.mode);
//        dest.writeParcelable(this.vertexs, flags);
        dest.writeString(this.workNoisy);
        dest.writeInt(this.cleanCount);
        dest.writeIntArray(this.fanLevel);
        dest.writeIntArray(this.waterPump);
        dest.writeInt(this.yMop);
        dest.writeInt(this.sumX);
        dest.writeInt(this.sumY);
        dest.writeInt(this.minX);
        dest.writeInt(this.minY);
        dest.writeInt(this.maxX);
        dest.writeInt(this.maxY);
        dest.writeInt(this.num);
        dest.writeParcelable(this.finalPos, flags);
        dest.writeInt(this.floortype);
    }

    protected LDRoom(Parcel in) {
        this.id = in.readInt();
        this.tag = in.readString();
        this.name = in.readString();
        this.active = in.readString();
        this.pos = new ArrayList<Integer>();
        in.readList(this.pos, Integer.class.getClassLoader());
        this.cleanOrder = in.readInt();
        this.cleanType = in.readString();
        this.mode = in.readString();
//        this.vertexs = in.readParcelable(int[][].class.getClassLoader());
        this.workNoisy = in.readString();
        this.cleanCount = in.readInt();
        this.fanLevel = in.createIntArray();
        this.waterPump = in.createIntArray();
        this.yMop = in.readInt();
        this.sumX = in.readInt();
        this.sumY = in.readInt();
        this.minX = in.readInt();
        this.minY = in.readInt();
        this.maxX = in.readInt();
        this.maxY = in.readInt();
        this.num = in.readInt();
        this.finalPos = in.readParcelable(PointF.class.getClassLoader());
        this.floortype = in.readInt();
    }

    public static final Creator<LDRoom> CREATOR = new Creator<LDRoom>() {
        @Override
        public LDRoom createFromParcel(Parcel source) {
            return new LDRoom(source);
        }

        @Override
        public LDRoom[] newArray(int size) {
            return new LDRoom[size];
        }
    };

    @Override
    public String toString() {
        return "LDRoom{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                ", pos=" + pos +
                ", cleanOrder=" + cleanOrder +
                ", cleanType='" + cleanType + '\'' +
                ", mode='" + mode + '\'' +
                ", vertexs=" + Arrays.toString(vertexs) +
                ", workNoisy='" + workNoisy + '\'' +
                ", cleanCount=" + cleanCount +
                ", fanLevel=" + Arrays.toString(fanLevel) +
                ", waterPump=" + Arrays.toString(waterPump) +
                ", yMop=" + yMop +
                ", sumX=" + sumX +
                ", sumY=" + sumY +
                ", minX=" + minX +
                ", minY=" + minY +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                ", num=" + num +
                ", finalPos=" + finalPos +
                ", floortype=" + floortype +
                '}';
    }
}