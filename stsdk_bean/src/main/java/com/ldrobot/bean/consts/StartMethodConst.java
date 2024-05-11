package com.ldrobot.bean.consts;

/**
 * @Author: hsq
 * @CreateTime: 2022/10/21 14:45
 * @Description: 代表该记录的启动方式
 */
public class StartMethodConst {
    public static final String PHYSICAL_REMOTE = "0";//物理遥控器启动
    public static final String CLOUD_SEND = "1";//APP启动（云端发送指令）
    public static final String APPOINTMENT = "2";//预约任务启动
    public static final String DEVICE_BUTTON = "3";//设备按键启动
}