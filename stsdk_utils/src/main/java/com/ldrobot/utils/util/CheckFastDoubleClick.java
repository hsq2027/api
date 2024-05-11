package com.ldrobot.utils.util;

import android.os.SystemClock;

/**
 * Created by Emiya on 16/12/26.
 */

public class CheckFastDoubleClick {
    //  防止按钮快速点击造成重复事件
    private static long lastClickTime;
    private static long lastClickTime1;
    private static long lastClickTime2;
    private static long lastClickTime3;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static boolean isFastDoubleClick1() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime1;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime1 = time;
        return false;
    }

    public static boolean isFastDoubleClick2() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime2;
        if (0 < timeD && timeD < 1500) {
            return true;
        }
        lastClickTime2 = time;
        return false;
    }

    public static boolean isFastBackClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime3;
        if (0 < timeD && timeD < 2000) {
            return true;
        }
        lastClickTime3 = time;
        return false;
    }

    // 需要点击几次 就设置几
    private static long[] mHits = null;

    /**
     * 连击判断
     *
     * @param count 连击次数设置
     * @param time  多长时间内完成点击
     * @return
     */
    public static boolean isMultipleClick(int count, int time) {
        if (mHits == null) {
            mHits = new long[count];
        }
        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);//把从第二位至最后一位之间的数字复制到第一位至倒数第一位
        mHits[mHits.length - 1] = SystemClock.uptimeMillis();//记录一个时间
        if (SystemClock.uptimeMillis() - mHits[0] <= time) {//是否在规定时间内完成连击
            mHits = null;    //这里说明一下，我们在进来以后需要还原状态，否则如果点击过快，第六次，第七次 都会不断进来触发该效果。重新开始计数即可
            return true;
        }
        return false;
    }

}