package com.ldrobot.bean;

import android.graphics.Path;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 区域bean
 */

public class LDArea implements Parcelable {
    private ArrayList<PointF> pointArrayList;
    private String name;
    private int id;
    private String tag;
    private float[][] vertexs;
    private String active;
        private boolean selected;
    private ArrayList<PointF> tempVertexs;
    private float angle;
    private String mode; //区分清扫的类型  和active配合使用
    private int mapId;//依附地图的id
    private String appModel;
    private String forbidType;//禁区类型

    private int cleanCount = -1;//清扫次数。代表定制模式打开后单个区域清扫的次数。一下几项属性都是数组，其中数组最大不能超过清扫次数的个数，数组中对应序号的值分别对应清扫次数中的第几次清扫。
    private int[] fanLevel;//区域风力设置
    private int[] waterPump;//区域水量设置
    private int cleanOrder = -1;//清扫顺序
    private int yMop = -1;//涂鸦T4 0x00：关闭 0x01：打开 0xff ：未设置

//    private int FORBID_WALL_WIDTH = 3;//虚拟墙宽度

    //active表示的是清洁程序：nomal表示是普通清扫，depth表示是重度清扫，forbid表示是禁止清扫
    public static final String ACTIVE_NORMAL = "normal";
    public static final String ACTIVE_DEPTH = "depth";
    public static final String ACTIVE_FORBID = "forbid";
    public static final String ACTIVE_POINT = "point";
    public static final String ACTIVE_DISPLAY = "display";

    //mode类型
    public static final String MODE_DEFAULT = "default";
    public static final String MODE_AREA = "area";
    public static final String MODE_POINT = "point";
    public static final String MODE_CURPOINT = "curpoint";
    public static final String MODE_ROOM = "room";
    public static final String MODE_AUTOLAYER = "autolayer";
    public static final String MODE_FURNITURE = "furniture";
    public static final String MODE_CARPET = "carpet";

    //appModel 类型
    public static final String APP_MODEL_ROOM = "room";
    public static final String APP_MODEL_DEFAULT = "default";

    //禁区属性，仅在禁区属性 active 字段中为forbid 有效
    public static final String FORBID_SWEEP = "sweep";
    public static final String FORBID_MOP = "mop";
    public static final String FORBID_ALL = "all";
    public static final String FORBID_WALL = "wall";

    private int floortype = -1;

    public ArrayList<PointF> getTempVertexs() {
        return tempVertexs;
    }

    public void setTempVertexs(ArrayList<PointF> tempVertexs) {
        this.tempVertexs = tempVertexs;
    }

    public LDArea() {

    }

    public ArrayList<PointF> getPointArrayList() {
        return pointArrayList;
    }

    public void setPointArrayList(ArrayList<PointF> pointArrayList) {
        this.pointArrayList = pointArrayList;
    }

    public Path getPath() {
        Path path = new Path();
        if (pointArrayList != null) {
            for (int i = 0; i < pointArrayList.size(); i++) {
                PointF point = pointArrayList.get(i);
                if (i == 0) {
                    path.moveTo(point.x, point.y);
                } else {
                    path.lineTo(point.x, point.y);
                }
            }
        }
        path.close();
        return path;
    }

    public LDArea clone() {
        LDArea ldArea = new LDArea();
        ldArea.setPointArrayList(getPointArrayList());
        ldArea.setName(getName());
        ldArea.setId(getId());
        ldArea.setTag(getTag());
        ldArea.setVertexs(getVertexs());
        ldArea.setActive(getActive());
        ldArea.setSelected(isSelected());
        ldArea.setTempVertexs(getTempVertexs());
        ldArea.setAngle(getAngle());
        ldArea.setMode(getMode());
        ldArea.setMapId(getMapId());
        ldArea.setAppModel(getAppModel());
        ldArea.setForbidType(getForbidType());
        ldArea.setFanLevel(getFanLevel());
        ldArea.setWaterPump(getWaterPump());
        ldArea.setCleanOrder(getCleanOrder());
        return ldArea;
    }

    public int getCleanOrder() {
        return cleanOrder;
    }

