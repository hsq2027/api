package com.ldrobot.bean;

import java.util.HashMap;

/**
 * @Author: hsq
 * @CreateTime: 2023/7/27 15:02
 * @Description: 类的作用描述
 */
public class LDMap {
    private int mapId;
    private int lz4_len;
    private int base64_len;
    private float x_min;
    private float y_min;
    private int width;
    private int height;
    private String map;
    private int roomCount;
    private int autoAreaId;
    private float resolution;
    private int[] chargeHandlePos;
    private int pixLen;//压缩前的数据长度
    private int mapDataOffsetLength;
    private int mapDataType;//地图数据类型，0默认；1涂鸦T4协议数据

    public int getLz4_len() {
        return lz4_len;
    }

    public void setLz4_len(int lz4_len) {
        this.lz4_len = lz4_len;
    }

    public int getBase64_len() {
        return base64_len;
    }

    public void setBase64_len(int base64_len) {
        this.base64_len = base64_len;
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

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getAutoAreaId() {
        return autoAreaId;
    }

    public void setAutoAreaId(int autoAreaId) {
        this.autoAreaId = autoAreaId;
    }

    public float getResolution() {
        return resolution;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }

    public int getPixLen() {
        return pixLen;
    }

    public void setPixLen(int pixLen) {
        this.pixLen = pixLen;
    }

    public int getMapDataOffsetLength() {
        return mapDataOffsetLength;
    }

    public void setMapDataOffsetLength(int mapDataOffsetLength) {
        this.mapDataOffsetLength = mapDataOffsetLength;
    }

    public int getMapDataType() {
        return mapDataType;
    }

    public void setMapDataType(int mapDataType) {
        this.mapDataType = mapDataType;
    }

    public int[] getChargeHandlePos() {
        return chargeHandlePos;
    }

    public void setChargeHandlePos(int[] chargeHandlePos) {
        this.chargeHandlePos = chargeHandlePos;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public HashMap<String, Object> getOptimizeRoomData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("mapId", mapId);
        hashMap.put("lz4_len", lz4_len);
        hashMap.put("base64_len", base64_len);
        hashMap.put("x_min", x_min);
        hashMap.put("y_min", y_min);
        hashMap.put("width", width);
        hashMap.put("height", height);
        hashMap.put("map", map);
        hashMap.put("roomCount", roomCount);
        hashMap.put("autoAreaId", autoAreaId);
        hashMap.put("resolution", resolution);
        hashMap.put("chargeHandlePos", chargeHandlePos);
        return hashMap;
    }
}