package com.ldrobot.utils.util;

import org.greenrobot.eventbus.EventBus;

/**
 * @Author: hsq
 * @CreateTime: 2022/3/31 20:07
 * @Description: java类作用描述
 */
public class EventBusUtil {
    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unRegister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void postSticky(Object event) {
        EventBus.getDefault().postSticky(event);
    }
}