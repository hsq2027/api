package com.ldrobot.bean;

import com.ldrobot.bean.interfaces.SocketCallBack;

/**
 * Created by lenovo on 2016/4/11.
 */
public class SocketResponse {

    private String message;
    private Object data;
    private int infoType;
    private String devId;
    private long timestamp;

    private int timeout;

    private String sn;

    private DInfo dInfo;

    private SocketCallBack socketCallBack;

    public int getInfoType() {
        return infoType;
    }

    public void setInfoType(int infoType) {
        this.infoType = infoType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SocketCallBack getSocketCallBack() {
        return socketCallBack;
    }

    public void setSocketCallBack(SocketCallBack socketCallBack) {
        this.socketCallBack = socketCallBack;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public DInfo getdInfo() {
        return dInfo;
    }

    public void setdInfo(DInfo dInfo) {
        this.dInfo = dInfo;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    @Override
    public String toString() {
        return "SocketResponse{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", infoType=" + infoType +
                ", devId='" + devId + '\'' +
                ", timestamp=" + timestamp +
                ", timeout=" + timeout +
                ", sn='" + sn + '\'' +
                ", dInfo=" + dInfo +
                ", socketCallBack=" + socketCallBack +
                '}';
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public class DInfo {
        private String ts;
        private String userId;

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}