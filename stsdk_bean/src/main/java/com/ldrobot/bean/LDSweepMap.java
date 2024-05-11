package com.ldrobot.bean;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 地图bean
 */

public class LDSweepMap implements Parcelable {
    private int mapId;
    private int mapID;//多地图中用到,扫地机搞事情，不肯改成mapId,其实就是mapId
    private int width;
    private int height;
    private int lz4_len;
    private int base64_len;
    private String map;
    private float resolution;
    private float x_min;
    private float y_min;
    private float[][] posArray;
    private ArrayList<LDArea> area;
    private ArrayList<LDArea> cleanArea;
    private int isDown;

    private int[] chargeHandlePos;
    private int chargeHandlePhi;
    private PointF chargeHandlePoint;
    private int pathId;
    private int autoAreaId;
    private int isDoneNormal;
    private int isError;
    private int curState;

    private long curPathUpdateTime;
    private int ver;

    private String tag;
    private long updateTime;

    private AiArea ai_area;

    private int mapDataType;//地图数据类型，0默认；1涂鸦T4协议数据
    private int pixLen;//压缩前的数据长度
    private int mapDataOffsetLength;
    private int mapCreateType;
    private float mapOx;
    private float mapOy;
    private int regionNum;//分区id+分区个数
    private int roomProperties;//房间信息
    private String verticesName;//暂未使用
    private String verticesNum;//暂未使用
    private String verticesData;//暂未使用
    private int roomCount;
    private int robotDirection;

    public LDSweepMap(){};


    public AiArea getAi_area() {
        return ai_area;
    }

    public void setAi_area(AiArea ai_area) {
        this.ai_area = ai_area;
    }

    public void setChargeHandlePoint(PointF chargeHandlePoint) {
        this.chargeHandlePoint = chargeHandlePoint;
    }

