package com.ldrobot.utils.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;

/**
 * 创建时间：2019/12/12  16:08
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class PkgUtils {
    public static PackageManager getPackManager(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager;
    }

    public static String getVersonName(Context context) {
        try {
            PackageManager pm = getPackManager(context);
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getVersonCode(Context context) {
        try {
            PackageManager pm = getPackManager(context);
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getPakageName(Context context) {
        try {
            PackageManager pm = getPackManager(context);
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 下载完成后，自动安装apk
     * 1.若为7.0以下，正常安装
     * 2.若为7.0，8.0以下，使用FileProvider拿到路径，进行安装
     * 3.若为8.0以上，首先需要通过canRequestPackageInstalls()方法判断，是否有允许未知来源应用安装的权限，
     * 注意：AndroidManifest.xml中权限的配置
     * <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
     *
     * @param activity
     * @param apkFile
     * @param requestCode
     * @param applicationId
     */
    public static void install(Activity activity, File apkFile, int requestCode, String applicationId) {
        if (apkFile == null) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                boolean haveInstallPermission = activity.getPackageManager().canRequestPackageInstalls();
                if (!haveInstallPermission && Build.VERSION.SDK_INT < 30) {//安卓11跳转设置授权安装未知应用后返回会强制关闭APP，直接跳转安装系统会自动弹出授权请求弹窗
                    Uri packageURI = Uri.parse("package:" + activity.getPackageName());
                    intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI);
                    activity.startActivityForResult(intent, requestCode);
                    return;
                } else {
                    Uri apkUri = FileProvider.getUriForFile(activity, applicationId + ".fileprovider", apkFile);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
                }
            } else {
                intent.setAction(Intent.ACTION_INSTALL_PACKAGE);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(activity, applicationId + ".fileprovider", apkFile);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            }
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        activity.startActivity(intent);
    }

    /**
     * 判断当前应用是否是debug状态
     */
    public static boolean isApkInDebug(Context context) {
        boolean isdebug = false;
        try {
            ApplicationInfo info = context.getApplicationInfo();
            isdebug = (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("isApkInDebug", "mode = " + isdebug);
        return isdebug;
    }

    public static String getFileMD5(String filePath) {
        File file = new File(filePath);
        if (file != null && file.exists()) {
            LogUtils.e("文件存在");
            try {
                return MD5.GetMD5Code(MD5.byteToString(DigestUtils.getSha256Hash(file)));
            } catch (Exception e) {
                LogUtils.e("获取MD5异常：" + e);
                e.printStackTrace();
            }
        }
        return null;
    }

}