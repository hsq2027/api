package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2023/2/17 9:54
 * @Description: 类的作用描述
 */
public class LogFileBean {

    private boolean select;
    private String fileName;
    private String filePath;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}