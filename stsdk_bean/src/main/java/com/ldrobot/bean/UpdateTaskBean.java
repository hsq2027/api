package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/29 19:42
 * @Description: java类作用描述
 */
public class UpdateTaskBean {
    private int ExeResult;
    private long TaskId;
    private String code;

    public int getExeResult() {
        return ExeResult;
    }

    public void setExeResult(int exeResult) {
        ExeResult = exeResult;
    }

    public long getTaskId() {
        return TaskId;
    }

    public void setTaskId(long taskId) {
        TaskId = taskId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}