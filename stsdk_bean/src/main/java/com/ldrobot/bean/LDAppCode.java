package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2023/8/9 14:26
 * @Description: 类的作用描述
 */
public class LDAppCode {
    public static final int LD_APP_KEY_SUCCESS = 0;// appKey检验通过
    public static final int LD_APP_KEY_EXPIRE = -1;// appKey过期
    public static final int LD_BUNDLE_ID_MISMATCH = -2;// bundledID 不匹配
    public static final int LD_APP_KEY_FAILED = -3;// appKey不合法
    public static final int LD_MODEL_FILE_INIT_FAILED = -4;// 模型文件初始化失败
    public static final int LD_ROBOT_KEY_EXPIRE = -4; // robotKey过期
    public static final int LD_ROBOT_KEY_FAILED = -5; // robotKey不合法
    public static final int LD_ROBOT_KEY_MISMATCH = -6; // robotKey不匹配
}