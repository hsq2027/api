package com.ldrobot.utils.http;

/**
 * @Author: HSQ
 * @CreateTime: 2021/8/12 11:12
 * @Description: java类作用描述
 */
public abstract class HttpCallback<T> {
    public abstract void onSuccess(String identify, T response);

    public abstract void onFailure(String identify, T error);

    public void onShowProgress(String identify) {
    }

    public void onDismissProgress(String identify) {
    }

    /**
     * @param identify
     * @param progress 下载进度回调
     */
    public void onDownloadProgress(String identify, int progress) {
    }

    /**
     * token无效，登录过期回调
     */
    public void onTokenInvalid(T response) {
    }
}