package com.ldrobot.utils.util.lru;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import com.ldrobot.utils.util.StringUtil;
import com.ldrobot.utils.util.SystemUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: hsq
 * @CreateTime: 2022/9/13 11:18
 * @Description: java类作用描述
 */
public class LruCacheUtil {

    private static DiskLruCache mapDiskLruCache;
    private static DiskLruCache obstacleDiskLruCache;

    public interface SaveType {
        int MAP = 1;//地图管理地图文件
        int OBSTACLE = 2;//AI地图障碍物地图文件
    }

    private static DiskLruCache openLruCacheData(Context context, int type) throws IOException {
        if (context == null) {
            return null;
        }
        if (type == SaveType.MAP) {
            if (mapDiskLruCache == null) {
                mapDiskLruCache = DiskLruCache.open(new File(context.getExternalCacheDir().getAbsolutePath() + "/map"), SystemUtil.getVersionCode(context), 1, 10 * 1024 * 1024);
            }
            return mapDiskLruCache;
        } else if (type == SaveType.OBSTACLE) {
            if (obstacleDiskLruCache == null) {
                obstacleDiskLruCache = DiskLruCache.open(new File(context.getExternalCacheDir().getAbsolutePath() + "/obstacle/image"), SystemUtil.getVersionCode(context), 1, 10 * 1024 * 1024);
            }
            return obstacleDiskLruCache;
        }
        return null;
    }

    /**
     * @param context
     * @param key
     * @param dataStr
     */
    public static void setCacheData(Context context, String key, String dataStr) {
        setCacheData(context, key, dataStr, SaveType.MAP);
    }

    /**
     * @param context
     * @param key
     * @param dataStr
     * @param type    参考{@link SaveType}
     */
    public static void setCacheData(Context context, String key, String dataStr, int type) {
        if (TextUtils.isEmpty(dataStr) || context == null) {
            return;
        }
        setCacheData(context, key, dataStr.getBytes(), type);
    }

    public static void setCacheData(Context context, String key, byte[] bytes, int type) {
        if (bytes == null || context == null) {
            return;
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        DiskLruCache.Editor edit = null;
        DiskLruCache cache = null;
        try {
            cache = openLruCacheData(context, type);
            if (cache != null) {
                edit = cache.edit(key);
                if (edit != null) {
                    OutputStream outputStream = edit.newOutputStream(0);
                    int b;
                    while ((b = inputStream.read()) != -1) {
                        outputStream.write(b);
                    }
                    edit.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            abort(edit);
        } finally {
//            if (cache != null) {
//                try {
//                    cache.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    private static void abort(DiskLruCache.Editor edit) {
        if (edit != null) {
            try {
                edit.abort();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getCacheData(Context context, String key) {
        return getCacheData(context, key, SaveType.MAP);
    }

    public static String getCacheData(Context context, String key, int type) {
        if (context == null) {
            return null;
        }
        DiskLruCache cache = null;
        try {
            cache = openLruCacheData(context, type);
            if (cache != null) {
                DiskLruCache.Snapshot snapshot = cache.get(key);
                if (snapshot != null) {
                    InputStream inputStream = snapshot.getInputStream(0);
                    return StringUtil.inputStreamToStr(inputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (cache != null) {
//                try {
//                    cache.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        return null;
    }

    public static Bitmap getObstacleCacheData(Context context, String key) {
        if (context == null) {
            return null;
        }
        DiskLruCache cache = null;
        try {
            cache = openLruCacheData(context, SaveType.OBSTACLE);
            if (cache != null) {
                DiskLruCache.Snapshot snapshot = cache.get(key);
                if (snapshot != null) {
                    InputStream inputStream = snapshot.getInputStream(0);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (cache != null) {
//                try {
//                    cache.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        return null;
    }
}