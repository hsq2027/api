package com.ldrobot.bean;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Emiya on 17/2/23.
 */

public class SweepRecord implements Parcelable {

    private String startTime;   //开始时间
    private int timeLong;    //时长
    private int sweepArea;   //扫地面积
    private int mopArea;     //拖地面积
    private String fileName;    //文件名
    private int flag;//文件标志位
    private int isMap;
    private String backupMd5;
    private String url;
    private boolean isRestore;
    private boolean isSelect;
    private Bitmap mBitmap;
    private String map;
    private boolean canCollection;//是否支持收藏
    private boolean canDelete;//是否支持删除
    private int id;  //清扫记录id
    private String bucket;
    private String backFileName;
    private String extend;
    private String sweepMode; //清扫模式，如：全局扫、区域扫、房间扫等，具体参考CleanModeConst类
    private String workMode; //代表工作模式模式，如：扫拖、仅扫、仅拖、自适应
    private String cleaningResult; //代表本次清扫任务是否正常结束，如：异常结束、正常结束
    private String startMethod; //代表该记录的启动方式，如：物理遥控器启动、APP启动（云端发送指令）、预约任务启动、设备按键启动
    private String nickName;
    private int mapLength;
    private int pathLength;
    private int mapId;

    public SweepRecord(){}

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(int timeLong) {
        this.timeLong = timeLong;
    }

    public int getSweepArea() {
        return sweepArea;
    }

    public void setSweepArea(int sweepArea) {
        this.sweepArea = sweepArea;
    }

    public int getMopArea() {
        return mopArea;
    }

    public void setMopArea(int mopArea) {
        this.mopArea = mopArea;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIsMap() {
        return isMap;
    }

    public void setIsMap(int isMap) {
        this.isMap = isMap;
    }

    public String getBackupMd5() {
        return backupMd5;
    }

    public void setBackupMd5(String backupMd5) {
        this.backupMd5 = backupMd5;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRestore() {
        return isRestore;
    }

    public void setRestore(boolean restore) {
        isRestore = restore;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public boolean isCanCollection() {
        return canCollection;
    }

    public void setCanCollection(boolean canCollection) {
        this.canCollection = canCollection;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getBackFileName() {
        return backFileName;
    }

    public void setBackFileName(String backFileName) {
        this.backFileName = backFileName;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getSweepMode() {
        return sweepMode;
    }

    public void setSweepMode(String sweepMode) {
        this.sweepMode = sweepMode;
    }


    public int getMapLength() {
        return mapLength;
    }

    public void setMapLength(int mapLength) {
        this.mapLength = mapLength;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getWorkMode() {
        return workMode;
    }

    public void setWorkMode(String workMode) {
        this.workMode = workMode;
    }

    public String getCleaningResult() {
        return cleaningResult;
    }

    public void setCleaningResult(String cleaningResult) {
        this.cleaningResult = cleaningResult;
    }

    public String getStartMethod() {
        return startMethod;
    }

    public void setStartMethod(String startMethod) {
        this.startMethod = startMethod;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.startTime);
        dest.writeInt(this.timeLong);
        dest.writeInt(this.sweepArea);
        dest.writeInt(this.mopArea);
        dest.writeString(this.fileName);
        dest.writeInt(this.flag);
        dest.writeInt(this.isMap);
        dest.writeString(this.backupMd5);
        dest.writeString(this.url);
        dest.writeByte(this.isRestore ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSelect ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.mBitmap, flags);
        dest.writeString(this.map);
        dest.writeByte(this.canCollection ? (byte) 1 : (byte) 0);
        dest.writeByte(this.canDelete ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.bucket);
        dest.writeString(this.backFileName);
        dest.writeString(this.extend);
        dest.writeString(this.sweepMode);
        dest.writeString(this.workMode);
        dest.writeString(this.cleaningResult);
        dest.writeString(this.startMethod);
        dest.writeString(this.nickName);
        dest.writeInt(this.mapLength);
        dest.writeInt(this.pathLength);
        dest.writeInt(this.mapId);
    }

    protected SweepRecord(Parcel in) {
        this.startTime = in.readString();
        this.timeLong = in.readInt();
        this.sweepArea = in.readInt();
        this.mopArea = in.readInt();
        this.fileName = in.readString();
        this.flag = in.readInt();
        this.isMap = in.readInt();
        this.backupMd5 = in.readString();
        this.url = in.readString();
        this.isRestore = in.readByte() != 0;
        this.isSelect = in.readByte() != 0;
        this.mBitmap = in.readParcelable(Bitmap.class.getClassLoader());
        this.map = in.readString();
        this.canCollection = in.readByte() != 0;
        this.canDelete = in.readByte() != 0;
        this.id = in.readInt();
        this.bucket = in.readString();
        this.backFileName = in.readString();
        this.extend = in.readString();
        this.sweepMode = in.readString();
        this.workMode = in.readString();
        this.cleaningResult = in.readString();
        this.startMethod = in.readString();
        this.nickName = in.readString();
        this.mapLength = in.readInt();
        this.pathLength = in.readInt();
        this.mapId = in.readInt();
    }

    public static final Creator<SweepRecord> CREATOR = new Creator<SweepRecord>() {
        @Override
        public SweepRecord createFromParcel(Parcel source) {
            return new SweepRecord(source);
        }

        @Override
        public SweepRecord[] newArray(int size) {
            return new SweepRecord[size];
        }
    };

    @Override
    public String toString() {
        return "SweepRecord{" +
                "startTime='" + startTime + '\'' +
                ", timeLong=" + timeLong +
                ", sweepArea=" + sweepArea +
                ", mopArea=" + mopArea +
                ", fileName='" + fileName + '\'' +
                ", flag=" + flag +
                ", isMap=" + isMap +
                ", backupMd5='" + backupMd5 + '\'' +
                ", url='" + url + '\'' +
                ", isRestore=" + isRestore +
                ", isSelect=" + isSelect +
                ", mBitmap=" + mBitmap +
                ", map='" + map + '\'' +
                ", canCollection=" + canCollection +
                ", canDelete=" + canDelete +
                ", id=" + id +
                ", bucket='" + bucket + '\'' +
                ", backFileName='" + backFileName + '\'' +
                ", extend='" + extend + '\'' +
                ", sweepMode='" + sweepMode + '\'' +
                ", workMode='" + workMode + '\'' +
                ", cleaningResult='" + cleaningResult + '\'' +
                ", startMethod='" + startMethod + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mapLength=" + mapLength +
                ", pathLength=" + pathLength +
                ", mapId=" + mapId +
                '}';
    }
}