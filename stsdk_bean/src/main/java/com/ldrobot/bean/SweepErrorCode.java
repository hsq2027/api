package com.ldrobot.bean;

import java.util.ArrayList;

/**
 * Created by Emiya on 17/8/11.
 */

public class SweepErrorCode {
    private int intVersion;
    private ArrayList<ErrorCode> errorCodeInfo;

    public int getIntVersion() {
        return intVersion;
    }

    public void setIntVersion(int intVersion) {
        this.intVersion = intVersion;
    }

    public ArrayList<ErrorCode> getErrorCodeInfo() {
        return errorCodeInfo;
    }

    public void setErrorCodeInfo(ArrayList<ErrorCode> errorCodeInfo) {
        this.errorCodeInfo = errorCodeInfo;
    }

    /**
     * 中文	Chinese	cn
     * 英文	English	en
     * 德语	Deutsch	de
     * 法语	français	fr
     * 西班牙语	español	es
     * 意大利语	italiano	ita
     * 波兰语	polski	po
     * 捷克	česky	cze
     * 俄罗斯	русский	py
     * 荷兰语	Nederlands	ne
     */
    public class ErrorCode {
        private int code;               //错误码
        private String errType;         //类型
        private String enMsg;           //英文描述
        private String chMsg;           //中文描述
        private String cnMsg;           //兼容中文描述
        private String deMsg;           //德语描述
        private String frMsg;           //法语描述
        private String esMsg;           //西班牙语描述
        private String itaMsg;           //意大利语描述
        private String poMsg;           //波兰语描述
        private String czeMsg;           //捷克描述
        private String pyMsg;           //俄罗斯描述
        private String neMsg;           //荷兰语描述
        private String koMsg;           //韩语语描述
        private String jpMsg;           //ri语描述
        private String araMsg;           //阿拉伯语描述
        private String vietMsg;           //越南语
        private String norMsg;           //挪威语
        private String hkMsg;           //中国香港繁体
        private String sloMsg;           //斯洛伐克语

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getErrType() {
            return errType;
        }

        public void setErrType(String errType) {
            this.errType = errType;
        }

        public String getEnMsg() {
            return enMsg;
        }

        public void setEnMsg(String enMsg) {
            this.enMsg = enMsg;
        }

        public String getChMsg() {
            return chMsg;
        }

        public void setChMsg(String chMsg) {
            this.chMsg = chMsg;
        }

        public String getCnMsg() {
            return cnMsg;
        }

        public void setCnMsg(String cnMsg) {
            this.cnMsg = cnMsg;
        }

        public String getDeMsg() {
            return deMsg;
        }

        public void setDeMsg(String deMsg) {
            this.deMsg = deMsg;
        }

        public String getFrMsg() {
            return frMsg;
        }

        public void setFrMsg(String frMsg) {
            this.frMsg = frMsg;
        }

        public String getEsMsg() {
            return esMsg;
        }

        public void setEsMsg(String esMsg) {
            this.esMsg = esMsg;
        }

        public String getItaMsg() {
            return itaMsg;
        }

        public void setItaMsg(String itaMsg) {
            this.itaMsg = itaMsg;
        }

        public String getPoMsg() {
            return poMsg;
        }

        public void setPoMsg(String poMsg) {
            this.poMsg = poMsg;
        }

        public String getCzeMsg() {
            return czeMsg;
        }

        public void setCzeMsg(String czeMsg) {
            this.czeMsg = czeMsg;
        }

        public String getPyMsg() {
            return pyMsg;
        }

        public void setPyMsg(String pyMsg) {
            this.pyMsg = pyMsg;
        }

        public String getNeMsg() {
            return neMsg;
        }

        public void setNeMsg(String neMsg) {
            this.neMsg = neMsg;
        }

        public String getKoMsg() {
            return koMsg;
        }

        public void setKoMsg(String koMsg) {
            this.koMsg = koMsg;
        }

        public String getJpMsg() {
            return jpMsg;
        }

        public void setJpMsg(String jpMsg) {
            this.jpMsg = jpMsg;
        }

        public String getAraMsg() {
            return araMsg;
        }

        public void setAraMsg(String araMsg) {
            this.araMsg = araMsg;
        }

        @Override
        public String toString() {
            return "ErrorCode{" +
                    "code=" + code +
                    ", errType='" + errType + '\'' +
                    ", enMsg='" + enMsg + '\'' +
                    ", chMsg='" + chMsg + '\'' +
                    ", cnMsg='" + cnMsg + '\'' +
                    ", deMsg='" + deMsg + '\'' +
                    ", frMsg='" + frMsg + '\'' +
                    ", esMsg='" + esMsg + '\'' +
                    ", itaMsg='" + itaMsg + '\'' +
                    ", poMsg='" + poMsg + '\'' +
                    ", czeMsg='" + czeMsg + '\'' +
                    ", pyMsg='" + pyMsg + '\'' +
                    ", neMsg='" + neMsg + '\'' +
                    ", koMsg='" + koMsg + '\'' +
                    ", jpMsg='" + jpMsg + '\'' +
                    ", araMsg='" + araMsg + '\'' +
                    ", vietMsg='" + vietMsg + '\'' +
                    ", norMsg='" + norMsg + '\'' +
                    ", hkMsg='" + hkMsg + '\'' +
                    ", sloMsg='" + sloMsg + '\'' +
                    '}';
        }

        public String getVietMsg() {
            return vietMsg;
        }

        public void setVietMsg(String vietMsg) {
            this.vietMsg = vietMsg;
        }

        public String getNorMsg() {
            return norMsg;
        }

        public void setNorMsg(String norMsg) {
            this.norMsg = norMsg;
        }

        public String getHkMsg() {
            return hkMsg;
        }

        public void setHkMsg(String hkMsg) {
            this.hkMsg = hkMsg;
        }

        public String getSloMsg() {
            return sloMsg;
        }

        public void setSloMsg(String sloMsg) {
            this.sloMsg = sloMsg;
        }
    }
}