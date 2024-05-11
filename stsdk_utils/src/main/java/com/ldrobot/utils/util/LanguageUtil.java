package com.ldrobot.utils.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * 语言
 */

public class LanguageUtil {
    public static final String LANGUAGE = "language";
    public static final int ENGLISH = 0;//英语
    public static final int CHINESE = 1;//中文简体
    public static final int CHINA_HONGKONG = 2;//中国香港繁体
    public static final int CHINA_TAIWAN = 3;//中国台湾繁体
    public static final int RUSSIAN = 4;//俄语
    public static final int KOREAN = 5;//韩语
    public static final int JAPANESE = 6;//日语
    public static final int GERMAN = 7;//德语
    public static final int FRENCH = 8;//法语
    public static final int SPANISH = 9;//西班牙语
    public static final int ITALIAN = 10;//意大利语
    public static final int POLISH = 11;//波兰语
    public static final int DUTCH = 12;//荷兰语
    public static final int ARABIC = 13;//阿拉伯语
    public static final int NORWEGIAN = 14;//挪威语
    public static final int SLOVAK = 15;//斯洛伐克语
    public static final int CZECH = 16;//捷克语
    public static final int VIETNAMESE = 17;//越南语
    private static SharedPreferences sharedPreferences;

    public static void initSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(LANGUAGE, Context.MODE_PRIVATE);
        }
    }

    public static int getLanguage() {
        if (sharedPreferences == null)
            return getPhoneLanguage();
        int language = sharedPreferences.getInt(LANGUAGE, getPhoneLanguage());
        return language;
    }

    public static int getPhoneLanguage() {
        String language = Locale.getDefault().getLanguage().toLowerCase();
        int system;
        switch (language){
            case "zh":
                system = CHINESE;
                break;
            case "zh-rHK":
                system = CHINA_HONGKONG;
                break;
            case "zh-rTW":
                system = CHINA_TAIWAN;
                break;
            case "ru":
                system = RUSSIAN;
                break;
            case "ko":
                system = KOREAN;
                break;
            case "ja":
                system = JAPANESE;
                break;
            case "de":
                system = GERMAN;
                break;
            case "fr":
                system = FRENCH;
                break;
            case "es":
                system = SPANISH;
                break;
            case "it":
                system = ITALIAN;
                break;
            case "pl":
                system = POLISH;
                break;
            case "nl":
                system = DUTCH;
                break;
            case "ar":
                system = ARABIC;
                break;
            case "nb":
                system = NORWEGIAN;
                break;
            case "sk":
                system = SLOVAK;
                break;
            case "cs":
                system = CZECH;
                break;
            case "vi":
                system = VIETNAMESE;
                break;
            default:
                system = ENGLISH;
                break;
        }
        return system;
    }

    public static void setLanguage(int language) {
        if (sharedPreferences == null)
            return;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LANGUAGE, language);
        editor.commit();
    }

    public static String getSdkLanguageStr() {
        int language = LanguageUtil.getLanguage();
        switch (language) {
            case LanguageUtil.CHINESE:
            case LanguageUtil.CHINA_HONGKONG:
            case LanguageUtil.CHINA_TAIWAN:
                return "zh-CN";
            case LanguageUtil.RUSSIAN:
                return "ru-RU";
            case LanguageUtil.KOREAN:
                return "ko-KR";
            case LanguageUtil.JAPANESE:
                return "ja-JP";
            case LanguageUtil.GERMAN:
                return "de-DE";
            case LanguageUtil.FRENCH:
                return "fr-FR";
            case LanguageUtil.SPANISH:
                return "es-ES";
            case LanguageUtil.ITALIAN:
                return "it-IT";
            case LanguageUtil.POLISH:
                return "pl-PL";
            case LanguageUtil.DUTCH:
                return "nl-NL";
//            case LanguageUtil.ARABIC:
//                return "ko-KR";
//            case LanguageUtil.NORWEGIAN:
//                return "ko-KR";
//            case LanguageUtil.SLOVAK:
//                return "ko-KR";
//            case LanguageUtil.CZECH:
//                return "ko-KR";
//            case LanguageUtil.VIETNAMESE:
//                return "ko-KR";
            default:
                return "en-US";
        }
    }

    public static void configLanguage(Context context) {
        int language = LanguageUtil.getLanguage();
        Configuration config = context.getResources().getConfiguration();
        switch (language) {
            case LanguageUtil.CHINESE:
                config.setLocale(Locale.CHINA);
                break;
            case LanguageUtil.CHINA_HONGKONG:
                config.setLocale(new Locale("zh-rHK"));
                break;
            case LanguageUtil.CHINA_TAIWAN:
                config.setLocale(Locale.TAIWAN);
                break;
            case LanguageUtil.KOREAN:
                config.setLocale(Locale.KOREA);
                break;
            case LanguageUtil.JAPANESE:
                config.setLocale(Locale.JAPANESE);
                break;
            case LanguageUtil.GERMAN:
                config.setLocale(Locale.GERMAN);
                break;
            case LanguageUtil.FRENCH:
                config.setLocale(Locale.FRENCH);
                break;
            case LanguageUtil.SPANISH:
                config.setLocale(new Locale("es"));
                break;
            case LanguageUtil.ITALIAN:
                config.setLocale(Locale.ITALIAN);
                break;
            case LanguageUtil.POLISH:
                config.setLocale(new Locale("pl"));
                break;
            case LanguageUtil.DUTCH:
                config.setLocale(new Locale("nl"));
                break;
            case LanguageUtil.ARABIC:
                config.setLocale(new Locale("ar"));
                break;
            case LanguageUtil.NORWEGIAN:
                config.setLocale(new Locale("nb"));
                break;
            case LanguageUtil.SLOVAK:
                config.setLocale(new Locale("sk"));
                break;
            case LanguageUtil.CZECH:
                config.setLocale(new Locale("cs"));
                break;
            case LanguageUtil.VIETNAMESE:
                config.setLocale(new Locale("vi"));
                break;
            default:
                config.setLocale(Locale.ENGLISH);
                break;
        }
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }

    public static String getAreaUrl() {
        int language = LanguageUtil.getLanguage();
        String areaUrl = "";
        switch (language) {
            case LanguageUtil.KOREAN:
                areaUrl = "api/ko/";
                break;
            case LanguageUtil.CHINESE:
                areaUrl = "api/cn/";
                break;
            default:
                areaUrl = "api/en/";
                break;
        }
        return areaUrl;
    }
}