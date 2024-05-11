package com.ldrobot.bean;

import android.graphics.Point;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Emiya on 16/12/26.
 */

public class SweepStatus implements Serializable {

    public static final String IDLE = "idle";     //待机中
    public static final String CHARGE = "charge";   //充电中
    public static final String SWEEP = "sweep";    //扫地中
    public static final String MOP = "mop";      //拖地中
    public static final String PAUSE = "pause";    //暂停中
    public static final String FAU = "fault";    //故障中
    public static final String FAU1 = "in_trouble";    //故障中
    public static final String BACKCHARGE = "backcharge";   //回冲中
    public static final String CONTROL = "rfctrl";    //遥控中
    public static final String DORMANT = "dormant";    //休眠中
    public static final String FULLCHARGE = "fullcharge";    //充电完成
    public static final String MODECURPOINT = "curpoint";    //遥控点击定点清扫，返回的值
    public static final String FINDCHARGERPAUSE = "findchargerpause";    //回充暂停
    public static final String SHUTDOWN = "shutdown";    //关机
    public static final String DUST = "dust";    //集尘
    public static final String MAPPING = "mapping";    //建图中

    public static final String NULL = "null";     //无任务
    public static final String TOTAL = "total";   //全图清扫
    public static final String POINT = "point";   //定点清扫
    public static final String AREA = "area";     //区域清扫
    public static final String SMART_TOTAL = "smart";     //智能清扫中
    public static final String SMART_AREA = "smartArea";     //分区清扫中
    public static final String CURPOINT = "curpoint";   //原地清扫

    public static final String UPTATING = "updating";     //升级中

    //    public static final String QUIET = "quiet";     //安静模式
//    public static final String STRONG = "strong";   //强力模式
//    public static final String AUTO = "auto";    //自定义模式
//    public static final String WIND_MOP = "mop";    // //拖地模式(风机关闭)
    public static final int WIND_MOP = 0;    // //拖地模式(风机关闭)
    public static final int QUIET = 1;     //安静模式
    public static final int AUTO = 2;    //自定义模式
    public static final int STRONG = 3;   //强力模式
    public static final int MAX = 4;   //强力模式1

    public static final int DRY = 0;   //干拖，无水
    public static final int LOW = 1;   //低档水流
    public static final int MID = 2;   //中档水流
    public static final int HIGH = 3;   //高档水流

    private int[] pos; //扫地机位置 x,y
    private float phi = -1.0f;//扫地机角度
    private int elec = -1;//?
    private int elecReal = -1; //实时电量
    private int cleanArea = -1;//设备本次清扫面积
    private int allArea = -1; //设备总的清扫面积
    private int cleanTime = -1;//设备本次清扫时间
    private int allTime = -1;//设备总的清扫时间
    private int mapRotateDegree = -666;//地图旋转角度
    private String mode; //清扫模式
    private String subMode;//子模式
    private int windPower = -1;//
    private String workNoisy;  //工作模式 quiet,strong,auto;
    private int vol = -1;   //音量 1-10
    private int led = -1;   //开关 开:1 关:2
    private int dustCenterFreq = -1; //工作站运行频率  清扫几次后工作站才会启动运行，默认值1
    private int workstationType = -1;//工作站类型   01:普通充电桩，102:集尘宝，默认值101
    private int water = -1;  //水量
    private String sn;
    private int[] errorState; //错误消息
    private MyPoint point; //扫地机位置，point
    private long timeStamp; //时间戳
    private String WIFI_AP_BSSID;//配网路由名称
    private int WiFI_RSSI = -1; //信号强度。-50到-55：非常好，-56到-62：比较好，-63到-83：一般，-84到-100：很差
    private int WIFI_Channel = -1; //WiFi信道
    private int WiFI_SNR = -1; //信噪比
    private String WiFI_IP; //本地WIFI的名称
    private String MACAddress; // MAC地址
    private String McuVersion; //
    private int GitCnt = -1; //
    private String WIFI_Band; // 所属频段
    private String firmwareVersion;//固件版本号
    private int sensorTime = -1;  //传感器耗损
    private int mainBrushTime = -1;//主刷耗损  单位min
    private int sideBrushTime = -1;//边刷耗损  单位min
    private int filterTime = -1;//过滤器耗损  单位min
    private int runTimes = -1;//运行次数
    private String appointStr;//预约
    private int mop = -1;// 拖地模式  0 关  1 开
    private boolean hasUpdateVol = false;  //本地字段，判断音量是否更新
    private boolean hasUpdateLed = false;
    private boolean hasUpdateWind = false;
    private boolean hasUpdateWater = false;
    private int PathType = -1;//0 normal  1 y  2 repeat
    private int uvMode = -1;// 0 normal 1 uv 2 st
    private int robotFault = -1;//机器故障
    private int robotWarnMsg = -1;//机器提示消息上报
    private int breakClean = -1;//断点续扫开关
    private String robotKey;//分区优化机器校验码

