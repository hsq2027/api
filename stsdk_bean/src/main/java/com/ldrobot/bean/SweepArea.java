//package com.ldrobot.bean;
//
//import android.graphics.Path;
//import android.graphics.Point;
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import java.util.ArrayList;
//
///**
// * Created by Emiya on 16/12/8.
// */
//
//public class SweepArea implements Parcelable {
//    private ArrayList<Point> pointArrayList;
//    private Path path;
//    private String name;
//    private int id;
//    private String tag;
//    private int[][] vertexs;
//    private String active;
//    private boolean selected;
//    private ArrayList<Point> tempVertexs;
//    private float angle;
//    private String mode; //区分清扫的类型  和active配合使用
//    private int mapId;//依附地图的id
//    private String appModel;
//    private String forbidType;//禁区类型
//
//    public ArrayList<Point> getTempVertexs() {
//        return tempVertexs;
//    }
//
//    public void setTempVertexs(ArrayList<Point> tempVertexs) {
//        this.tempVertexs = tempVertexs;
//    }
//
//    public SweepArea() {
//
//    }
//
//    public ArrayList<Point> getPointArrayList() {
//        return pointArrayList;
//    }
//
//    public void setPointArrayList(ArrayList<Point> pointArrayList) {
//        this.pointArrayList = pointArrayList;
//    }
//
//    public Path getPath() {
//        return path;
//    }
//
//    public void setPath(Path path) {
//        this.path = path;
//    }
//
//    //active表示的是清洁程序：nomal表示是普通清扫，depth表示是重度清扫，forbid表示是禁止清扫
//    public static final String NORMAL = "normal";
//    public static final String DEPTH = "depth";
//    public static final String FORBID = "forbid";
//    public static final String POINT = "point";
//    public static final String DISPLAY = "display";
//
//    //mode类型
//    public static final String MODE_DEFAULT = "default";
//    public static final String MODE_AREA = "area";
//    public static final String MODE_POINT = "point";
//    public static final String MODE_CURPOINT = "curpoint";
//    public static final String MODE_ROOM = "room";
//    public static final String MODE_AUTOLAYER = "autolayer";
//    public static final String MODE_FURNITURE = "furniture";
//
//    //禁区属性，仅在禁区属性 active 字段中为forbid 有效
//    public static final String FORBID_SWEEP = "sweep";
//    public static final String FORBID_MOP = "mop";
//    public static final String FORBID_ALL = "all";
//
//    public SweepArea clone() {
//        SweepArea sweepArea = new SweepArea();
//        sweepArea.setPointArrayList(getPointArrayList());
//        sweepArea.setPath(getPath());
//        sweepArea.setName(getName());
//        sweepArea.setTag(getTag());
//        sweepArea.setId(getId());
//        sweepArea.setVertexs(getVertexs());
//        sweepArea.setActive(getActive());
//        sweepArea.setSelected(isSelected());
//        sweepArea.setTempVertexs(getTempVertexs());
//        sweepArea.setMode(getMode());
//        sweepArea.setAppModel(getAppModel());
//        sweepArea.setMapId(getMapId());
//        sweepArea.setForbidType(getForbidType());
//        sweepArea.setAngle(getAngle());
//        return sweepArea;
//    }
//
//    public float getAngle() {
//        return angle;
//    }
//
//    public void setAngle(float angle) {
//        this.angle = angle;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTag() {
//        return tag;
//    }
//
//    public void setTag(String tag) {
//        this.tag = tag;
//    }
//
//    public int[][] getVertexs() {
//        return vertexs;
//    }
//
//    public void setVertexs(int[][] vertexs) {
//        this.vertexs = vertexs;
//    }
//
//    public String getActive() {
//        return active;
//    }
//
//    public void setActive(String active) {
//        this.active = active;
//    }
//
//    public String getMode() {
//        return mode;
//    }
//
//    public void setMode(String mode) {
//        this.mode = mode;
//    }
//
//    public boolean isSelected() {
//        return selected;
//    }
//
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
//
//    public int getMapId() {
//        return mapId;
//    }
//
//    public void setMapId(int mapId) {
//        this.mapId = mapId;
//    }
//
//    public String getForbidType() {
//        return forbidType;
//    }
//
//    public void setForbidType(String forbidType) {
//        this.forbidType = forbidType;
//    }
//
//    public void saveVertexToTempVertext(int[][] vertexs) {
//        if (tempVertexs == null) {
//            tempVertexs = new ArrayList<>();
//        }
//        if (tempVertexs != null) {
//            for (int i = 0; i <= vertexs.length - 1; i++) {
//                Point point = new Point();
//                point.x = vertexs[i][0];
//                point.y = vertexs[i][1];
//                tempVertexs.add(point);
//            }
//        }
//    }
//
//    public void restoreTempVertexsToVertex() {
//        if (tempVertexs != null && tempVertexs.size() > 0) {
//            vertexs = null;
//            vertexs = new int[tempVertexs.size()][2];
//            for (int i = 0; i < tempVertexs.size(); i++) {
//                vertexs[i][0] = tempVertexs.get(i).x;
//                vertexs[i][1] = tempVertexs.get(i).y;
//            }
//        }
//    }
//
//    public void initFurnitureVertexs() {
//        if (vertexs != null) {
//            int temp1 = vertexs[1][0];
//            int temp2 = vertexs[1][1];
//            vertexs[1][0] = temp1;
//            vertexs[1][1] = vertexs[0][1];
//            vertexs[2][0] = temp1;
//            vertexs[2][1] = temp2;
//            vertexs[3][0] = vertexs[0][0];
//            vertexs[3][1] = temp2;
//        }
//
//    }
//
//    public String getAppModel() {
//        return appModel;
//    }
//
//    public void setAppModel(String appModel) {
//        this.appModel = appModel;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeTypedList(pointArrayList);
//        parcel.writeString(name);
//        parcel.writeInt(id);
//        parcel.writeString(tag);
//        parcel.writeString(active);
//        parcel.writeByte((byte) (selected ? 1 : 0));
//        parcel.writeTypedList(tempVertexs);
//        parcel.writeFloat(angle);
//        parcel.writeString(mode);
//        parcel.writeInt(mapId);
//        parcel.writeString(appModel);
//        parcel.writeString(forbidType);
//    }
//
//    protected SweepArea(Parcel in) {
//        pointArrayList = in.createTypedArrayList(Point.CREATOR);
//        name = in.readString();
//        id = in.readInt();
//        tag = in.readString();
//        active = in.readString();
//        selected = in.readByte() != 0;
//        tempVertexs = in.createTypedArrayList(Point.CREATOR);
//        angle = in.readFloat();
//        mode = in.readString();
//        mapId = in.readInt();
//        appModel = in.readString();
//        forbidType = in.readString();
//    }
//
//    public static final Creator<SweepArea> CREATOR = new Creator<SweepArea>() {
//        @Override
//        public SweepArea createFromParcel(Parcel in) {
//            return new SweepArea(in);
//        }
//
//        @Override
//        public SweepArea[] newArray(int size) {
//            return new SweepArea[size];
//        }
//    };
//}