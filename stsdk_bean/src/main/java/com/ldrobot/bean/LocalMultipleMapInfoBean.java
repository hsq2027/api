package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/5/6 15:15
 * @Description: java类作用描述
 */
public class LocalMultipleMapInfoBean {
    private List<MapsBean> maps;

    public List<MapsBean> getMaps() {
        return maps;
    }

    public void setMaps(List<MapsBean> maps) {
        this.maps = maps;
    }

    public static class MapsBean {
        /**
         * mapId : 1617886878
         * record : AUTOPACK000001_1617886878_1618501434_1618514983_84_85779_1.txt
         * tag : Map1617886878
         * updateTime : 1619533202
         * usageCounter : 1
         * usageTime : 0
         */

        private long mapId;
        private String record;
        private String tag;
        private long updateTime;
        private int usageCounter;
        private int usageTime;

        public long getMapId() {
            return mapId;
        }

        public void setMapId(long mapId) {
            this.mapId = mapId;
        }

        public String getRecord() {
            return record;
        }

        public void setRecord(String record) {
            this.record = record;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getUsageCounter() {
            return usageCounter;
        }

        public void setUsageCounter(int usageCounter) {
            this.usageCounter = usageCounter;
        }

        public int getUsageTime() {
            return usageTime;
        }

        public void setUsageTime(int usageTime) {
            this.usageTime = usageTime;
        }
    }
}