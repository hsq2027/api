package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2023/8/9 14:20
 * @Description: 类的作用描述
 */
public class LDCode {
    public static final int LD_SEG_RE_SUCCESS = 1; // 分区成功
    public static final int LD_SEG_RE_SUCCESS_ZERO = 0; // 分区成功
    public static final int LD_SEG_RE_FAILED_ILLEGAL = -1;// 分区失败，地图非法
    public static final int LD_SEG_RE_FAILED_SMALL = -2;// 分区失败，地图过小
    public static final int LD_SEG_RE_FAILED_NOT_EXIST = -3;// 分区失败,模型不在
    public static final int LD_SEG_RE_FAILED_TG_INIT = -4;//分区失败，初始化失败
    public static final int LD_SEG_RE_FAILED_GRAPH = -5;//分区失败，建图失败
    public static final int LD_SEG_RE_FAILED_OPERATE = -6;// 分区失败,tensor操作失败
    public static final int LD_SEG_RE_FAILED_PRERUN = -7;// 分区失败，预运算失败
    public static final int LD_SEG_RE_FAILED_RUN = -8;// 分区失败，推理失败
    public static final int LD_MEMORY_FAILED = -9; // 内存不足
    public static final int LD_MAP_DATA_ERROR = -10; // 传入的地图数据有误
    public static final int LD_MAP_PRESS_FAILED = -11; // 压缩失败
    public static final int LD_MAP_ENCODE_FAILED = -12; // 编码失败
    public static final int LD_CHANGE_MAP_SUCCESS = 100; // 地图转换格式成功
}