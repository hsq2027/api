package com.ldrobot.bean;

public class C2JavaTypeSwitch {

    public static short[] getShortsFromArray(byte[] data, int offset, int useLen) {
        if (offset + useLen > data.length || useLen < 2) {
            return null;
        }
        int len = useLen / 2;
        short[] result = new short[len];
        int p = offset;
        for (int i = 0; i < len; i++) {
            result[i] = getShortFromArray(data, p, 2);
            p += 2;
        }
        return result;
    }

    public static int[] getIntsFromArray(byte[] data, int offset, int useLen) {
        if (offset + useLen > data.length || useLen < 4) {
            return null;
        }
        int len = useLen / 4;
        int[] result = new int[len];
        int p = offset;
        for (int i = 0; i < len; i++) {
            result[i] = getIntFromArray(data, p, 4);
            p += 4;
        }
        return result;
    }

    public static int getIntFromArray(byte[] data, int offset, int len) {
        int ret = 0;
        if ((len > 4) || ((offset + len) > data.length) || (offset < 0)) {
            return 0;
        }

        byte[] bIntArray = new byte[4];
        for (int i = 0; i < 4; i++) {
            if (i < len) {
                bIntArray[3 - i] = data[offset + i];
            } else {
                bIntArray[3 - i] = 0;
            }
        }
        ret = byteToInt2(bIntArray);
        return ret;
    }

    public static short getShortFromArray(byte[] data, int offset, int len) {
        short ret = 0;
        if ((len > 2) || ((offset + len) > data.length) || (offset < 0)) {
            return 0;
        }

        byte[] bshortArray = new byte[2];
        for (int i = 0; i < 2; i++) {
            if (i < len) {
                bshortArray[1 - i] = data[offset + i];
            } else {
                bshortArray[1 - i] = 0;
            }
        }
        ret = byteToShort2(bshortArray);
        return ret;
    }

    public static long getLongFromArray(byte[] data, int offset, int len) {
        long ret = 0;
        if ((len > 8) || ((offset + len) > data.length) || (offset < 0)) {
            return 0;
        }
        byte[] bIntArray = new byte[8];
        for (int i = 0; i < 8; i++) {
            if (i < len) {
                bIntArray[8 - i - 1] = data[offset + i];
            } else {
                bIntArray[8 - i - 1] = 0;
            }
        }
        ret = byteToLong2(bIntArray);
        return ret;
    }

    public static int byteToInt2(byte[] b) {

        int mask = 0xff;
        int temp = 0;
        int n = 0;
        for (int i = 0; i < b.length; i++) {
            n <<= 8;
            temp = b[i] & mask;
            n |= temp;
        }
        return n;
    }

    private static short byteToShort2(byte[] b) {

        int mask = 0xff;
        int temp = 0;
        short n = 0;
        for (int i = 0; i < b.length; i++) {
            n <<= 8;
            temp = b[i] & mask;
            n |= temp;
        }
        return n;
    }

    private static long byteToLong2(byte[] b) {

        int mask = 0xff;
        int temp = 0;
        long n = 0;
        for (int i = 0; i < b.length; i++) {
            n <<= 8;
            temp = b[i] & mask;
            n |= temp;
        }
        return n;
    }

}