package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/7/18 15:22
 * @Description: java类作用描述
 */
public class BindDeviceBean {
    /**
     * code : 200
     * data : V7WG3rKaacp487tADyGy000000
     * id : 4f87ba9f-e612-4fec-aa9b-b8bdc8db4f4a
     * rawData : [123,34,99,111,100,101,34,58,50,48,48,44,34,100,97,116,97,34,58,34,86,55,87,71,51,114,75,97,97,99,112,52,56,55,116,65,68,121,71,121,48,48,48,48,48,48,34,44,34,105,100,34,58,34,52,102,56,55,98,97,57,102,45,101,54,49,50,45,52,102,101,99,45,97,97,57,98,45,98,56,98,100,99,56,100,98,52,102,52,97,34,125,10]
     * localizedMsg :
     * message :
     */

    private int code;
    private String data;
    private String id;
    private String localizedMsg;
    private String message;
    private List<Integer> rawData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalizedMsg() {
        return localizedMsg;
    }

    public void setLocalizedMsg(String localizedMsg) {
        this.localizedMsg = localizedMsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getRawData() {
        return rawData;
    }

    public void setRawData(List<Integer> rawData) {
        this.rawData = rawData;
    }
}