package com.ldrobot.utils.util;

import java.util.Locale;

/**
 * Created by msl
 * on 2022/4/6
 */
public class CountryUtils {

    public String getSortLetter(String name) {
        String letter = "#";
        if (name == null) {
            return letter;
        } else {
            String pinyin = CharacterParserUtil.getInstance().getSelling(name);
            String sortString = pinyin.substring(0, 1).toUpperCase(Locale.CHINESE);
            if (sortString.matches("[A-Z]")) {
                letter = sortString.toUpperCase(Locale.CHINESE);
            }

            return letter;
        }
    }

    public String getSortLetterBySortKey(String sortKey) {
        if (sortKey != null && !"".equals(sortKey.trim())) {
            String letter = "#";
            String sortString = sortKey.trim().substring(0, 1).toUpperCase(Locale.CHINESE);
            if (sortString.matches("[A-Z]")) {
                letter = sortString.toUpperCase(Locale.CHINESE);
            }

            return letter;
        } else {
            return null;
        }
    }
}