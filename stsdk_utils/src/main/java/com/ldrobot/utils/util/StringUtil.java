package com.ldrobot.utils.util;

import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: HSQ
 * @CreateTime: 2022/3/22 18:23
 * @Description: java类作用描述
 */
public class StringUtil {

    public static final String Number = "^[\\d ]*$";


    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    private static String hexString = "0123456789abcdef";
    private static final char[] DIGITS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] encodeHex(byte... data) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_HEX[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_HEX[0x0F & data[i]];
        }
        return out;
    }

    public static byte[] decodeHex(char[] data) {
        int len = data.length;
        if ((len & 0x01) != 0) {
            throw new RuntimeException("字符个数应该为偶数");
        }
        byte[] out = new byte[len >> 1];
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f |= toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

    protected static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    public static String toHex(String str) {
        return new String(encodeHex(str.getBytes()));
    }

    public static String toHex4(String str) {
        String s = new String(encodeHex(str.getBytes()));
        if (s != null && s.length() < 8) {
            int zeroNum = 8 - s.length();
            for (int i = 0; i < zeroNum; i++) {
                s = "0" + s;
            }
        }
        return s;
    }

    public static String fromHex(String hex) {
        if (StringUtil.isEmpty(hex)) {
            return null;
        }
        try {
            return new String(decodeHex(hex.toCharArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isNumber(String text) {
        if (isEmpty(text)) {
            return false;
        }

        if (text.matches(Number)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * byte[] 转 string
     *
     * @param byteArray
     * @return
     */
    public static String byteArrayToStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        String str = new String(byteArray);
        return str;
    }

    //去掉末尾的# #
    public static String handleJson(String mapJson) {
        int lastIndexOf = mapJson.lastIndexOf("#\t#");
        String substring = "";
        //找不到会是 -1
        if (lastIndexOf > 0) {
            substring = mapJson.substring(0, lastIndexOf);
        } else {
            substring = mapJson;
        }
        return substring;
    }

    /**
     * SHA加密
     *
     * @param strSrc 明文
     * @return 加密之后的密文
     */
    public static String shaEncrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = toBytes(strSrc);
        try {
            md = MessageDigest.getInstance("SHA-256");// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(bt);
            String msg = StringUtil.bytes2HexString(md.digest());
//            strDes = bytes2Hex(md.digest()); // to HexString
            strDes = msg.substring(0, 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return strDes;
    }

    /**
     * 将16进制字符串转换为byte[]
     *
     * @param str
     * @return
     */
    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }

    // byte转十六进制字符串
    public static String bytes2HexString(byte[] bytes) {
        String ret = "";
        for (byte item : bytes) {
            String hex = Integer.toHexString(item & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase(Locale.CHINA);
        }
        return ret;
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bts 数据源
     * @return 16进制字符串
     */
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    /**
     * 十六进制（4个字节）转十进制
     *
     * @return
     */
    public static int hex4ToDecimal(String hexStr) {
        try {
            return new BigInteger(hexStr, 16).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("hexToDecimal error：" + e);
        }
        return -1;
    }

    /**
     * 十六进制（2个字节）转十进制
     *
     * @return
     */
    public static int hex2ToDecimal(String hexStr) {
        try {
            return new BigInteger(hexStr, 16).shortValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("hexToDecimal error1：" + e);
        }
        return -1;
    }

    /**
     * 十六进制（1个字节）转十进制
     *
     * @return
     */
    public static int hex1ToDecimal(String hexStr) {
        try {
            return new BigInteger(hexStr, 16).byteValue();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("hexToDecimal error1：" + e);
        }
        return -1;
    }

    /**
     * 十六进制转二进制
     *
     * @return
     */
    public static String hexToBinary(String hexStr) {
        //16进制转10进制
        BigInteger bigInteger = new BigInteger(hexStr, 16);
        //10进制转2进制
        String result = bigInteger.toString(2);
        return result;
    }

    /**
     * 十六进制转二进制（前面补0）
     *
     * @return
     */
    public static String hexToBinary1(String hexStr) {
        //16进制转10进制
        BigInteger bigInteger = new BigInteger(hexStr, 16);
        //10进制转2进制
        String result = bigInteger.toString(2);
        if (result != null && result.length() < 8) {
            int zeroNum = 8 - result.length();
            for (int i = 0; i < zeroNum; i++) {
                result = "0" + result;
            }
        }
        return result;
    }

    /**
     * 二进制转十六进制
     *
     * @return
     */
    public static String binaryToHex(String binaryStr) {
        int ten = Integer.parseInt(binaryStr, 2);
        String sixteen = integerToHex(ten);
        return sixteen;
    }

    public static byte[] hexToByte(String hex) {
        if (StringUtil.isEmpty(hex)) {
            return null;
        }
        return decodeHex(hex.toCharArray());
    }

    /**
     * 十进制转十六进制
     *
     * @param intStr
     * @return
     */
    public static String integerToHex(int intStr) {
        try {
            String s = Integer.toHexString(intStr);
            if (s != null && s.length() == 1) {
                s = "0" + s;
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("integerToHex error：" + e);
        }
        return null;
    }

    /**
     * 十进制转十六进制
     *
     * @param intStr
     * @return
     */
    public static String integerToHex1(int intStr) {
        try {
            String s = Integer.toHexString(intStr);
            if (s != null) {
                if (s.length() > 2) {
                    return substring(s, s.length() - 2, s.length());
                } else if (s.length() == 1) {
                    return "0" + s;
                } else {
                    return s;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("integerToHex1 error：" + e);
        }
        return null;
    }

    /**
     * 十进制转十六进制
     *
     * @param intStr
     * @return
     */
    public static String integerToHex2(int intStr) {
        try {
            String s = Integer.toHexString(intStr);
            if (s.length() == 1) {
                s = "000" + s;
            } else if (s.length() == 2) {
                s = "00" + s;
            } else if (s.length() == 3) {
                s = "0" + s;
            } else if (s.length() == 8) {
                s = s.substring(4);
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("integerToHex1 error：" + e);
        }
        return null;
    }

    /**
     * 十进制转十六进制
     *
     * @param intStr
     * @return
     */
    public static String integerToHex4(int intStr) {
        try {
            String s = Integer.toHexString(intStr);
            if (s != null && s.length() < 8) {
                int zeroNum = 8 - s.length();
                for (int i = 0; i < zeroNum; i++) {
                    s = "0" + s;
                }
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("integerToHex2 error：" + e);
        }
        return null;
    }

//    public static String decimalToHex() {
//
//    }

    /**
     * 十进制转十六进制
     *
     * @param intStr
     * @return
     */
    public static String floatToHex(float intStr) {
        try {
            String s = Float.toHexString(intStr);
            if (s.length() == 1) {
                s = "0" + s;
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("floatToHex error：" + e);
        }
        return null;
    }

    /**
     * 十进制转二进制
     *
     * @return
     */
    public static String decimalToBinary(int intValue) {
        try {
            String binaryStr = Integer.toBinaryString(intValue);
            return binaryStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取故障id数组
     *
     * @param errorCodeStr 二进制错误码字符串
     * @return
     */
    public static List<Integer> getErrorCodeId(String errorCodeStr) {
        List<Integer> ids = new ArrayList<>();
        if (!TextUtils.isEmpty(errorCodeStr)) {
            errorCodeStr = new StringBuffer(errorCodeStr).reverse().toString();
            for (int i = 0; i < errorCodeStr.length(); i++) {
                if ("1".equals(errorCodeStr.charAt(i) + "")) {
                    ids.add(i);
                }
            }
        }
        return ids;
    }

    public static int getHexSum(String... values) {
        if (values == null || values.length == 0) {
            return 0;
        }
        int sum = 0;
        for (String value : values) {
            sum += hex4ToDecimal(value);
//            if (sum > 0xff) {
//                sum = ~sum;
//                sum += 1;
//            }
        }
        sum = sum & 0xff;
        return sum;
    }

    public static boolean checkSum(String values) {
        try {
            if (values == null) {
                return false;
            }
            String sumValue = "";
            if ((values.startsWith("aa") || values.startsWith("AA")) && values.length() - 2 > 6) {
                sumValue = values.substring(6, values.length() - 2);
            } else if ((values.startsWith("ab") || values.startsWith("AB")) && values.length() - 2 > 12) {
                sumValue = values.substring(12, values.length() - 2);
            }
            int sum = hex4ToDecimal(values.substring(values.length() - 2));
            int realSum = getHexSum(getStrArray(sumValue));
            return sum == realSum;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("checkSum error：" + e);
        }
        return false;
    }

    public static String[] getStrArray(String dataStr) {
        if (TextUtils.isEmpty(dataStr)) {
            return null;
        }
        String[] dataArray = new String[dataStr.length() / 2];
        int j = 0;
        for (int i = 0; i < dataStr.length(); i += 2) {
            dataArray[j] = dataStr.substring(i, i + 2);
            j++;
        }
        return dataArray;
    }

    public static String getCmd(String dataStr) {
        if (dataStr != null) {
            try {
                dataStr = dataStr.toUpperCase();
                if (dataStr.startsWith("AA") && dataStr.length() >= 8) {
                    return dataStr.substring(6, 8);
                } else if (dataStr.startsWith("AB") && dataStr.length() >= 14) {
                    return dataStr.substring(12, 14);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.e("getCmd error：" + e);
            }
        }
        return null;
    }

    public static String getValue(String dataStr) {
        if (dataStr != null) {
            try {
                dataStr = dataStr.toUpperCase();
                if (dataStr.startsWith("AA") && dataStr.length() - 2 > 8) {
                    return dataStr.substring(8, dataStr.length() - 2);
                } else if (dataStr.startsWith("AB") && dataStr.length() - 2 > 14) {
                    return dataStr.substring(14, dataStr.length() - 2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.e("getValue error：" + e);
            }
        }
        return null;
    }

    /*
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String encode(String str) {
        //根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        //将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f)));
        }
        return sb.toString();
    }

    /*
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public static String decode(String bytes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        //将每2位16进制整数组装成一个字节
        for (int i = 0; i < bytes.length(); i += 2)
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
        return new String(baos.toByteArray());
    }

    public static String inputStreamToStr(InputStream inputStream) {
        if (inputStream != null) {
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result = 0;
            try {
                result = bis.read();
                while (result != -1) {
                    buf.write((byte) result);
                    result = bis.read();
                }
                // StandardCharsets.UTF_8.name() > JDK 7
                return buf.toString("UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String printComplementCode(int a) {
        String s = "";
        for (int i = 0; i < 32; i++) {
            // 0x80000000 是一个首位为1，其余位数为0的整数
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            LogUtils.e(t + "");
            s += t;
        }
        return s;
    }

    public static String substring(String value, int begin, int end) {
        if (value != null && value.length() >= end) {
            return value.substring(begin, end);
        }
        return "";
    }

    /**
     * 十六进制大小端转换
     *
     * @param hexString
     * @return
     */
    public static String reverseHexString(String hexString) {
        StringBuilder reversedHex = new StringBuilder();
        for (int i = hexString.length() - 2; i >= 0; i -= 2) {
            reversedHex.append(hexString.substring(i, i + 2));
        }
        return reversedHex.toString();
    }

    /**
     * 十六进制按小端解析
     *
     * @param hexString
     * @return
     */
    public static int hexToIntSmall(String hexString) {
        String reversedHexString = reverseHexString(hexString);
        return hex4ToDecimal(reversedHexString);
    }

}