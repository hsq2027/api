package com.ldrobot.bean.video;

/**
 * @Author: hsq
 * @CreateTime: 2022/6/14 10:14
 * @Description: java类作用描述
 */
public class MyPlayerException extends Exception {
    public static final int SOURCE_ERROR = 6;
    public static final int RENDER_ERROR = 7;
    public static final int UNEXPECTED_ERROR = 8;
    public static final int SUB_CODE_RENDER_DECODE_ERROR = 1000;
    public static final int SUB_CODE_SOURCE_STREAM_CONNECT_ERROR = 1005;
    public static final int SUB_CODE_SOURCE_INVALID_DECRYPTE_KEY = 1006;
    public static final int SUB_CODE_SOURCE_INVALID_RTMP_URL = 1007;
    public static final int SUB_CODE_SOURCE_PARAMETER_ERROR = 1008;
    public static final int SUB_CODE_SOURCE_QUERY_URL_FAILED = 1009;
    public static final int SUB_CODE_UNEXPECTED_PULL_STREAM_ERROR = 1100;
    public static final int SUB_CODE_SOURCE_INVALID_HLS_URL = 1101;
    public static final int LIVE_INTERCOM_EXCEPTION = 9;
    private int code;
    private int subCode;

    public MyPlayerException(int var1, String var2) {
        super(var2);
        this.code = var1;
    }

    public MyPlayerException(int var1, int var2, String var3) {
        super(var3);
        this.code = var1;
        this.subCode = var2;
    }

    public int getCode() {
        return this.code;
    }

    public int getSubCode() {
        return this.subCode;
    }

}