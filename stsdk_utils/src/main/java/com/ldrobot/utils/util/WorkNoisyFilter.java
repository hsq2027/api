package com.ldrobot.utils.util;

import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * @Author: hsq
 * @CreateTime: 2022/6/7 18:03
 * @Description: 预约数据解析兼容旧版本风力
 */
public class WorkNoisyFilter implements ValueFilter {
    @Override
    public Object process(Object object, String name, Object value) {
        if ("workNoisy".equals(name)) {
            if ("quiet".equals(value)) {
                return 1;
            } else if ("auto".equals(value)) {
                return 2;
            } else if ("strong".equals(value)) {
                return 3;
            } else if ("max".equals(value)) {
                return 4;
            }
        }
        return value;
    }
}