    private int sweepMopMode = -1;//0:只扫，1:只拖，2：扫拖
    private int edgeClean = -1;//沿边清扫开关，1开启
    private int cleanCount = 1;//清扫次数

    private int UseAutoAreaValue = -1;//0 关闭定制模式，1 开启定制模式
    private Boolean carpetBoost;//地毯增压开关

    private Boolean doNotDisturb;

    private String MultiMapsInfo;
    private String MultiMapData0;
    private String MultiMapData1;
    private String MultiMapData2;

    private String devId;

    private String ldObstacleList;
    private int cameraSwitch = -1;
    private int aiObstacleSwitch = -1;
    private int aiSceneSwitch = -1;
    private int aiFloorSwitch = -1;
    private int lightSwitch = -1;
    private int micSwitch = -1;
    private int speakerSwitch = -1;
    private int devUpdateSwitch = -1;
    private int currentVoiceId = -1;

    private String BaseStationSn;//基站SN码
    private String BaseStationVersion;//基站本地固件版本
    private String BaseStationLocalVersion;//基站待OTA固件版本

    public String getMultiMapsInfo() {
        return MultiMapsInfo;
    }

    public void setMultiMapsInfo(String multiMapsInfo) {
        MultiMapsInfo = multiMapsInfo;
    }

    public String getMultiMapData0() {
        return MultiMapData0;
    }

    public void setMultiMapData0(String multiMapData0) {
        MultiMapData0 = multiMapData0;
    }

    public String getMultiMapData1() {
        return MultiMapData1;
    }

    public void setMultiMapData1(String multiMapData1) {
        MultiMapData1 = multiMapData1;
    }

    public String getMultiMapData2() {
        return MultiMapData2;
    }

    public void setMultiMapData2(String multiMapData2) {
        MultiMapData2 = multiMapData2;
    }

    public int getUseAutoAreaValue() {
        return UseAutoAreaValue;
    }

    public void setUseAutoAreaValue(int useAutoAreaValue) {
        UseAutoAreaValue = useAutoAreaValue;
    }

    public int getSweepMopMode() {
        return sweepMopMode;
    }

    public void setSweepMopMode(int sweepMopMode) {
        this.sweepMopMode = sweepMopMode;
    }

    public int getPathType() {
        return PathType;
    }

    public void setPathType(int pathType) {
        PathType = pathType;
    }

    public int getUvMode() {
        return uvMode;
    }

    public void setUvMode(int uvMode) {
        this.uvMode = uvMode;
    }

    public boolean isHasUpdateWater() {
        return hasUpdateWater;
    }

    public void setHasUpdateWater(boolean hasUpdateWater) {
        this.hasUpdateWater = hasUpdateWater;
    }

    public boolean isHasUpdateWind() {
        return hasUpdateWind;
    }

    public void setHasUpdateWind(boolean hasUpdateWind) {
        this.hasUpdateWind = hasUpdateWind;
    }

    public boolean isHasUpdateLed() {
        return hasUpdateLed;
    }

    public void setHasUpdateLed(boolean hasUpdateLed) {
        this.hasUpdateLed = hasUpdateLed;
    }

    public boolean isHasUpdateVol() {
        return hasUpdateVol;
    }

    public void setHasUpdateVol(boolean hasUpdateVol) {
        this.hasUpdateVol = hasUpdateVol;
    }

    public int getWiFI_RSSI() {
        return WiFI_RSSI;
    }

