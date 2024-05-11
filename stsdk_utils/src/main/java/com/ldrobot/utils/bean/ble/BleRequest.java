package com.ldrobot.utils.bean.ble;

public class BleRequest {
    private String data;
    private int len;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    @Override
    public String toString() {
        return "BleResponse{" +
                "data='" + data + '\'' +
                ", len=" + len +
                '}';
    }
}