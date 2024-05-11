package com.ldrobot.utils.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Set;

public class SharePreferencesUtils {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences sharedPreferences1;

    public interface Key {
        String IS_FIRST_LOGIN = "is_first_login";//第一次登录
        String USER_ID = "user_id";//用户id
        String TOKEN = "token";//token
        String AES_KEY = "aes_key";
        String AES_IV = "aes_iv";
        String TY_HOME_ID = "ty_home_id";
        String USER_STS = "user_sts";
        String DEVICE_STS = "device_sts";
        String PROTOCOL_VERSION = "protocol_version";
        String PROTOCOL_URL = "protocol_url";
        String PROTOCOL_NEED_CLEAR_CACHE = "protocol_need_clear_cache";
        String WIFI_HASH = "wifi_hash";
        String APP_FUNCTION_VERSION = "app_function_version";
        String APP_FUNCTION = "app_function";
        String PROJECT_FUNCTION_VERSION = "project_function_version";
        String PROJECT_FUNCTION = "project_function";
        String GENERAL_GUIDE_VERSION = "general_guide_version";
        String GENERAL_GUIDE = "general_guide";
        String GENERAL_GUIDE_NEED_CLEAR_CACHE = "general_guide_need_clear_cache";
        String PRODUCT_GUIDE_VERSION = "product_guide_version";
        String PRODUCT_GUIDE = "product_guide";
        String PRODUCT_GUIDE_NEED_CLEAR_CACHE = "product_guide_need_clear_cache";
        String USER_INFO_BEAN = "user_info_bean";
        String COMMON_SETTINGS_DATA_VERSION = "common_settings_data_version";
        String COMMON_SETTINGS_DATA = "common_settings_data";
        String VOICE_PACKAGE_VERSION = "voice_package_version";
        String VOICE_PACKAGE_CONFIG = "voice_package_config";
        String LOG_DEBUG_FLAG = "log_debug_flag";
        String DEVICE_INFO = "device_info";
        String CLEAN_ORDER_DATA = "clean_order_data";
        String GUIDE_SHOW_CLEAN_ORDER = "is_show_clean_order";
        String GUIDE_SHOW_MODE_SETTING = "guide_show_mode_setting";
        String GUIDE_SHOW_CUSTOM_SOLUTION = "guide_show_custom_solution";
        String GUIDE_SHOW_MORE = "guide_show_more";
        String GUIDE_SHOW_START_CLEAN = "guide_show_start_clean";
        String GUIDE_SHOW_MODE_SETTING_MANAGER = "guide_show_mode_setting_manager";
        String AREA_CODE = "area_code";
        String AREA_NAME = "area_name";
        String DARK_MODE = "day_night_mode";//-1：跟随系统；  1：浅色模式(默认)；  2：深色模式
        String USER_ACCOUNT = "user_account";
        String RECENT_CONTACTS = "recent_contacts";
        String HOME_ID = "home_id";
        String LD_MESH_ID = "ld_mesh_id";
        String LD_MESH_NAME = "ld_mesh_name";
        String COMPANY_ID = "company_id";
        String ERROR_CODE_VERSION = "error_code_version";
        String PRODUCT_ID = "product_id";
        String API_KEY_PGYER = "api_key_pgyer";
        String APP_KEY_PGYER = "app_key_pgyer";
        String DEVICE_MAX_VALUE = "device_max_value";
        String DEVICE_MAX_FILTER_TIME = "device_max_filter_time";
        String DEVICE_MAX_SIDE_BRUSH_LESS_TIME = "device_max_side_brush_less_time";
        String DEVICE_MAX_MAIN_BRUSH_LESS_TIME = "device_max_main_brush_less_time";
    }

    public static SharedPreferences init(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences("LDSmart", Context.MODE_PRIVATE);
        sharedPreferences1 = context.getApplicationContext().getSharedPreferences("LDSmart-Map", Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    private static SharedPreferences getInstance() {
        return sharedPreferences;
    }

    private static SharedPreferences getInstance1() {
        return sharedPreferences1;
    }

    public static void putString1(String key, String value) {
        SharedPreferences.Editor edit = getInstance1().edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static String getString1(String key) {
        return getString1(key, null);
    }

    public static String getString1(String key, String defValue) {
        return getInstance1().getString(key, defValue);
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor edit = getInstance().edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static String getString(String key) {
        return getString(key, null);
    }

    public static String getString(String key, String defValue) {
        return getInstance().getString(key, defValue);
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor edit = getInstance().edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static boolean getBoolean(String key) {
        return getInstance().getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean isFirstLogin) {
        return getInstance().getBoolean(key, isFirstLogin);
    }

    public static void putInt(String key, int value) {
        SharedPreferences.Editor edit = getInstance().edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void putLong(String key, long value) {
        SharedPreferences.Editor edit = getInstance().edit();
        edit.putLong(key, value);
        edit.commit();
    }

    public static Long getLong(String key, long defValue) {
        return getInstance().getLong(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return getInstance().getInt(key, defValue);
    }

    public static int getInt(String key) {
        return getInstance().getInt(key, 0);
    }

    public static String getWifiNameIndex(String wifiName) {
        String wifi_hash = getString(Key.WIFI_HASH, "");
        HashMap<String, String> hashMap = new Gson().fromJson(wifi_hash, new TypeToken<HashMap<String, String>>() {
        }.getType());
        String pwd = "";
        if (hashMap != null) {
            pwd = hashMap.get(wifiName);
        }
        if (pwd == null) {
            pwd = "";
        }
        return pwd;
    }

    /**
     * 保存wifi信息  最多5个
     *
     * @param wifiName
     */
    public static void setWifiNameAndPwd(String wifiName, String pwd) {
        String wifi_hash = getString(Key.WIFI_HASH, "");
        HashMap<String, String> hashMap = new Gson().fromJson(wifi_hash, new TypeToken<HashMap<String, String>>() {
        }.getType());
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (hashMap.size() == 5) {
            //删除一个
            Set<String> stringSet = hashMap.keySet();
            String temp = "";
            boolean isFirst = true;
            for (String key : stringSet) {
                temp = key;
                if (isFirst) {
                    break;
                }
            }
            hashMap.remove(temp);
        }
        hashMap.put(wifiName, pwd);
        putString(Key.WIFI_HASH, new Gson().toJson(hashMap));
    }

}