package com.ldrobot.bean;

/**
 * 创建时间：2019/12/16  18:12
 * 作者：5#
 * 描述："time":1576489775028,
 * "value":{
 * "Ip":"192.168.17.175",
 * "Port":9504,
 * "Protocol":"udp"
 * }
 * 注意：
 */
public class RControlBean {


    /**
     * Ip : 192.168.17.175
     * Port : 9504
     * Protocol : udp
     */

    private String Ip;
    private int Port;
    private String Protocol;

    public String getIp() {
        return Ip;
    }

    public void setIp(String Ip) {
        this.Ip = Ip;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public String getProtocol() {
        return Protocol;
    }

    public void setProtocol(String Protocol) {
        this.Protocol = Protocol;
    }

    @Override
    public String toString() {
        return "RControlBean{" +
                "Ip='" + Ip + '\'' +
                ", Port=" + Port +
                ", Protocol='" + Protocol + '\'' +
                '}';
    }
}