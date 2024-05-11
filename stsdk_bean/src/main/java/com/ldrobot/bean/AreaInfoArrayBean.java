package com.ldrobot.bean;

import java.util.ArrayList;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/21 17:43
 * @Description: java类作用描述
 */
public class AreaInfoArrayBean {
    private ArrayList<LDRoom> autoAreaValue;
    private long mapId;
    private ArrayList<LDArea> value;

    public ArrayList<LDRoom> getAutoAreaValue() {
        return autoAreaValue;
    }

    public void setAutoAreaValue(ArrayList<LDRoom> autoAreaValue) {
        this.autoAreaValue = autoAreaValue;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public ArrayList<LDArea> getValue() {
        return value;
    }

    public void setValue(ArrayList<LDArea> value) {
        this.value = value;
    }
}