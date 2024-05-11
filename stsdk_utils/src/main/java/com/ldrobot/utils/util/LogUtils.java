package com.ldrobot.utils.util;


import android.util.Log;

import java.util.List;

public class LogUtils {
    public static boolean isDebug = true;
    public static final String TAG = "ld_robot";

    public static void sysOut(String msg) {
        if (isDebug) {
            System.out.println(msg);
        }
    }

    public static void info(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void log(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
            WriteLogUtil.getInstance().writeLog(msg + "", WriteLogUtil.TEST);
        }
    }

    /**
     * 打印数组
     *
     * @param list
     * @param <T>
     */
    public static <T> void printList(List<T> list) {
        if (isDebug) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    e("list====" + list.get(i));
                }
            }
        }
    }

}