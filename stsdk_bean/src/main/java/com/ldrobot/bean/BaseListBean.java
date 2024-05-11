package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/1 19:45
 * @Description: java类作用描述
 */
public class BaseListBean<T> {
    private boolean noMore;
    private List<T> dataList;

    public boolean isNoMore() {
        return noMore;
    }

    public void setNoMore(boolean noMore) {
        this.noMore = noMore;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}