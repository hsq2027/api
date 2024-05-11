package com.ldrobot.utils.util.socketudpconnect;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.google.gson.Gson;
import com.ldrobot.utils.util.LogUtils;
import com.ldrobot.utils.util.MyJson;
import com.ldrobot.utils.util.WriteLogUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SocketUdpClient {
    public boolean isStop = false;//指示监听线程是否终止
    private WifiManager.MulticastLock lock;
    private ExecutorService mExecutorService;
    private DatagramSocket mDatagramSocket;

    private boolean isTimeOut = false;

    private Gson mGson;

    public SocketUdpClient(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        lock = wifiManager.createMulticastLock("test wifi");
        mGson = new Gson();
    }

    /**
     * 开始监听
     */
    public void startListen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop) {
                    try {
                        if (mDatagramSocket == null)
                            mDatagramSocket = new DatagramSocket();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                    byte[] recbuf = new byte[2000];
                    DatagramPacket response = new DatagramPacket(recbuf, recbuf.length);
                    lock.acquire();
                    try {
                        if (mDatagramSocket != null) {
                            mDatagramSocket.receive(response);
                        }
                        isTimeOut = false;
                        parsePackage(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    lock.release();
                    LogUtils.e("Server.IP：" + response.getAddress() + "\n");
                    LogUtils.e("Server.Message received：" + new String(response.getData()) + "\n");
                }
            }
        }).start();
    }

    private void parsePackage(DatagramPacket packet) {
        try {
            int start;
            int position;
            String result = new String(packet.getData());
            if ((position = result.indexOf("}")) >= 0 && (start = result.indexOf('{')) >= 0 && start < position) {
                SocketUdpResponse response = MyJson.parseObject(result.substring(start, position + 1), SocketUdpResponse.class);
                response.setTimeOut(false);
                EventBus.getDefault().post(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        send(message, true);
    }

    public void send(String message, boolean identifyTimeOut) {
        String ip = "192.168.78.1";
        int port = 7913;
        send(message, identifyTimeOut, ip, port);
    }

    public void send(final String message, final boolean identifyTimeOut, String ip, int port) {
        if (mExecutorService == null) {
            mExecutorService = Executors.newCachedThreadPool();
        }
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                int server_port = port;
                LogUtils.e("UDP Demo", "UDP发送数据:" + message);
                WriteLogUtil.getInstance().writeLog(message, WriteLogUtil.UDP_DATA);
                try {
                    if (mDatagramSocket == null)
                        mDatagramSocket = new DatagramSocket();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                InetAddress local = null;
                try {
                    local = InetAddress.getByName(ip);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                byte[] messageByte = message.getBytes();
                int msg_length = messageByte.length;
                DatagramPacket request = new DatagramPacket(messageByte, msg_length, local, server_port);
                try {
                    if (mDatagramSocket != null) {
                        try {
                            mDatagramSocket.send(request);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    isTimeOut = true;
                    int time = 120;

                    while (isTimeOut) {
                        Thread.sleep(1000);
                        time--;
                        /************************************Begin ***************************************/
                        if (time % 3 == 0) {
                            //重发
                            if (mDatagramSocket != null) {
                                try {
                                    mDatagramSocket.send(request);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        /************************************end***************************************/
                        if (time <= 0) {
                            break;
                        }
                    }
                    if (isTimeOut && identifyTimeOut) {
                        SocketUdpResponse response = new SocketUdpResponse();
                        response.setTimeOut(true);
                        EventBus.getDefault().post(response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public void send(final String message, String ip, int port) {
        if (mExecutorService == null) {
            mExecutorService = Executors.newCachedThreadPool();
        }
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                int server_port = port;
                LogUtils.e("UDP Demo", "UDP发送数据:" + "ip===" + ip
                        + "port==" + port + message);
                try {
                    if (mDatagramSocket == null) {
                        mDatagramSocket = new DatagramSocket();
                    }
                    InetAddress local = null;
                    local = InetAddress.getByName(ip);
                    byte[] messageByte = message.getBytes();
                    int msg_length = messageByte.length;
                    DatagramPacket request = new DatagramPacket(messageByte, msg_length, local,
                            server_port);
                    mDatagramSocket.send(request);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void disconnect() {
        isStop = true;
        isTimeOut = false;
        if (mDatagramSocket != null) {
            mDatagramSocket.close();
        }
        mDatagramSocket = null;
    }
}