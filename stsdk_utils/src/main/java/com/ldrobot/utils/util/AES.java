package com.ldrobot.utils.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密解密算法 for PHP 后台
 *
 * @author Reek_Lee
 * @time 2014-4-18 下午4:28:50
 * @email：1522651962@qq.com
 */


public class AES {

    private static String AES_KEY = "EJKD93LJK8923ACD";
    private static String AES_IV = "23KCSLED43DFJKDE";

    /**
     * 加密
     *
     * @param data
     * @return
     * @throws Exception
     * @time 2014-4-22 下午5:11:38
     */
    public static String encrypt(String data) {
        try {
            String key = AES_KEY;
            String iv = AES_IV;
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.encodeBase64(encrypted));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密
     *
     * @param data
     * @return
     * @throws Exception
     * @time 2014-4-22 下午5:11:45
     */
    public static String desEncrypt(String data) {
        try {
            String key = AES_KEY;
            String iv = AES_IV;
            byte[] encrypted1 = Base64.decodeBase64(data.replaceAll(" ", "+").getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String desEncrypt(String data,String keyP,String ivP) {
        try {
            String key = keyP;
            String iv = ivP;
            String charsetName = "UTF-8";
            byte[] encrypted1 = Base64.decodeBase64(data.replaceAll(" ", "+").getBytes(charsetName));
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, charsetName);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 加密
     */
    public static String encrypt(String data, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.encodeBase64(encrypted));

        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }
    }

    /**
     * 加密
     */
//    public static String encryptWithECB(String data, String key) {
//        try {
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
//            int blockSize = cipher.getBlockSize();
//            byte[] dataBytes = data.getBytes();
//            int plaintextLength = dataBytes.length;
//            if (plaintextLength % blockSize != 0) {
//                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
//            }
//            byte[] plaintext = new byte[plaintextLength];
//            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
//            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
//            cipher.init(Cipher.ENCRYPT_MODE, keyspec);
//            byte[] encrypted = cipher.doFinal(plaintext);
//            return new String(Base64.encodeBase64(encrypted));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "null";
//        }
//    }

    /**
     * 解密
     */
//    public static String desEncryptWithECB(String data, String key) {
//        try {
//            byte[] encrypted1 = Base64.decodeBase64(data.replaceAll(" ", "+").getBytes("utf-8"));
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
//            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
//            cipher.init(Cipher.DECRYPT_MODE, keyspec);
//            byte[] original = cipher.doFinal(encrypted1);
//            String originalString = new String(original, "UTF-8");
//            return originalString;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}