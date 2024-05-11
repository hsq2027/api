package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.TimeZone;

/**
 * Created by Emiya on 17/1/4.
 */
public class SweepAppointment implements Parcelable {
    private long uniqueId;//预约id，13位时间戳
    private int startTime;
    private int endTime;
    private boolean active;   //为true表示是预约清扫时间，为false表示是勿扰
    private boolean unlock;//时间true表示激活，否则为未激活状态
    private ArrayList<Integer> period;
    private ArrayList<String> tagIds;
    private ArrayList<LDArea> sweepAreaArrayList;
    private ArrayList<String> segmentTagIds;//选区清扫，选区ID
    private int workNoisy;
    private int waterPump;
    private boolean timedWorkDeepClean;//true：激活预约二次清扫， false:不激活
    private int cleanMode;//工作模式，0扫拖；1仅扫；2仅拖
    private int cleanCount = 1;//清扫次数

    public SweepAppointment() {

    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isUnlock() {
        return unlock;
    }

    public void setUnlock(boolean unlock) {
        this.unlock = unlock;
    }

    public ArrayList<Integer> getPeriod() {
        return period;
    }

    public void setPeriod(ArrayList<Integer> period) {
        this.period = period;
    }

    public int getWorkNoisy() {
        return workNoisy;
    }

    public void setWorkNoisy(int workNoisy) {
        this.workNoisy = workNoisy;
    }

    public int getWaterPump() {
        return waterPump;
    }

    public void setWaterPump(int waterPump) {
        this.waterPump = waterPump;
    }

    public void checkOnceTime(String zone) {
        if (period == null || period.size() == 0) {
            int timeNow = (int) (System.currentTimeMillis() / 1000.0);
            if ((startTime + "").length() < 10) {
                return;
            }
            if (active) {
                if (startTime < timeNow) {
                    unlock = false;
                }
//                startTime = startTime + TimestampTool.getTimeMillisZoneOffset(zone);
                startTime = startTime + TimeZone.getDefault().getRawOffset() / 1000;
                startTime = startTime % 86400;
            } else {
                if (endTime < timeNow) {
                    unlock = false;
                }
//                startTime = startTime + TimestampTool.getTimeMillisZoneOffset(zone);
                startTime = startTime + TimeZone.getDefault().getRawOffset() / 1000;
//                endTime = endTime + TimestampTool.getTimeMillisZoneOffset(zone);
                endTime = endTime + TimeZone.getDefault().getRawOffset() / 1000;
                startTime = startTime % 86400;
                endTime = endTime % 86400;
            }
        }
    }

    public ArrayList<String> getTagIds() {
        return tagIds;
    }

    public void setTagIds(ArrayList<String> tagIds) {
        this.tagIds = tagIds;
    }

    public ArrayList<LDArea> getSweepAreaArrayList() {
        return sweepAreaArrayList;
    }

    public void setSweepAreaArrayList(ArrayList<LDArea> sweepAreaArrayList) {
        this.sweepAreaArrayList = sweepAreaArrayList;
    }

    public ArrayList<String> getSegmentTagIds() {
        return segmentTagIds;
    }

    public void setSegmentTagIds(ArrayList<String> segmentTagIds) {
        this.segmentTagIds = segmentTagIds;
    }

    public boolean isTimedWorkDeepClean() {
        return timedWorkDeepClean;
    }

    public void setTimedWorkDeepClean(boolean timedWorkDeepClean) {
        this.timedWorkDeepClean = timedWorkDeepClean;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getCleanMode() {
        return cleanMode;
    }

    public void setCleanMode(int cleanMode) {
        this.cleanMode = cleanMode;
    }

    public int getCleanCount() {
        return cleanCount;
    }

    public void setCleanCount(int cleanCount) {
        this.cleanCount = cleanCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.uniqueId);
        dest.writeInt(this.startTime);
        dest.writeInt(this.endTime);
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeByte(this.unlock ? (byte) 1 : (byte) 0);
        dest.writeList(this.period);
        dest.writeStringList(this.tagIds);
        dest.writeTypedList(this.sweepAreaArrayList);
        dest.writeStringList(this.segmentTagIds);
        dest.writeInt(this.workNoisy);
        dest.writeInt(this.waterPump);
        dest.writeByte(this.timedWorkDeepClean ? (byte) 1 : (byte) 0);
        dest.writeInt(this.cleanMode);
        dest.writeInt(this.cleanCount);
    }

    protected SweepAppointment(Parcel in) {
        this.uniqueId = in.readLong();
        this.startTime = in.readInt();
        this.endTime = in.readInt();
        this.active = in.readByte() != 0;
        this.unlock = in.readByte() != 0;
        this.period = new ArrayList<Integer>();
        in.readList(this.period, Integer.class.getClassLoader());
        this.tagIds = in.createStringArrayList();
        this.sweepAreaArrayList = in.createTypedArrayList(LDArea.CREATOR);
        this.segmentTagIds = in.createStringArrayList();
        this.workNoisy = in.readInt();
        this.waterPump = in.readInt();
        this.timedWorkDeepClean = in.readByte() != 0;
        this.cleanMode = in.readInt();
        this.cleanCount = in.readInt();
    }

    public static final Creator<SweepAppointment> CREATOR = new Creator<SweepAppointment>() {
        @Override
        public SweepAppointment createFromParcel(Parcel source) {
            return new SweepAppointment(source);
        }

        @Override
        public SweepAppointment[] newArray(int size) {
            return new SweepAppointment[size];
        }
    };

    @Override
    public String toString() {
        return "SweepAppointment{" +
                "uniqueId=" + uniqueId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", active=" + active +
                ", unlock=" + unlock +
                ", period=" + period +
                ", tagIds=" + tagIds +
                ", sweepAreaArrayList=" + sweepAreaArrayList +
                ", segmentTagIds=" + segmentTagIds +
                ", workNoisy=" + workNoisy +
                ", waterPump=" + waterPump +
                ", timedWorkDeepClean=" + timedWorkDeepClean +
                ", cleanMode=" + cleanMode +
                ", cleanCount=" + cleanCount +
                '}';
    }
}