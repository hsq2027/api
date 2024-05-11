package com.ldrobot.bean.interfaces;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/6 11:45
 * @Description: java类作用描述
 */
public interface InitTokenListener {
    void onSuccess();

    void onFailure(String errorCode, String errorMsg);

    void onNeedLogin();
}