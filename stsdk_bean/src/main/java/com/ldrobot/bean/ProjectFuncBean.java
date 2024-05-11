package com.ldrobot.bean;

/**
 * 创建时间：2020/5/9  15:14
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class ProjectFuncBean {
    private String messageCategory = "1,2";//显示的消息模块， 1 设备消息 2 共享消息  3系统推送
    private String apSsidPrefix;//默认adh_ 扫地机热点，多个用逗号隔开
    private int projectGuide;//默认无  产品指南模块  0则不显示 该栏目
    private String shoppingMallLink;//默认无  商城链接  不设置则不显示 该栏目
    private String websiteLink;//默认无  官网链接  不设置则不显示 该栏目
    private String debugUserId;
    private int simulators;//是否显示虚拟设备，默认无

    public int getSimulators() {
        return simulators;
    }

    public void setSimulators(int simulators) {
        this.simulators = simulators;
    }

    public String getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(String messageCategory) {
        this.messageCategory = messageCategory;
    }

    public String getApSsidPrefix() {
        return apSsidPrefix;
    }

    public void setApSsidPrefix(String apSsidPrefix) {
        this.apSsidPrefix = apSsidPrefix;
    }

    public String getShoppingMallLink() {
        return shoppingMallLink;
    }

    public void setShoppingMallLink(String shoppingMallLink) {
        this.shoppingMallLink = shoppingMallLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public int getProjectGuide() {
        return projectGuide;
    }

    public void setProjectGuide(int projectGuide) {
        this.projectGuide = projectGuide;
    }

    public String getDebugUserId() {
        return debugUserId;
    }

    public void setDebugUserId(String debugUserId) {
        this.debugUserId = debugUserId;
    }
}