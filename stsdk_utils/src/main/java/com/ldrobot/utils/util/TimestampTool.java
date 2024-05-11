package com.ldrobot.utils.util;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间与时间戳转换工具
 */
public class TimestampTool {

    public final static String PATTERN_HOUR = "HH";
    public final static String PATTERN_MIN = "mm";
    public final static String PATTERN_DATE_TIME = "yyyy-MM-dd_HH-mm-ss";
    public final static String PATTERN_DATE_TIME1 = "yyyyMMddHHmmss";
    public final static String PATTERN_DATE_TIME2 = "yyyy-MM-dd HH-mm-ss SSS";

    public static String TransTimeZone(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        Date date = sdf.parse(time);
        sdf.setTimeZone(TimeZone.getDefault());

        return sdf.format(date);
    }

    public static String getTimeFromDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        sdf.setTimeZone(TimeZone.getDefault());

        return sdf.format(date);
    }

    public static String second2Time(int seconds) {
        StringBuffer buffer = new StringBuffer();
        if (seconds / 3600 > 0) {
            buffer.append((seconds / 3600) + "小时");
        }
        if (seconds / 60 > 0) {
            buffer.append((seconds % 3600) / 60 + "分钟");
        }
        if (seconds / 60 == 0) {
            buffer.append(seconds % 60 + "秒");
        }
        return buffer.toString();
    }


    public static String DateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getDefault());
        String str = sdf.format(date);
        return str;
    }

    public static String Date2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getDefault());
        String str = sdf.format(date);
        return str;
    }

    /**
     * 输入一个时间，获取该时间的时间戳
     *
     * @param @param  dateString
     * @param @return
     */
    public static long string2Timestamp(String dateString) {
        String format = "yyyy-MM-dd HH:mm:ss";
        return string2Timestamp(dateString, format);
    }

    public static long string2Timestamp(String dateString, String format) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat(format).parse(dateString);
            long temp = date1.getTime();// JAVA的时间戳长度是13位
            return temp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //把字符串转为日期
    public static Date string2Date(String strDate) throws Exception {
        Date df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
        return df;
    }


    public static long string2Timestamp2(String dateString) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                    .parse(dateString);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (date1 != null) {
            long temp = date1.getTime();// JAVA的时间戳长度是13位
            return temp;
        }
        return 0;
    }

    /**
     * 获取系统当前时间
     *
     * @throws ParseException
     * @time 2014-4-24 下午5:16:01
     */
    public static long getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        df.setTimeZone(TimeZone.getDefault());
        return string2Timestamp(df.format(new Date()));// new Date()为获取当前系统时间
    }


    public static String getCurrentTimeServeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        df.setTimeZone(TimeZone.getDefault());
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    public static String getCurrentTimeString() {
        String format = "yyyy-MM-dd HH:mm";
        return getCurrentTimeString(format);
    }

    public static String getCurrentTimeString(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);// 设置日期格式
        df.setTimeZone(TimeZone.getDefault());
        return df.format(new Date());  // new Date()为获取当前系统时间
    }

    public static String getCurrentTimeString2() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
        df.setTimeZone(TimeZone.getDefault());
        return df.format(new Date());  // new Date()为获取当前系统时间
    }

    public static String getCurrentTimeString3() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");// 设置日期格式
        df.setTimeZone(TimeZone.getDefault());
        return df.format(new Date());  // new Date()为获取当前系统时间
    }

    //比较两个时间戳的间隔是否大于n分钟
    public static boolean CompareTimestamp(long Timestampone, long Timestamptwo, int n) {
        if (Math.abs(Timestampone - Timestamptwo) / (1000 * 60) >= n)
            return true;
        else
            return false;
    }

    /**
     * 获取系统时间戳
     */
    public static String getTimestamp() {
        DecimalFormat mDecimalFormat = new DecimalFormat("#.######");
        String timestamp = mDecimalFormat
                .format(System.currentTimeMillis() / 1000.0);
        return timestamp;
    }

    /**
     * 服务器时间转本地时间
     */
    public static String transformTimeYear(String time) {
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format1.setTimeZone(TimeZone.getDefault());
        try {
            time = format1.format(format.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
        return time;
    }

    public static String transformTimeMonth(String time) {
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format1.setTimeZone(TimeZone.getDefault());
        try {
            time = format1.format(format.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return time;
        }
        return time;
    }

    // 时间yyyy-MM-dd HH:mm 转时间戳（秒）
    public static long StringToTimestamp(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }

        return date.getTime() / 1000;
    }


    public static CharSequence getTime(String string, String string2) {

        String a = string.replace("T", " ").replace("-", ".").substring(0, 19);
        String b = string2.replace("T", " ").replace("-", ".").substring(0, 19);

        a = a.substring(0, 10);
        b = b.substring(0, 10);
        return a + "-" + b;
    }

    public static String transformTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format1.setTimeZone(TimeZone.getDefault());
        try {
            time = format1.format(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
            return time;
        }
        return time;
    }

    public static String transformTimeNOTimez(String time) {
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        format1.setTimeZone(TimeZone.getDefault());
        try {
            time = format1.format(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
            return time;
        }
        return time;
    }

    public static int getTimeZoneNumber() {
        TimeZone aDefault = TimeZone.getDefault();
        if (aDefault.inDaylightTime(new Date())) {
            return (aDefault.getRawOffset() + aDefault.getDSTSavings()) / (3600 * 1000);
        } else {
            return (aDefault.getRawOffset()) / (3600 * 1000);
        }
    }


    public static int getTimeZoneSec() {
        TimeZone aDefault = TimeZone.getDefault();
        if (aDefault.inDaylightTime(new Date())) {
            return (aDefault.getRawOffset() + aDefault.getDSTSavings()) / 1000;
        } else {
            return (aDefault.getRawOffset()) / 1000;
        }
    }

    /**
     * 将GMT时间戳转换为系统默认时区的时间戳
     *
     * @return 系统默认时区的时间戳
     */
    public static long getCurrentTimeMillisZone() {
        return System.currentTimeMillis() + TimeZone.getDefault().getRawOffset();
    }

    /**
     * 根据时区获取时间戳偏移量
     */
    public static int getTimeMillisZoneOffset(String zone) {
        int offset;
        if (zone != null) {
            try {
                TimeZone timeZone = TimeZone.getTimeZone("GMT+" + zone);
                offset = timeZone.getRawOffset() / 1000;
            } catch (Exception e) {
                offset = TimeZone.getDefault().getRawOffset() / 1000;
            }
        } else {
            offset = TimeZone.getDefault().getRawOffset() / 1000;
        }
        return offset;
    }

    /**
     * @param time
     * @param timeZoneSec 上一次上传时区与0时区的差，单位s
     * @return
     */
    public static long zone2Long(int time, String timeZoneSec) {
        //2个时区的差
        int offset = (int) (Double.valueOf(TimeZone.getDefault().getRawOffset() / 1000f) - Double.parseDouble(timeZoneSec));
        return (time + offset + 24 * 3600) % (24 * 3600);
    }

    public static boolean isSampleZone(String orignalZone) {
        if (TextUtils.isEmpty(orignalZone)) {
            return false;
        }
        int indexOf = orignalZone.indexOf(".");
        String substring = "";
        if (indexOf > 0) {
            substring = orignalZone.substring(0, indexOf);
        }
        return substring.equals(TimestampTool.getTimeZoneNumber() + "");
    }

    public static String getDate(long timestamp) {
        return getDate(timestamp, null);
    }

    public static String getDate(long timestamp, String pattern) {
        String date = "";
        try {
            if (pattern == null) {
                pattern = "yyyy-MM-dd HH:mm";
            }
            date = new SimpleDateFormat(pattern).format(new Date(timestamp * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * HH-mm-ss 与hh-mm-ss的区别。
     *
     * @param timestamp
     * @return
     */
    public static String getDateTime(long timestamp, int hourAll) {
        String date;
        if (hourAll == 12) {
            date = new SimpleDateFormat("hh:mm").format(new Date(timestamp * 1000));
        } else {
            date = new SimpleDateFormat("HH:mm").format(new Date(timestamp * 1000));
        }
        return date;
    }

    public static int getAllHourByString(String target) {
        String[] split = target.split(":");
        if (split.length >= 2) {
            long parseLong = Long.parseLong(split[0]);
            if (parseLong > 12) {
                return 24;
            } else {
                return 12;
            }
        }
        return 12;
    }

    public static int getTimeByString(String target) {
        int result = 0;
        try {
            String[] split = target.split(":");
            if (split.length >= 2) {
                String hourStr = split[0];
                long hour = 0;
                if (hourStr.startsWith("0")) {
                    hour = Long.parseLong(hourStr.substring(1));
                } else {
                    hour = Long.parseLong(hourStr);
                }
                String minStr = split[1];
                long min = 0;
                if (minStr.startsWith("0")) {
                    min = Long.parseLong(minStr.substring(1));
                } else {
                    min = Long.parseLong(minStr);
                }
                result = (int) (hour * 3600 + min * 60);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

        return result;
    }

    /**
     * @param time 单位是s
     * @return 输出格式   分：秒
     */
    public static String getStrByTime(int time) {
        String temp = "";
        int min = time / 60;
        int second = time % 60;
        if (min < 10 && second < 10) {
            temp = "0" + min + ":" + "0" + second;
        } else if (min < 10) {
            temp = "0" + min + ":" + second;
        } else if (second < 10) {
            temp = min + ":" + "0" + second;
        } else {
            temp = min + ":" + second;
        }
        return temp;
    }

    /**
     * @param startTime
     * @return
     */
    public static String getStrByTime2(int startTime) {
        String temp = "";
        int hourOfDay = startTime / 3600;
        int minute = (startTime / 60) % 60;
        if (hourOfDay < 10 && minute < 10) {
            temp = "0" + hourOfDay + ":" + "0" + minute;
        } else if (hourOfDay < 10) {
            temp = "0" + hourOfDay + ":" + minute;
        } else if (minute < 10) {
            temp = hourOfDay + ":" + "0" + minute;
        } else {
            temp = hourOfDay + ":" + minute;
        }
        return temp;
    }

    public static int getCurrentTimeZone(int time) {
        return time - TimeZone.getDefault().getRawOffset() / 1000;
    }

    public static int getOnceTimeOffset(int startTime, int endTime) {
        int timeNow = (int) (TimestampTool.getCurrentTimeMillisZone() / 1000.0);
        int timeMode = timeNow % 86400;
        if (startTime >= timeMode && endTime >= timeMode) {
            return timeNow - timeMode;
        } else {
            return timeNow - timeMode + 86400;
        }
    }

    /**
     * 计算时间差
     *
     * @param time
     * @return
     */
    public static int getOnceTimeOffset(int time) {
        int timeNow = (int) (TimestampTool.getCurrentTimeMillisZone() / 1000.0);
        int timeMode = timeNow % 86400; //24 *60*60  --  去掉天
        if (time >= timeMode) {
            return timeNow - timeMode;
        } else {
            return timeNow - timeMode + 86400;
        }
    }


    /**
     * 得到几天前的时间
     *
     * @param day
     * @return
     */
    public static Date getDateBefore(Date date, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    public static String timestampToDateStr(long timestamp, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm";
        }
        return new SimpleDateFormat(pattern).format(timestamp);
    }

    /**
     * @param time 当天的时间戳
     * @return
     */
    //获取当天0点的时间戳
    public static long getZeroClockTimestamp(long time) {
        long zeroTimestamp = time - (time + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000);
        return zeroTimestamp;
    }


}