package com.ldrobot.bean;


import android.graphics.PointF;

/**
 * 创建时间：2020/9/2  14:20
 * 作者：5#
 * 描述：统计同一个id出现的次数和下标总和
 * 注意：
 */
public class StatisticBean {
    private int sumX;
    private int sumY;
    private int num;
    private PointF finalPos;
    private String tag;
    private String name;
    private int cleanTime = 1; //默认清扫一次
    private String active = LDArea.ACTIVE_NORMAL;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public int getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(int cleanTime) {
        this.cleanTime = cleanTime;
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
}