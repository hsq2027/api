package com.ldrobot.bean;

import android.graphics.PointF;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 路径实体
 */

public class SweepPath implements Serializable {
    private static final long serialVersionUID = 1418840487684466542L;
    public static final int PATH_TYPE_NORMAL = 0;
    public static final int PATH_TYPE_CUR_PATH = 1;
    public static final int PATH_TYPE_HIS_PATH = 2;
    private int PathId;
    private int StartPos;
    private int DataLength;
    private int PathSize;
    private int hasPathInfo;//0:无意义，  1 ：有意义
    private String Data;
    private float[][] posArray;
    private ArrayList<PointF> pointArrayList = new ArrayList<PointF>();
    private int type; // 0 代表以前协议的普通类  1；代表新协议 curPath  2: 代表新协议 hisPath
    private int version;//path版本
    private boolean rightVersion;
    private boolean tag;
    private int pointCounts;
    private int direction;


    public boolean isTag() {
        return tag;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    public boolean isRightVersion() {
        return rightVersion;
    }

    public void setRightVersion(boolean rightVersion) {
        this.rightVersion = rightVersion;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getPathId() {
        return PathId;
    }

    public void setPathId(int pathID) {
        this.PathId = pathID;
    }

    public int getStartPos() {
        return StartPos;
    }

    public void setStartPos(int startPos) {
        this.StartPos = startPos;
    }

    public int getDataLength() {
        return DataLength;
    }

    public void setDataLength(int dataLength) {
        DataLength = dataLength;
    }

    public int getPathSize() {
        return PathSize;
    }

    public void setPathSize(int pathSize) {
        PathSize = pathSize;
    }

    public ArrayList<PointF> getPointArrayList() {
        return pointArrayList;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void addPosArray(float[][] posArray) {
        for (float[] position : posArray) {
            PointF point = new PointF();
            point.x = position[0];
            point.y = position[1];
            pointArrayList.add(point);
        }
    }

    public void setPointArrayList(ArrayList<PointF> pointArrayList) {
        this.pointArrayList = pointArrayList;
    }

    public int getHasPathInfo() {
        return hasPathInfo;
    }

    public void setHasPathInfo(int hasPathInfo) {
        this.hasPathInfo = hasPathInfo;
    }

    public float[][] getPosArray() {
        return posArray;
    }

    public void setPosArray(float[][] posArray) {
        this.posArray = posArray;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

//    @Override
//    public String toString() {
//        return "SweepPath{" +
//                "PathId=" + PathId +
//                ", StartPos=" + StartPos +
//                ", DataLength=" + DataLength +
//                ", PathSize=" + PathSize +
//                ", hasPathInfo=" + hasPathInfo +
//                ", Data='" + Data + '\'' +
//                ", posArray=" + Arrays.toString(posArray) +
//                ", pointArrayList=" + pointArrayList +
//                ", type=" + type +
//                ", version=" + version +
//                ", rightVersion=" + rightVersion +
//                ", tag=" + tag +
//                ", pointCounts=" + pointCounts +
//                '}';
//    }

    public int getPointCounts() {
        return pointCounts;
    }

    public void setPointCounts(int pointCounts) {
        this.pointCounts = pointCounts;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

//    public void parsePosArray() {
//        if (Data != null) {
//            posArray = new Gson().fromJson(Data, (Type) Integer[][].class);
//        }
//    }
//
//    public ArrayList<Point> getParsedPointArrayList(){
//        parsePosArray();
//        if (posArray != null){
//            addPosArray(posArray);
//        }
//        return getPointArrayList();
//    }
}