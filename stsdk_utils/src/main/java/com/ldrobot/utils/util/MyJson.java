package com.ldrobot.utils.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/21 14:16
 * @Description: java类作用描述
 */
public class MyJson<T> {

    private static Gson gson;

    public static String toJSONString(Object object) {
//        return JSON.toJSONString(object);
        if (gson == null) {
            gson = new Gson();
        }
        return gson.toJson(object);
    }

    public static String toJSONString(Object object, SerializeFilter filter, SerializerFeature... features) {
        return JSON.toJSONString(object, filter, features);
    }

    public static Object toJSON(Object object) {
        return JSON.toJSON(object);
    }

    public static JSONObject parseObject(String text) {
        return JSON.parseObject(text);
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
//        return new Gson().fromJson(text, clazz);
    }

    public static <T> T parseObject(String text, TypeReference<T> type) {
        return JSON.parseObject(text, type);
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
//        return new Gson().fromJson(text, new TypeToken<ArrayList<T>>() {
//        }.getType());
    }

    public static <T> List<T> parseGsonArray(String text, Class<T> clazz) {
        return new Gson().fromJson(text, new TypeToken<ArrayList<T>>() {
        }.getType());
    }

    public static <T> T parseObjectByGson(String text, Class<T> clazz) {
        if (gson == null) {
            gson = new Gson();
        }
        return gson.fromJson(text, clazz);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        if (gson == null) {
            gson = new Gson();
        }
        return gson.fromJson(json, typeOfT);
    }

}