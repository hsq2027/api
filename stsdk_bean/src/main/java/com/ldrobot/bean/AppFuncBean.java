package com.ldrobot.bean;

/**
 * 创建时间：2020/4/22  23:43
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class AppFuncBean {

    /**
     * productKey : a2S7mOOUMOS
     * APP_function : {"camera":0,"automaticPartitioning":1,"pathHiding":0,"dustCollection":1,"waterSpeedRegulation":1,"YDrag":0}
     */

    private String productKey;
    private APPFunctionBean APP_function;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public APPFunctionBean getAPP_function() {
        return APP_function;
    }

    public void setAPP_function(APPFunctionBean APP_function) {
        this.APP_function = APP_function;
    }

    public static class APPFunctionBean {
        /**
         * "camera": 1,  //摄像头 1：有  0：无
         * "automaticPartitioning": 1,  //自动分区 1：有 0：无
         * "pathHiding": 1,   //路径隐藏  1：有 0：无
         * "dustCollection": 0,  //集尘管理  1：有  0：无
         * "waterSpeedRegulation": 1,  // 水量调节 1：有 0：无
         * "waterSpeedGearsNumber":"1,2,3",  // 水量调节档位 0：禁止 1：一档 2：二档 3：三档
         * "fanControl": 1, //吸力调节 1：有 0：无
         * "fanControlGearsNumber":"1,2,3", // 吸力调节档位 0：禁止 1：一档 2：二档 3：三档
         * "YDrag": 0,  //Y字拖 1：有 0：无
         * "RemoteControl":1,   //遥控器 1：有 0：无
         * "distributionNetworkMode":"1",  //配网模式 1：AP配网  2：一键配网  3：扫码配网  4：蓝牙配网
         * "cleaningMode":"1,2,3"  //清扫方式  1：分区清扫 2：全图清扫  3：区域清扫   4：定点清扫
         * "voicePacketType":1   //语音包类型  0：老的 1：新的
         */

        private int camera;//摄像头 1：有  0：无
        private int automaticPartitioning;//自动分区 1：有 0：无
        private int pathHiding = 1;//路径隐藏  1：有 0：无
        private String pathHidingType = "1,3,4";//默认1,3,4   隐藏的路径类型
        private int dustCollection;//集尘管理  1：有  0：无
        private int waterSpeedRegulation;// 水量调节 1：有 0：无
        private String waterSpeedGearsNumber = "1,2,3";// 水量调节档位 0：禁止 1：一档 2：二档 3：三档
        private int fanControl;//吸力调节 1：有 0：无
        private String fanControlGearsNumber = "1,2,3";// 吸力调节档位 0：禁止 1：一档 2：二档 3：三档
        private int YDrag;//Y字拖 1：有 0：无
        private int RemoteControl;//遥控器 1：有 0：无
        private String distributionNetworkMode = "1";//配网模式 1：AP配网  2：一键配网  3：扫码配网  4：蓝牙配网
        private String cleaningMode;//清扫方式  1：分区清扫 2：全图清扫  3：区域清扫   4：定点清扫
        private int voicePacket;//语音包类型  0：老的 1：新的
        private int voicePacketType;//语音包类型  0：老的 1：新的
        private int productGuide;//默认0 是否有产品指南 0 无 1 有
        private int carpetMode;//默认0 地毯模式  1：有  0：无
        private int localMap;//默认0 本地多地图  1：有  0：无
        private int cloudMap;//默认0 云端多地图  1：有  0：无
        private int laboratory;//默认0 实验室  1：有  0：无
        private int carpetPressurization;//默认0 地毯增压  1：有  0：无
        private int AIObstacleAvoidance;//是否支持AI避障  1：支持  0：不支持

        public int getVoicePacketType() {
            return voicePacketType;
        }

        public void setVoicePacketType(int voicePacketType) {
            this.voicePacketType = voicePacketType;
        }

        public int getCamera() {
            return camera;
        }

        public void setCamera(int camera) {
            this.camera = camera;
        }

        public int getAutomaticPartitioning() {
            return automaticPartitioning;
        }

        public void setAutomaticPartitioning(int automaticPartitioning) {
            this.automaticPartitioning = automaticPartitioning;
        }

        public int getPathHiding() {
            return pathHiding;
        }

        public void setPathHiding(int pathHiding) {
            this.pathHiding = pathHiding;
        }

        public int getDustCollection() {
            return dustCollection;
        }

        public void setDustCollection(int dustCollection) {
            this.dustCollection = dustCollection;
        }

        public int getWaterSpeedRegulation() {
            return waterSpeedRegulation;
        }

        public void setWaterSpeedRegulation(int waterSpeedRegulation) {
            this.waterSpeedRegulation = waterSpeedRegulation;
        }

        public int getYDrag() {
            return YDrag;
        }

        public void setYDrag(int YDrag) {
            this.YDrag = YDrag;
        }

        public String getWaterSpeedGearsNumber() {
            return waterSpeedGearsNumber;
        }

        public void setWaterSpeedGearsNumber(String waterSpeedGearsNumber) {
            this.waterSpeedGearsNumber = waterSpeedGearsNumber;
        }

        public int getRemoteControl() {
            return RemoteControl;
        }

        public void setRemoteControl(int remoteControl) {
            RemoteControl = remoteControl;
        }

        public int getFanControl() {
            return fanControl;
        }

        public void setFanControl(int fanControl) {
            this.fanControl = fanControl;
        }

        public String getFanControlGearsNumber() {
            return fanControlGearsNumber;
        }

        public void setFanControlGearsNumber(String fanControlGearsNumber) {
            this.fanControlGearsNumber = fanControlGearsNumber;
        }

        public String getDistributionNetworkMode() {
            if (distributionNetworkMode == null) {
                distributionNetworkMode = "";
            }
            return distributionNetworkMode;
        }

        public void setDistributionNetworkMode(String distributionNetworkMode) {
            this.distributionNetworkMode = distributionNetworkMode;
        }

        public String getCleaningMode() {
            if (cleaningMode == null) {
                cleaningMode = "";
            }
            return cleaningMode;
        }

        public void setCleaningMode(String cleaningMode) {
            this.cleaningMode = cleaningMode;
        }

        public int getProductGuide() {
            return productGuide;
        }

        public void setProductGuide(int productGuide) {
            this.productGuide = productGuide;
        }

        public int getCarpetMode() {
            return carpetMode;
        }

        public void setCarpetMode(int carpetMode) {
            this.carpetMode = carpetMode;
        }

        public int getLocalMap() {
            return localMap;
        }

        public void setLocalMap(int localMap) {
            this.localMap = localMap;
        }

        public int getLaboratory() {
            return laboratory;
        }

        public void setLaboratory(int laboratory) {
            this.laboratory = laboratory;
        }

        public String getPathHidingType() {
            return pathHidingType;
        }

        public void setPathHidingType(String pathHidingType) {
            this.pathHidingType = pathHidingType;
        }

        public int getCarpetPressurization() {
            return carpetPressurization;
        }

        public void setCarpetPressurization(int carpetPressurization) {
            this.carpetPressurization = carpetPressurization;
        }

        public int getVoicePacket() {
            return voicePacket;
        }

        public void setVoicePacket(int voicePacket) {
            this.voicePacket = voicePacket;
        }

        public int getCloudMap() {
            return cloudMap;
        }

        public void setCloudMap(int cloudMap) {
            this.cloudMap = cloudMap;
        }

        public int getAIObstacleAvoidance() {
            return AIObstacleAvoidance;
        }

        public void setAIObstacleAvoidance(int AIObstacleAvoidance) {
            this.AIObstacleAvoidance = AIObstacleAvoidance;
        }

        @Override
        public String toString() {
            return "APPFunctionBean{" +
                    "camera=" + camera +
                    ", automaticPartitioning=" + automaticPartitioning +
                    ", pathHiding=" + pathHiding +
                    ", pathHidingType='" + pathHidingType + '\'' +
                    ", dustCollection=" + dustCollection +
                    ", waterSpeedRegulation=" + waterSpeedRegulation +
                    ", waterSpeedGearsNumber='" + waterSpeedGearsNumber + '\'' +
                    ", fanControl=" + fanControl +
                    ", fanControlGearsNumber='" + fanControlGearsNumber + '\'' +
                    ", YDrag=" + YDrag +
                    ", RemoteControl=" + RemoteControl +
                    ", distributionNetworkMode='" + distributionNetworkMode + '\'' +
                    ", cleaningMode='" + cleaningMode + '\'' +
                    ", voicePacket=" + voicePacket +
                    ", voicePacketType=" + voicePacketType +
                    ", productGuide=" + productGuide +
                    ", carpetMode=" + carpetMode +
                    ", localMap=" + localMap +
                    ", cloudMap=" + cloudMap +
                    ", laboratory=" + laboratory +
                    ", carpetPressurization=" + carpetPressurization +
                    ", AIObstacleAvoidance=" + AIObstacleAvoidance +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppFuncBean{" +
                "productKey='" + productKey + '\'' +
                ", APP_function=" + APP_function +
                '}';
    }
}