    public void setCleanOrder(int cleanOrder) {
        this.cleanOrder = cleanOrder;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public float[][] getVertexs() {
        return vertexs;
    }

    public void setVertexs(float[][] vertexs) {
        this.vertexs = vertexs;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getCleanCount() {
        return cleanCount;
    }

    public void setCleanCount(int cleanCount) {
        this.cleanCount = cleanCount;
    }

    public void vertexsToPointArrayList(LDSweepMap LDSweepMap, float scale, PointF origin) {
        if (vertexs != null) {
            if (pointArrayList == null) {
                pointArrayList = new ArrayList<>();
            }
            pointArrayList.clear();
            for (int i = 0; i < vertexs.length; i++) {
                if (vertexs[i].length >= 2) {
                    PointF point = new PointF(vertexs[i][0], vertexs[i][1]);
                    pointArrayList.add(pointToPixel(point, LDSweepMap, scale, origin));
                }
            }
        }
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

    public void pointArrayListToVertexs(LDSweepMap LDSweepMap, float scale, PointF origin) {
        if (pointArrayList != null && pointArrayList.size() > 0 && origin != null) {
            vertexs = null;
            vertexs = new float[pointArrayList.size()][2];
            if (LDSweepMap.getMapDataType() == MapDataType.TUYA_T4) {
                pointArrayListToVertexsT4(LDSweepMap, scale, origin);
            } else {//新固件扫地机不支持浮点型坐标
                for (int i = 0; i < pointArrayList.size(); i++) {
                    PointF point = pointArrayList.get(i);
                    PointF pointTrue = pixelToPoint(point, LDSweepMap, scale, origin);
                    if (pointTrue == null) {
                        continue;
                    }
                    vertexs[i][0] = Math.round(pointTrue.x);
                    vertexs[i][1] = Math.round(pointTrue.y);
                }
            }
        }
    }

    private void pointArrayListToVertexsT4(LDSweepMap LDSweepMap, float scale, PointF origin) {
        for (int i = 0; i < pointArrayList.size(); i++) {
            PointF point = pointArrayList.get(i);
            PointF pointTrue = pixelToPoint(point, LDSweepMap, scale, origin);
            if (pointTrue == null) {
                continue;
            }
            vertexs[i][0] = pointTrue.x;
            vertexs[i][1] = pointTrue.y;
        }
    }

    public void saveVertexToTempVertext(int[][] vertexs) {
        if (tempVertexs == null) {
            tempVertexs = new ArrayList<>();
        }
        if (tempVertexs != null) {
            for (int i = 0; i <= vertexs.length - 1; i++) {
                PointF point = new PointF();
                point.x = vertexs[i][0];
                point.y = vertexs[i][1];
                tempVertexs.add(point);
            }
        }
    }

    public void restoreTempVertexsToVertex() {
        if (tempVertexs != null && tempVertexs.size() > 0) {
            vertexs = null;
            vertexs = new float[tempVertexs.size()][2];
            for (int i = 0; i < tempVertexs.size(); i++) {
                vertexs[i][0] = tempVertexs.get(i).x;
                vertexs[i][1] = tempVertexs.get(i).y;
            }
        }
    }

    public void initFurnitureVertexs() {
        if (vertexs != null) {
            float temp1 = vertexs[1][0];
            float temp2 = vertexs[1][1];
            vertexs[1][0] = temp1;
            vertexs[1][1] = vertexs[0][1];
            vertexs[2][0] = temp1;
            vertexs[2][1] = temp2;
            vertexs[3][0] = vertexs[0][0];
            vertexs[3][1] = temp2;
        }

    }

    public String getAppModel() {
        return appModel;
    }

    public void setAppModel(String appModel) {
        this.appModel = appModel;
    }

    public String getForbidType() {
        return forbidType;
    }

    public void setForbidType(String forbidType) {
        this.forbidType = forbidType;
    }

    public boolean isWall() {
        //新版判断
        if (ACTIVE_FORBID.equals(active) && FORBID_WALL.equals(forbidType)) {
            return true;
        }
        return false;

        //旧版判断
//        if (FORBID_WALL.equals(name) && FORBID_ALL.equals(forbidType)){
//            return true;
//        }
//        return false;
    }


    /**
     * 将位置点转换为图像中的像素点
     * <p>
     * param Point    位置点
     * param LDSweepMap 输出点所要对应的地图
     * return 地图点
     */
    public static PointF pointToPixel(PointF point, LDSweepMap LDSweepMap, float scale, PointF origin) {
        if (point == null || LDSweepMap == null || origin == null) {
            return point;
        }
        if (LDSweepMap.getMapDataType() == MapDataType.TUYA_T4) {
            return pointToPixelT4(point, LDSweepMap, scale, origin);
        } else {
            float x = (point.x / 1000.0f - LDSweepMap.getX_min()) / LDSweepMap.getResolution();
            float y = (point.y / 1000.0f - LDSweepMap.getY_min()) / LDSweepMap.getResolution();
            y = LDSweepMap.getHeight() - y;
            x = Math.round(x * scale + origin.x);
            y = Math.round(y * scale + origin.y);
            return new PointF(x, y);
        }
    }

    /**
     * 将位置点转换为图像中的像素点
     * <p>
     * param Point    位置点
     * param LDSweepMap 输出点所要对应的地图
     * return 地图点
     */
    public static PointF pointToPixelT4(PointF point, LDSweepMap ldSweepMap, float scale, PointF origin) {
        if (point == null || ldSweepMap == null || origin == null) {
            return point;
        }
        return new PointF((point.x + ldSweepMap.getMapOx()) * scale + origin.x, (ldSweepMap.getMapOy() - point.y) * scale + origin.y);
    }

    /**
     * 将图像上的位置点转换为世界坐标系的位置点
     * <p>
     * param Point     图中的位置点
     * param LDSweepMap 对定的地图对象
     * return 世界坐标系的点
     */
    public static PointF pixelToPoint(PointF point, LDSweepMap LDSweepMap, float scale, PointF origin) {
        if (point == null || LDSweepMap == null || origin == null) {
            return point;
        }
        if (LDSweepMap.getMapDataType() == MapDataType.TUYA_T4) {
            return pixelToPointT4(point, LDSweepMap, scale, origin);
        } else {
            float x = (point.x - origin.x) / scale;
            float y = (point.y - origin.y) / scale;
            y = LDSweepMap.getHeight() - y;
            x = (x * LDSweepMap.getResolution() + LDSweepMap.getX_min()) * 1000.0f;
            y = (y * LDSweepMap.getResolution() + LDSweepMap.getY_min()) * 1000.0f;
            return new PointF(x, y);
        }
    }

    private static PointF pixelToPointT4(PointF point, LDSweepMap ldSweepMap, float scale, PointF origin) {
        if (point == null || ldSweepMap == null || origin == null) {
            return point;
        }
        return new PointF(decimal(((point.x - origin.x) / scale - ldSweepMap.getMapOx()), 1), decimal((ldSweepMap.getMapOy() - (point.y - origin.y) / scale), 1));
    }

    /**
     * 保留 {@param newScale} 位小数
     *
     * @param value
     * @param newScale 保留的小数位数
     * @return
     */
    public static float decimal(float value, int newScale) {
        try {
            return BigDecimal.valueOf(value).setScale(newScale, BigDecimal.ROUND_HALF_UP).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.pointArrayList);
        dest.writeString(this.name);
        dest.writeInt(this.id);
        dest.writeString(this.tag);
//        dest.writeParcelable(this.vertexs, flags);
        dest.writeString(this.active);
        dest.writeTypedList(this.tempVertexs);
        dest.writeFloat(this.angle);
        dest.writeString(this.mode);
        dest.writeInt(this.mapId);
        dest.writeString(this.appModel);
        dest.writeString(this.forbidType);
        dest.writeInt(this.cleanCount);
        dest.writeIntArray(this.fanLevel);
        dest.writeIntArray(this.waterPump);
        dest.writeInt(this.cleanOrder);
        dest.writeInt(this.yMop);
        dest.writeInt(this.floortype);
    }

    protected LDArea(Parcel in) {
        this.pointArrayList = in.createTypedArrayList(PointF.CREATOR);
        this.name = in.readString();
        this.id = in.readInt();
        this.tag = in.readString();
//        this.vertexs = in.readParcelable(float[][].class.getClassLoader());
        this.active = in.readString();
        this.tempVertexs = in.createTypedArrayList(PointF.CREATOR);
        this.angle = in.readFloat();
        this.mode = in.readString();
        this.mapId = in.readInt();
        this.appModel = in.readString();
        this.forbidType = in.readString();
        this.cleanCount = in.readInt();
        this.fanLevel = in.createIntArray();
        this.waterPump = in.createIntArray();
        this.cleanOrder = in.readInt();
        this.yMop = in.readInt();
        this.floortype = in.readInt();
    }

    public static final Creator<LDArea> CREATOR = new Creator<LDArea>() {
        @Override
        public LDArea createFromParcel(Parcel source) {
            return new LDArea(source);
        }

        @Override
        public LDArea[] newArray(int size) {
            return new LDArea[size];
        }
    };

    @Override
    public String toString() {
        return "LDArea{" +
                "pointArrayList=" + pointArrayList +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", tag='" + tag + '\'' +
                ", vertexs=" + Arrays.toString(vertexs) +
                ", active='" + active + '\'' +
                ", tempVertexs=" + tempVertexs +
                ", angle=" + angle +
                ", mode='" + mode + '\'' +
                ", mapId=" + mapId +
                ", appModel='" + appModel + '\'' +
                ", forbidType='" + forbidType + '\'' +
                ", cleanCount=" + cleanCount +
                ", fanLevel=" + Arrays.toString(fanLevel) +
                ", waterPump=" + Arrays.toString(waterPump) +
                ", cleanOrder=" + cleanOrder +
                ", yMop=" + yMop +
                ", floortype=" + floortype +
                '}';
    }
}