    public int getMapID() {
        return mapID;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public int getAutoAreaId() {
        return autoAreaId;
    }

    public void setAutoAreaId(int autoAreaId) {
        this.autoAreaId = autoAreaId;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public int getIsDoneNormal() {
        return isDoneNormal;
    }

    public void setIsDoneNormal(int isDoneNormal) {
        this.isDoneNormal = isDoneNormal;
    }

    public int getIsError() {
        return isError;
    }

    public void setIsError(int isError) {
        this.isError = isError;
    }

    public int getCurState() {
        return curState;
    }

    public void setCurState(int curState) {
        this.curState = curState;
    }

    public long getCurPathUpdateTime() {
        return curPathUpdateTime;
    }

    public void setCurPathUpdateTime(long curPathUpdateTime) {
        this.curPathUpdateTime = curPathUpdateTime;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public LDSweepMap clone() {
        LDSweepMap LDSweepMap = new LDSweepMap();
        LDSweepMap.setMapId(mapId);
        LDSweepMap.setWidth(width);
        LDSweepMap.setHeight(height);
        LDSweepMap.setLz4_len(lz4_len);
        LDSweepMap.setBase64_len(base64_len);
        LDSweepMap.setMap(map);
        LDSweepMap.setResolution(resolution);
        LDSweepMap.setX_min(x_min);
        LDSweepMap.setY_min(y_min);
        LDSweepMap.setPosArray(posArray);
        LDSweepMap.setChargeHandlePos(chargeHandlePos);
        LDSweepMap.setChargeHandlePoint();
        return LDSweepMap;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLz4_len() {
        return lz4_len;
    }

    public void setLz4_len(int lz4_len) {
        this.lz4_len = lz4_len;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getBase64_len() {
        return base64_len;
    }

    public void setBase64_len(int base64_len) {
        this.base64_len = base64_len;
    }

    public float getResolution() {
        return resolution;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }

    public float getX_min() {
        return x_min;
    }

    public void setX_min(float x_min) {
        this.x_min = x_min;
    }

    public float getY_min() {
        return y_min;
    }

    public void setY_min(float y_min) {
        this.y_min = y_min;
    }

    public float[][] getPosArray() {
        return posArray;
    }

    public void setPosArray(float[][] posArray) {
        this.posArray = posArray;
    }

    public ArrayList<LDArea> getArea() {
        return area;
    }

    public void setArea(ArrayList<LDArea> area) {
        this.area = area;
    }

    public ArrayList<LDArea> getCleanArea() {
        return cleanArea;
    }

    public void setCleanArea(ArrayList<LDArea> cleanArea) {
        this.cleanArea = cleanArea;
    }

    public int getIsDown() {
        return isDown;
    }

    public void setIsDown(int isDown) {
        this.isDown = isDown;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int[] getChargeHandlePos() {
        return chargeHandlePos;
    }

    public void setChargeHandlePos(int[] chargeHandlePos) {
        this.chargeHandlePos = chargeHandlePos;
    }

    public int getChargeHandlePhi() {
        return chargeHandlePhi;
    }

    public void setChargeHandlePhi(int chargeHandlePhi) {
        this.chargeHandlePhi = chargeHandlePhi;
    }

    public PointF getChargeHandlePoint() {
        return chargeHandlePoint;
    }

    public void setChargeHandlePoint() {
        if (chargeHandlePos != null && chargeHandlePos.length >= 2) {
            if (chargeHandlePoint == null)
                chargeHandlePoint = new PointF();
            chargeHandlePoint.set(chargeHandlePos[0], chargeHandlePos[1]);
        }
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "LDSweepMap{" +
                "mapId=" + mapId +
                ", width=" + width +
                ", height=" + height +
                ", lz4_len=" + lz4_len +
                ", base64_len=" + base64_len +
                ", map='" + map + '\'' +
                ", resolution=" + resolution +
                ", x_min=" + x_min +
                ", y_min=" + y_min +
                ", posArray=" + Arrays.toString(posArray) +
                ", area=" + area +
                ", cleanArea=" + cleanArea +
                ", isDown=" + isDown +
                ", chargeHandlePos=" + Arrays.toString(chargeHandlePos) +
                ", chargeHandlePhi=" + chargeHandlePhi +
                ", chargeHandlePoint=" + chargeHandlePoint +
                ", pathId=" + pathId +
                ", autoAreaId=" + autoAreaId +
                ", isDoneNormal=" + isDoneNormal +
                ", isError=" + isError +
                ", curState=" + curState +
                ", mapDataType=" + mapDataType +
                ", pixLen=" + pixLen +
                ", mapDataOffsetLength=" + mapDataOffsetLength +
                ", mapCreateType=" + mapCreateType +
                ", mapOx=" + mapOx +
                ", mapOy=" + mapOy +
                ", robotDirection=" + robotDirection +
                '}';
    }

    public int getMapDataOffsetLength() {
        return mapDataOffsetLength;
    }

    public void setMapDataOffsetLength(int mapDataOffsetLength) {
        this.mapDataOffsetLength = mapDataOffsetLength;
    }

    public int getPixLen() {
        return pixLen;
    }

    public void setPixLen(int pixLen) {
        this.pixLen = pixLen;
    }

    public int getMapCreateType() {
        return mapCreateType;
    }

    public void setMapCreateType(int mapCreateType) {
        this.mapCreateType = mapCreateType;
    }

    public int getMapDataType() {
        return mapDataType;
    }

    public void setMapDataType(int mapDataType) {
        this.mapDataType = mapDataType;
    }

    public float getMapOx() {
        return mapOx;
    }

    public void setMapOx(float mapOx) {
        this.mapOx = mapOx;
    }

    public float getMapOy() {
        return mapOy;
    }

    public void setMapOy(float mapOy) {
        this.mapOy = mapOy;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mapId);
        dest.writeInt(this.mapID);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.lz4_len);
        dest.writeInt(this.base64_len);
        dest.writeString(this.map);
        dest.writeFloat(this.resolution);
        dest.writeFloat(this.x_min);
        dest.writeFloat(this.y_min);
        dest.writeTypedList(this.area);
        dest.writeTypedList(this.cleanArea);
        dest.writeInt(this.isDown);
        dest.writeIntArray(this.chargeHandlePos);
        dest.writeInt(this.chargeHandlePhi);
        dest.writeParcelable(this.chargeHandlePoint, flags);
        dest.writeInt(this.pathId);
        dest.writeInt(this.autoAreaId);
        dest.writeInt(this.isDoneNormal);
        dest.writeInt(this.isError);
        dest.writeInt(this.curState);
        dest.writeLong(this.curPathUpdateTime);
        dest.writeInt(this.ver);
        dest.writeString(this.tag);
        dest.writeLong(this.updateTime);
        dest.writeParcelable(this.ai_area, flags);
        dest.writeInt(this.mapDataType);
        dest.writeInt(this.pixLen);
        dest.writeInt(this.mapDataOffsetLength);
        dest.writeInt(this.mapCreateType);
        dest.writeFloat(this.mapOx);
        dest.writeFloat(this.mapOy);
        dest.writeInt(this.regionNum);
        dest.writeInt(this.roomProperties);
        dest.writeString(this.verticesName);
        dest.writeString(this.verticesNum);
        dest.writeString(this.verticesData);
        dest.writeInt(this.roomCount);
        dest.writeInt(this.robotDirection);
    }

    protected LDSweepMap(Parcel in) {
        this.mapId = in.readInt();
        this.mapID = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
        this.lz4_len = in.readInt();
        this.base64_len = in.readInt();
        this.map = in.readString();
        this.resolution = in.readFloat();
        this.x_min = in.readFloat();
        this.y_min = in.readFloat();
        this.area = in.createTypedArrayList(LDArea.CREATOR);
        this.cleanArea = in.createTypedArrayList(LDArea.CREATOR);
        this.isDown = in.readInt();
        this.chargeHandlePos = in.createIntArray();
        this.chargeHandlePhi = in.readInt();
        this.chargeHandlePoint = in.readParcelable(PointF.class.getClassLoader());
        this.pathId = in.readInt();
        this.autoAreaId = in.readInt();
        this.isDoneNormal = in.readInt();
        this.isError = in.readInt();
        this.curState = in.readInt();
        this.curPathUpdateTime = in.readLong();
        this.ver = in.readInt();
        this.tag = in.readString();
        this.updateTime = in.readLong();
        this.ai_area = in.readParcelable(AiArea.class.getClassLoader());
        this.mapDataType = in.readInt();
        this.pixLen = in.readInt();
        this.mapDataOffsetLength = in.readInt();
        this.mapCreateType = in.readInt();
        this.mapOx = in.readFloat();
        this.mapOy = in.readFloat();
        this.regionNum = in.readInt();
        this.roomProperties = in.readInt();
        this.verticesName = in.readString();
        this.verticesNum = in.readString();
        this.verticesData = in.readString();
        this.roomCount = in.readInt();
        this.robotDirection = in.readInt();
    }

    public static final Creator<LDSweepMap> CREATOR = new Creator<LDSweepMap>() {
        @Override
        public LDSweepMap createFromParcel(Parcel source) {
            return new LDSweepMap(source);
        }

        @Override
        public LDSweepMap[] newArray(int size) {
            return new LDSweepMap[size];
        }
    };

    public void setRobotDirection(int robotDirection) {
        this.robotDirection = robotDirection;
    }

    public int getRobotDirection() {
        return robotDirection;
    }
}