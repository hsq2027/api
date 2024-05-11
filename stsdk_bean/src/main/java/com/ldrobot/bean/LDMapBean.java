package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2023/8/3 18:52
 * @Description: 类的作用描述
 */
public class LDMapBean {
    private int code;//code=0或1为成功，否则为失败
    private byte[] mapData;//优化分区后的地图数据
    private String data;//转换后的地图数据
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public byte[] getMapData() {
        return mapData;
    }

    public void setMapData(byte[] mapData) {
        this.mapData = mapData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}