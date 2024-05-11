package com.ldrobot.bean.interfaces;

import com.ldrobot.bean.LDSweepMap;

/**
 * @Author: hsq
 * @CreateTime: 2022/5/13 10:38
 * @Description: java类作用描述
 */
public interface InitDeviceListener {
    /**
     * 初始化地图成功回调
     *
     * @param ldSweepMap
     */
    void onSweepMapInitSuccess(LDSweepMap ldSweepMap);

    /**
     * 初始化地图失败回调
     *
     * @param errorCode
     * @param errorMessage
     */
    void onSweepMapInitFailure(String errorCode, String errorMessage);
}