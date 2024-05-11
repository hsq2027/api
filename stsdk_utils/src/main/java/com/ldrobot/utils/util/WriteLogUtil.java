package com.ldrobot.utils.util;


import android.content.Context;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Emiya on 2018/5/25.
 */

public class WriteLogUtil {

    public static final String LOG_FILE_PATH = "/Log";
    private static final AtomicReference<WriteLogUtil> INSTANCE = new AtomicReference<>();
    private File dir;
    private File androidFile;
    private File aliFile;
    private Context context;


    public static boolean isDebug = true;//日志开关  上线false
//    public boolean isDebug = false;//日志开关  上线false

    private WriteLogUtil() {
        initDir();
    }

    private boolean initDir() {
        if (context == null) {
            return false;
        }
        dir = new File(context.getExternalCacheDir().getAbsolutePath() + LOG_FILE_PATH);
        // 判断文件夹是否存在，不存在则创建
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return false;
    }

    public static WriteLogUtil getInstance() {
        WriteLogUtil singleton = INSTANCE.get();
        if (singleton == null) {
            singleton = new WriteLogUtil();
            if (!INSTANCE.compareAndSet(null, singleton)) {
                singleton = INSTANCE.get();
            }
        }
        return singleton;
    }

    public static final int CREAT_TYPE = 1;
    public static final int SEND_TYPE = 2;
    public static final int READ_TYPE = 3;
    public static final int SHOW_TYPE = 4;
    public static final int MAP_DATA = 5;
    public static final int MAP_LENGTH = 6;
    public static final int ROBOT_LOCATION = 7;
    public static final int MAP_TRANSLATION = 8;
    public static final int UDP_DATA = 9;
    public static final int ALI_RECIVE = 10;
    public static final int ALI_RECIVE_HTTP = 11;
    public static final int TEST = 12;

    public void writeLogForObject(Object object, int type) {
        if (!isDebug)
            return;
        writeLog(new Gson().toJson(object), type);
    }

    /**
     * 开启子线程去写日志
     *
     * @param string
     * @param type
     */
    public void writeLog(final String string, final int type) {
        if (!isDebug)
            return;
        if (dir == null) {
            initDir();
        }
        if (dir != null && !dir.exists()) {
            boolean mkdirs = dir.mkdirs();
            if (!mkdirs) {
                return;
            }
        }
        if (androidFile == null)
            androidFile = makeFile("/android_" + TimestampTool.getCurrentTimeString("yyyy-MM-dd") + ".txt");
        if (androidFile == null)
            return;

        startWriteLog(string, type);
    }

    private void startWriteLog(final String string, final int type) {
        new Thread(() -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TimestampTool.getCurrentTimeString("yyyy-MM-dd HH:mm:ss:SSS"));
            switch (type) {
                case CREAT_TYPE:
                    stringBuilder.append("(生成指令): ");
                    break;
                case SEND_TYPE:
                    stringBuilder.append("(发送指令): ");
                    break;
                case READ_TYPE:
                    stringBuilder.append("(接收指令): ");
                    break;
                case SHOW_TYPE:
                    stringBuilder.append("(解密指令): ");
                    break;
                case MAP_DATA:
                    stringBuilder.append("(地图数据): ");
                    break;
                case MAP_LENGTH:
                    stringBuilder.append("(地图数据长度): ");
                    break;
                case ROBOT_LOCATION:
                    stringBuilder.append("(扫地机的位置): ");
                    break;
                case MAP_TRANSLATION:
                    stringBuilder.append("(地图平移信息): ");
                    break;
                case UDP_DATA:
                    stringBuilder.append("(UDP数据包): ");
                    break;
                case ALI_RECIVE:
                    stringBuilder.append("(ali数据包): ");
                    break;
                case ALI_RECIVE_HTTP:
                    stringBuilder.append("(ali Https包): ");
                    break;
                case TEST:
                    stringBuilder.append("测试日志：");
                    break;
                default:
                    stringBuilder.append("default====");
                    break;
            }
            stringBuilder.append(string).append("\n");

            try {
                RandomAccessFile raf = new RandomAccessFile(androidFile, "rwd");
                raf.seek(androidFile.length());
                raf.write(stringBuilder.toString().getBytes());
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 阿里SDK日志
     *
     * @param log
     */
    public void writeAliLog(String log) {
        if (!isDebug)
            return;
        if (dir == null) {
            initDir();
        }
        if (dir != null && !dir.exists()) {
            boolean mkdirs = dir.mkdirs();
//            Logutils.e(mkdirs + "");
            if (!mkdirs) {
                return;
            }
        }
        if (aliFile == null)
            aliFile = makeFile("/android_ali_" + TimestampTool.getCurrentTimeString("yyyy-MM-dd") + ".txt");
        if (aliFile == null)
            return;

        Runnable runnable = () -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TimestampTool.getCurrentTimeString("yyyy-MM-dd HH:mm:ss:SSS"));
            stringBuilder.append(log).append("\n");
            try {
                RandomAccessFile raf = new RandomAccessFile(aliFile, "rwd");
                raf.seek(aliFile.length());
                raf.write(stringBuilder.toString().getBytes());
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        ExecutorUtil.getFixInstance().execute(runnable);
    }


    //生成文件
    private File makeFile(String fileName) {
        File file = null;
        try {
            file = new File(dir + fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                LogUtils.e("newFile===" + newFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public void testWrite(String msg) {
        writeLog(msg + "", TEST);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }
}