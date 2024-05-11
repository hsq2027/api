package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/29 19:46
 * @Description: java类作用描述
 */
public class CurrentVoicePackageBean {
    private String State;
    private long TaskId;
    private String Name;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public long getTaskId() {
        return TaskId;
    }

    public void setTaskId(long taskId) {
        TaskId = taskId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}