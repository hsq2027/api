package com.ldrobot.utils.util;

import android.graphics.Point;

import java.math.BigDecimal;

/**
 * 几何工具
 */
public class MathUtils {
    //获取两点间直线距离
    public static int getLength(float x1, float y1, float x2, float y2) {
        return (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    /**
     * 获取线段上某个点的坐标，长度为a.x - cutRadius
     *
     * @param a         点A
     * @param b         点B
     * @param cutRadius 截断距离
     * @return 截断点
     */
    public static Point getBorderPoint(Point a, Point b, int cutRadius) {
        float radian = getRadian(a, b);
        return new Point(a.x + (int) (cutRadius * Math.cos(radian)), a.y - (int) (cutRadius * Math.sin(radian)));
    }

    //获取水平线夹角弧度
    public static float getRadian(Point a, Point b) {
        float lenA = b.x - a.x;
        float lenB = b.y - a.y;
        float lenC = (float) Math.sqrt(lenA * lenA + lenB * lenB);
        float ang = (float) Math.acos(lenA / lenC);
        ang = ang * (b.y < a.y ? 1 : -1);
        return ang;
    }

    public static float getVerticalRadian(Point a, Point b) {
        float lenA = b.x - a.x;
        float lenB = b.y - a.y;
        float lenC = (float) Math.sqrt(lenA * lenA + lenB * lenB);
        float ang = (float) Math.asin(lenA / lenC);
        if (b.y > a.y && b.x > a.x) {
            ang = (float) (Math.PI - ang);
        } else if (b.y > a.y && b.x < a.x) {
            ang += (Math.PI + 2 * Math.abs(ang));
        } else if (b.y < a.y && b.x < a.x) {
            ang += Math.PI * 2;
        }
        return ang;
    }

    /**
     * 点到直线的最短距离的判断 点（x0,y0） 到由两点组成的线段（x1,y1） ,( x2,y2 )
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x0
     * @param y0
     * @return
     */
    public static double pointToLine(int x1, int y1, int x2, int y2, int x0, int y0) {
        double space = 0;
        double a, b, c;
        a = lineSpace(x1, y1, x2, y2);// 线段的长度
        b = lineSpace(x1, y1, x0, y0);// (x1,y1)到点的距离
        c = lineSpace(x2, y2, x0, y0);// (x2,y2)到点的距离
        if (c <= 0.000001 || b <= 0.000001) {
            space = 0;
            return space;
        }
        if (a <= 0.000001) {
            space = b;
            return space;
        }
        if (c * c >= a * a + b * b) {
            space = b;
            return space;
        }
        if (b * b >= a * a + c * c) {
            space = c;
            return space;
        }
        double p = (a + b + c) / 2;// 半周长
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// 海伦公式求面积
        space = 2 * s / a;// 返回点到线的距离（利用三角形面积公式求高）
        return space;
    }

    /**
     * 计算两点之间的距离
     */
    private static double lineSpace(int x1, int y1, int x2, int y2) {
        double lineLength = 0;
        lineLength = Math.sqrt(Double.valueOf((x1 - x2) * 1f * (x1 - x2)) + Double.valueOf((y1 - y2) * 1f * (y1 - y2)));
        return lineLength;
    }

    /**
     * 判断点是否在圆内
     *
     * @param point
     * @param center
     * @param r
     * @return true 内  false 外
     */
    public static boolean pointInsideCircle(Point point, Point center, int r) {
        boolean flag = true;
        if (r == 0) {
            flag = false;
            return flag;
        }
        int dx = center.x - point.x;
        int dy = center.y - point.y;
        flag = (dx * dx + dy * dy <= r * r);
        return flag;
    }

    public static int parseInt(String value) {
        return parseInt(value, 0);
    }

    public static int parseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("parseInt error:" + e);
        }
        return defaultValue;
    }

    public static float parseFloat(String value) {
        return parseFloat(value, 0);
    }

    public static float parseFloat(String value, float defaultValue) {
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("parseFloat error:" + e);
        }
        return defaultValue;
    }

    public static long parseLong(String value) {
        return parseLong(value, 0);
    }

    public static long parseLong(String value, int defaultValue) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("parseLong error:" + e);
        }
        return defaultValue;
    }

    /**
     * 保留 {@param newScale} 位小数
     *
     * @param value
     * @param newScale 保留的小数位数
     * @return
     */
    public static float decimal(float value, int newScale) {
        try {
            return BigDecimal.valueOf(value).setScale(newScale, BigDecimal.ROUND_HALF_UP).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("decimal error:" + e);
        }
        return 0;
    }

}