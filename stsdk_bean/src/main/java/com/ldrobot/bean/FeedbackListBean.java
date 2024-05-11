package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: HSQ
 * @CreateTime: 2021/4/2 10:45
 * @Description: java类作用描述
 */
public class FeedbackListBean {
    /**
     * total : 2
     * data : [{"gmtModified":1617331429000,"appVersion":"V1.6.3","gmtLastFeedback":1617268652000,"type":1,"productKey":"a2e3nbNt4Kz","content":"1Router model (optional)2Product model (optional)4","uid":"5047opc3f5e72c4cccd4ae9a7959400fca936373","gmtLastReply":1617331429000,"mobileModel":"MIX 2","contact":"3","id":11671,"feedbackStatus":0,"mobileSystem":"Android9","isolationId":"a203jvmvfkpGgaB8","gmtCreate":1617268652000,"iotId":"HpFG7NeTOkNzxXveXO97000000","lastFeedback":"1Router model (optional)2Product model (optional)4","lastReply":"121313","tenantId":"8F5DA61EFE2D47C7BB8E62289C041323","topic":"","replyStatus":0,"devicename":"RV507W2007002003"},{"gmtModified":1617331450000,"appVersion":"V1.6.2","gmtLastFeedback":1617070157000,"type":1,"productKey":"a2e3nbNt4Kz","content":"testRouter model (optional)360Product model (optional)rv50","uid":"5047opc3f5e72c4cccd4ae9a7959400fca936373","gmtLastReply":1617331450000,"mobileModel":"JSC-AN00","contact":"wf@ldrobot.com","id":11622,"feedbackStatus":0,"mobileSystem":"Android10","isolationId":"a203jvmvfkpGgaB8","gmtCreate":1616750783000,"iotId":"1c9fT48VzLWmYyAhAQqe000102","lastFeedback":"123Router model (optional)360Product model (optional)rv50","lastReply":"11111","tenantId":"8F5DA61EFE2D47C7BB8E62289C041323","topic":"","replyStatus":0,"devicename":""}]
     * pageSize : 10
     */

    private int total;
    private int pageSize;
    private List<FeedbackDataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<FeedbackDataBean> getData() {
        return data;
    }

    public void setData(List<FeedbackDataBean> data) {
        this.data = data;
    }


}