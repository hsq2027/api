package com.ldrobot.utils.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.ldrobot.utils.http.HttpCallback;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.atomic.AtomicReference;

import okhttp3.ResponseBody;

/**
 * @Author: hsq
 * @CreateTime: 2022/4/15 11:34
 * @Description: java类作用描述
 */
public class FileUtil {

    private static final AtomicReference<FileUtil> INSTANCE = new AtomicReference<>();
    private File dir;
    public static final String RECENT_CONTACT_DIR = "/contact";//最近联系人保存文件夹
    public static final String RECENT_CONTACT_FILENAME = "contact_recent.txt";//最近联系人保存文件名称
    public static final String COMMON_SETTINGS = "/common_settings";//常用设置
    public static final String CLEAN_ORDER = "/clean_order";//清扫顺序
    public static final String FILE_PATH = "/file";//文件保存路径
    public static final String DIR_OBSTACLE_IMAGE = "/obstacle/image";//AI避障图片保存路径
    public static final String DIR_OBSTACLE_XML = "/obstacle/xml";//AI避障数据文件保存路径
    private File recentContactFile;

    private FileUtil() {
    }

    public static FileUtil getInstance() {
        FileUtil singleton = INSTANCE.get();
        if (singleton == null) {
            singleton = new FileUtil();
            if (!INSTANCE.compareAndSet(null, singleton)) {
                singleton = INSTANCE.get();
            }
        }
        return singleton;
    }

    private boolean initDir(Context context, String filePath) {
        if (context == null) {
            return false;
        }
        dir = new File(context.getExternalCacheDir().getAbsolutePath() + filePath);
        // 判断文件夹是否存在，不存在则创建
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return false;
    }

    public String writeStrToFile(Context context, String fileName, String filePath, String content) {
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        if (dir == null) {
            initDir(context.getApplicationContext(), filePath);
        }
        if (dir != null && !dir.exists()) {
            boolean mkdirs = dir.mkdirs();
            if (!mkdirs) {
                return null;
            }
        }
        if (recentContactFile == null)
            recentContactFile = makeFile("/" + fileName);
        if (recentContactFile == null)
            return null;
        BufferedWriter fout = null;
        try {
//            RandomAccessFile raf = new RandomAccessFile(recentContactFile, "rwd");
//            raf.seek(0);
//            raf.write(content.getBytes());
//            raf.close();

            fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(recentContactFile, false)));
            fout.write(content);
            fout.close();
            return recentContactFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    //生成文件
    private File makeFile(String fileName) {
        File file = null;
        try {
            file = new File(dir + fileName);
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                LogUtils.e("1newFile===" + newFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 加载APk
     * 先创建文件夹  在创建文件
     *
     * @param context
     * @param apkName
     * @return
     */
    public static File createFile(Context context, String apkName) {
        File file = new File(context.getExternalCacheDir().getAbsolutePath() + FILE_PATH + "/" + apkName);
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                boolean newFile = file.createNewFile();
                LogUtils.e("2newFile===" + newFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }

    public static void writeFileToSDCard(String identify, ResponseBody body, String saveDir, String fileName, HttpCallback httpCallBack) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File file = new File(saveDir, fileName);
            file.getParentFile().mkdirs();
            boolean newFile = file.createNewFile();
            LogUtils.e("3newFile===" + newFile);
            try {
                byte[] fileReader = new byte[4096];
                long fileLength = body.contentLength();
                long hadDownload = 0;
                int progress;
                inputStream = body.byteStream();
                outputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    hadDownload += read;
                    progress = Math.round(hadDownload * 1f / fileLength * 100);
                    if (httpCallBack != null) {
                        httpCallBack.onDownloadProgress(identify, progress);
                    }
                    LogUtils.e("下载进度: " + progress);
                }
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                LogUtils.e("文件下载异常1：" + e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("文件下载异常：" + e);
            httpCallBack = null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httpCallBack = null;
        }
    }

    public String readRaw(Context context, int rawId) {
        // 从raw文件读取文件的字节流
        InputStream is = context.getResources().openRawResource(rawId);
        String s = null;
        try {
            byte[] buffer = readByteFromInputStream(is);
            s = new String(buffer, 0, buffer.length, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    private byte[] readByteFromInputStream(InputStream is) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int BYTE_SIZE = 2 * 1024;
        //创建字节数组作为缓存
        byte[] b = new byte[BYTE_SIZE];
        int c;
        //c = bis.read(b)将字节流读出后放入字节数组b中,baos.write(b, 0, c);读取多少就写入多少
        while ((c = bis.read(b)) != -1) {
            baos.write(b, 0, c);
            baos.flush();
        }
        //将字节数组流转换成字节数组
        byte[] date = baos.toByteArray();
        is.close();
        baos.close();
        return date;
    }

    public File saveBitmap(Context context, Bitmap bitmap, String dirs, String fileName) {
        try {
            File dir = new File(context.getExternalCacheDir().getAbsolutePath() + "/" + dirs);
            // 判断文件夹是否存在，不存在则创建
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir + "/" + fileName + ".jpg");
            // 判断文件是否存在，不存在则创建
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                LogUtils.e("4newFile===" + newFile);
            }
            FileOutputStream fos = null;

            fos = new FileOutputStream(file);
            if (fos != null) {
                // 第一参数是图片格式，第二个是图片质量，第三个是输出流
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                // 用完关闭
                fos.flush();
                fos.close();
                return file;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String ReadFile(InputStream Path) {
        BufferedReader reader = null;
        String laststr = "";
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(Path, "utf-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public static String readTxt(String path) {
        String str = "";
        if (!TextUtils.isEmpty(path)) {
            File urlFile = new File(path);
            if (urlFile.exists()) {
                try (
                        InputStreamReader isr = new InputStreamReader(new FileInputStream(urlFile), "UTF-8");
                        BufferedReader br = new BufferedReader(isr)
                ) {
                    String mimeTypeLine;
                    while ((mimeTypeLine = br.readLine()) != null) {
                        str = str + mimeTypeLine;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    public File[] getLogFileList(Context context) {
        File logDirFile = new File(context.getExternalCacheDir().getAbsolutePath() + WriteLogUtil.LOG_FILE_PATH);
        if (logDirFile != null && logDirFile.exists()) {
            return logDirFile.listFiles();
        }
        return null;
    }

    /**
     * 从文件中读取String字符数据
     */
//    public String readStrByFilePath(String filePath) {
//        File file = new File(filePath);
//        if (file.exists()) {
//            FileInputStream fis = null;
//            try {
//                fis = new FileInputStream(file);
//                int len = fis.available();
//                if (len > 0) {
//                    byte[] buf = new byte[len];
//                    fis.read(buf);
//                    //
//                    String string = new String(buf, "UTF-8");
//                    return string;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } catch (OutOfMemoryError e) {
//                e.printStackTrace();
//            } finally {
//                if (fis != null)
//                    try {
//                        fis.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//            }
//        }
//        return null;
//    }

}