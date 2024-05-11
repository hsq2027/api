package com.ldrobot.bean.interfaces;

import com.ldrobot.bean.SocketResponse;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/22 15:51
 * @Description: java类作用描述
 */
public interface IDeviceListener {
    /**
     * @param socketResponse 回调数据结构体，根据infoType区分回调的数据类型，对应的常量在SocketUrl类中，具体的值的含义参考扫地机通信协议文档
     */
    void onSocketResponse(SocketResponse socketResponse);
}