    public void setWiFI_RSSI(int wiFI_RSSI) {
        WiFI_RSSI = wiFI_RSSI;
    }

    public int getWIFI_Channel() {
        return WIFI_Channel;
    }

    public void setWIFI_Channel(int WIFI_Channel) {
        this.WIFI_Channel = WIFI_Channel;
    }

    public int getWiFI_SNR() {
        return WiFI_SNR;
    }

    public void setWiFI_SNR(int wiFI_SNR) {
        WiFI_SNR = wiFI_SNR;
    }

    public String getWiFI_IP() {
        return WiFI_IP;
    }

    public void setWiFI_IP(String wiFI_IP) {
        WiFI_IP = wiFI_IP;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public void setPoint() {
        if (point == null)
            point = new MyPoint();
        if (pos != null && pos.length >= 2) {
            point.set(pos[0], pos[1]);
        }
    }

    public int getSensorTime() {
        return sensorTime;
    }

    public void setSensorTime(int sensorTime) {
        this.sensorTime = sensorTime;
    }

    public int getMainBrushTime() {
        return mainBrushTime;
    }

    public void setMainBrushTime(int mainBrushTime) {
        this.mainBrushTime = mainBrushTime;
    }

    public int getSideBrushTime() {
        return sideBrushTime;
    }

    public void setSideBrushTime(int sideBrushTime) {
        this.sideBrushTime = sideBrushTime;
    }

    public int getFilterTime() {
        return filterTime;
    }

    public void setFilterTime(int filterTime) {
        this.filterTime = filterTime;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Point getPoint() {
        return point;
    }

    public float getPhi() {
        return phi;
    }

    public void setPhi(float phi) {
        this.phi = phi;
    }

    public int getElec() {
        return elec;
    }

    public void setElec(int elec) {
        this.elec = elec;
    }

    public int getCleanArea() {
        return cleanArea;
    }

    public void setCleanArea(int cleanArea) {
        this.cleanArea = cleanArea;
    }

    public int getAllArea() {
        return allArea;
    }

    public void setAllArea(int allArea) {
        this.allArea = allArea;
    }

    public int getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(int cleanTime) {
        this.cleanTime = cleanTime;
    }

    public int getAllTime() {
        return allTime;
    }

    public void setAllTime(int allTime) {
        this.allTime = allTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getWindPower() {
        return windPower;
    }

    public void setWindPower(int windPower) {
        this.windPower = windPower;
    }

    public String getSubMode() {
        return subMode;
    }

    public void setSubMode(String subMode) {
        this.subMode = subMode;
    }

    public String getWorkNoisy() {
        return workNoisy;
    }

    public void setWorkNoisy(String workNoisy) {
        this.workNoisy = workNoisy;
    }

    public int getElecReal() {
        return elecReal;
    }

    public void setElecReal(int elecReal) {
        this.elecReal = elecReal;
    }

    public int[] getErrorState() {
        return errorState;
    }

    public void setErrorState(int[] errorState) {
        this.errorState = errorState;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getLed() {
        return led;
    }

    public void setLed(int led) {
        this.led = led;
    }

    public int getDustCenterFreq() {
        return dustCenterFreq;
    }

    public void setDustCenterFreq(int dustCenterFreq) {
        this.dustCenterFreq = dustCenterFreq;
    }

    public int getWorkstationType() {
        return workstationType;
    }

    public void setWorkstationType(int workstationType) {
        this.workstationType = workstationType;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public String getWIFI_AP_BSSID() {
        return WIFI_AP_BSSID;
    }

    public void setWIFI_AP_BSSID(String WIFI_AP_BSSID) {
        this.WIFI_AP_BSSID = WIFI_AP_BSSID;
    }

    public int getRunTimes() {
        return runTimes;
    }

    public void setRunTimes(int runTimes) {
        this.runTimes = runTimes;
    }

    public String getMACAddress() {
        return MACAddress;
    }

    public void setMACAddress(String MACAddress) {
        this.MACAddress = MACAddress;
    }

    public String getWIFI_Band() {
        return WIFI_Band;
    }

    public void setWIFI_Band(String WIFI_Band) {
        this.WIFI_Band = WIFI_Band;
    }

    public String getMcuVersion() {
        return McuVersion;
    }

    public void setMcuVersion(String mcuVersion) {
        McuVersion = mcuVersion;
    }

    public int getGitCnt() {
        return GitCnt;
    }

    public void setGitCnt(int gitCnt) {
        GitCnt = gitCnt;
    }

    public String getAppointStr() {
        return appointStr;
    }

    public void setAppointStr(String appointStr) {
        this.appointStr = appointStr;
    }

    public int getMop() {
        return mop;
    }

    public void setMop(int mop) {
        this.mop = mop;
    }

    public int getRobotFault() {
        return robotFault;
    }

    public void setRobotFault(int robotFault) {
        this.robotFault = robotFault;
    }

    public int getRobotWarnMsg() {
        return robotWarnMsg;
    }

    public void setRobotWarnMsg(int robotWarnMsg) {
        this.robotWarnMsg = robotWarnMsg;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Boolean getDoNotDisturb() {
        return doNotDisturb;
    }

    public void setDoNotDisturb(Boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public String getLdObstacleList() {
        return ldObstacleList;
    }

    public void setLdObstacleList(String ldObstacleList) {
        this.ldObstacleList = ldObstacleList;
    }

    public int getCameraSwitch() {
        return cameraSwitch;
    }

    public void setCameraSwitch(int cameraSwitch) {
        this.cameraSwitch = cameraSwitch;
    }

    public int getAiObstacleSwitch() {
        return aiObstacleSwitch;
    }

    public void setAiObstacleSwitch(int aiObstacleSwitch) {
        this.aiObstacleSwitch = aiObstacleSwitch;
    }

    public int getAiSceneSwitch() {
        return aiSceneSwitch;
    }

    public void setAiSceneSwitch(int aiSceneSwitch) {
        this.aiSceneSwitch = aiSceneSwitch;
    }

    public int getAiFloorSwitch() {
        return aiFloorSwitch;
    }

    public void setAiFloorSwitch(int aiFloorSwitch) {
        this.aiFloorSwitch = aiFloorSwitch;
    }

    public int getLightSwitch() {
        return lightSwitch;
    }

    public void setLightSwitch(int lightSwitch) {
        this.lightSwitch = lightSwitch;
    }

    public int getMicSwitch() {
        return micSwitch;
    }

    public void setMicSwitch(int micSwitch) {
        this.micSwitch = micSwitch;
    }

    public int getSpeakerSwitch() {
        return speakerSwitch;
    }

    public void setSpeakerSwitch(int speakerSwitch) {
        this.speakerSwitch = speakerSwitch;
    }

    public int getDevUpdateSwitch() {
        return devUpdateSwitch;
    }

    public void setDevUpdateSwitch(int devUpdateSwitch) {
        this.devUpdateSwitch = devUpdateSwitch;
    }

    public Boolean getCarpetBoost() {
        return carpetBoost;
    }

    public void setCarpetBoost(Boolean carpetBoost) {
        this.carpetBoost = carpetBoost;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getBaseStationSn() {
        return BaseStationSn;
    }

    public void setBaseStationSn(String baseStationSn) {
        BaseStationSn = baseStationSn;
    }

    public String getBaseStationVersion() {
        return BaseStationVersion;
    }

    public void setBaseStationVersion(String baseStationVersion) {
        BaseStationVersion = baseStationVersion;
    }

    public String getBaseStationLocalVersion() {
        return BaseStationLocalVersion;
    }

    public void setBaseStationLocalVersion(String baseStationLocalVersion) {
        BaseStationLocalVersion = baseStationLocalVersion;
    }

    public int getCurrentVoiceId() {
        return currentVoiceId;
    }

    public void setCurrentVoiceId(int currentVoiceId) {
        this.currentVoiceId = currentVoiceId;
    }

    public int getBreakClean() {
        return breakClean;
    }

    public void setBreakClean(int breakClean) {
        this.breakClean = breakClean;
    }

    @Override
    public String toString() {
        return "SweepStatus{" +
                "pos=" + Arrays.toString(pos) +
                ", phi=" + phi +
                ", elec=" + elec +
                ", elecReal=" + elecReal +
                ", cleanArea=" + cleanArea +
                ", mapRotateDegree=" + mapRotateDegree +
                ", allArea=" + allArea +
                ", cleanTime=" + cleanTime +
                ", allTime=" + allTime +
                ", robotKey='" + robotKey + '\'' +
                ", mode='" + mode + '\'' +
                ", subMode='" + subMode + '\'' +
                ", windPower=" + windPower +
                ", workNoisy='" + workNoisy + '\'' +
                ", vol=" + vol +
                ", led=" + led +
                ", dustCenterFreq=" + dustCenterFreq +
                ", workstationType=" + workstationType +
                ", water=" + water +
                ", sn='" + sn + '\'' +
                ", errorState=" + Arrays.toString(errorState) +
                ", point=" + point +
                ", timeStamp=" + timeStamp +
                ", WIFI_AP_BSSID='" + WIFI_AP_BSSID + '\'' +
                ", WiFI_RSSI=" + WiFI_RSSI +
                ", WIFI_Channel=" + WIFI_Channel +
                ", WiFI_SNR=" + WiFI_SNR +
                ", WiFI_IP='" + WiFI_IP + '\'' +
                ", MACAddress='" + MACAddress + '\'' +
                ", McuVersion='" + McuVersion + '\'' +
                ", GitCnt=" + GitCnt +
                ", WIFI_Band='" + WIFI_Band + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                ", sensorTime=" + sensorTime +
                ", mainBrushTime=" + mainBrushTime +
                ", sideBrushTime=" + sideBrushTime +
                ", filterTime=" + filterTime +
                ", runTimes=" + runTimes +
                ", appointStr='" + appointStr + '\'' +
                ", mop=" + mop +
                ", hasUpdateVol=" + hasUpdateVol +
                ", hasUpdateLed=" + hasUpdateLed +
                ", hasUpdateWind=" + hasUpdateWind +
                ", hasUpdateWater=" + hasUpdateWater +
                ", PathType=" + PathType +
                ", uvMode=" + uvMode +
                ", robotFault=" + robotFault +
                ", robotWarnMsg=" + robotWarnMsg +
                ", breakClean=" + breakClean +
                ", sweepMopMode=" + sweepMopMode +
                ", UseAutoAreaValue=" + UseAutoAreaValue +
                ", carpetBoost=" + carpetBoost +
                ", doNotDisturb=" + doNotDisturb +
                ", MultiMapsInfo='" + MultiMapsInfo + '\'' +
                ", MultiMapData0='" + MultiMapData0 + '\'' +
                ", MultiMapData1='" + MultiMapData1 + '\'' +
                ", MultiMapData2='" + MultiMapData2 + '\'' +
                ", devId='" + devId + '\'' +
                ", ldObstacleList='" + ldObstacleList + '\'' +
                ", cameraSwitch=" + cameraSwitch +
                ", aiObstacleSwitch=" + aiObstacleSwitch +
                ", aiSceneSwitch=" + aiSceneSwitch +
                ", aiFloorSwitch=" + aiFloorSwitch +
                ", lightSwitch=" + lightSwitch +
                ", micSwitch=" + micSwitch +
                ", speakerSwitch=" + speakerSwitch +
                ", devUpdateSwitch=" + devUpdateSwitch +
                ", currentVoiceId=" + currentVoiceId +
                ", BaseStationSn='" + BaseStationSn + '\'' +
                ", BaseStationVersion='" + BaseStationVersion + '\'' +
                ", BaseStationLocalVersion='" + BaseStationLocalVersion + '\'' +
                '}';
    }

    public int getEdgeClean() {
        return edgeClean;
    }

    public void setEdgeClean(int edgeClean) {
        this.edgeClean = edgeClean;
    }

    public int getCleanCount() {
        return cleanCount;
    }

    public void setCleanCount(int cleanCount) {
        this.cleanCount = cleanCount;
    }

    public String getRobotKey() {
        return robotKey;
    }

    public void setRobotKey(String robotKey) {
        this.robotKey = robotKey;
    }

    public int getMapRotateDegree() {
        return mapRotateDegree;
    }

    public void setMapRotateDegree(int mapRotateDegree) {
        this.mapRotateDegree = mapRotateDegree;
    }
}