package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2022/7/7 16:20
 * @Description: java类作用描述
 */
public class SweepPathP2P {
    /**
     * data : {"pathID":14,"pointCounts":11,"posArray":[[-319,225],[-260,224],[-260,172],[-260,120],[-260,68],[-260,16],[-260,-28],[-260,20],[-260,76],[-260,132],[-260,184]],"startPos":0,"totalPoints":11}
     * infoType : 21011
     * message : ok
     * ts : 1657181756
     */

    private DataBean data;
    private int infoType;
    private String message;
    private long ts;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public static class DataBean {
        /**
         * pathID : 14
         * pointCounts : 11
         * posArray : [[-319,225],[-260,224],[-260,172],[-260,120],[-260,68],[-260,16],[-260,-28],[-260,20],[-260,76],[-260,132],[-260,184]]
         * startPos : 0
         * totalPoints : 11
         */

        private int pathID;
        private int pointCounts;
        private int startPos;
        private int totalPoints;
        private float[][] posArray;

        public int getPathID() {
            return pathID;
        }

        public void setPathID(int pathID) {
            this.pathID = pathID;
        }

        public int getPointCounts() {
            return pointCounts;
        }

        public void setPointCounts(int pointCounts) {
            this.pointCounts = pointCounts;
        }

        public int getStartPos() {
            return startPos;
        }

        public void setStartPos(int startPos) {
            this.startPos = startPos;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public float[][] getPosArray() {
            return posArray;
        }

        public void setPosArray(float[][] posArray) {
            this.posArray = posArray;
        }
    }
}