package com.ldrobot.bean;

/**
 * 创建时间：2020/6/5  23:28
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class CurPathHeaderBean {
    private int headerLen;
    private int version;
    private int pathId;
    private int dataLen;
    private int startPos;
    private int startX;
    private int startY;

    public CurPathHeaderBean(byte[] bytes, int offset) {
        update(bytes, offset);
    }

    private void update(byte[] bytes, int offset) {
        int p = offset;
        headerLen = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
        p += 4;
        version = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
        p += 4;
        pathId = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
        p += 4;
        dataLen = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
        p += 4;
        startPos = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
        p += 4;
        startX = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
        p += 4;
        startY = C2JavaTypeSwitch.getIntFromArray(bytes, p, 4);
    }

    public int getHeaderLen() {
        return headerLen;
    }

    public void setHeaderLen(int headerLen) {
        this.headerLen = headerLen;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getDataLen() {
        return dataLen;
    }

    public void setDataLen(int dataLen) {
        this.dataLen = dataLen;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    @Override
    public String toString() {
        return "CurPathHeaderBean{" +
                "headerLen=" + headerLen +
                ", version=" + version +
                ", pathId=" + pathId +
                ", dataLen=" + dataLen +
                ", startPos=" + startPos +
                ", startX=" + startX +
                ", startY=" + startY +
                '}';
    }
}