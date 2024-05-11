package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/7/8 15:31
 * @Description: java类作用描述
 */
public class LdAreaBean {
    /**
     * searchName : A
     * list : [{"enName":"Angola","cnName":"安哥拉","sortName":"AO","countryCode":"244","timeZones":"-7"},{"enName":"Afghanistan","cnName":"阿富汗","sortName":"AF","countryCode":"93","timeZones":"0"},{"enName":"Albania","cnName":"阿尔巴尼亚","sortName":"AL","countryCode":"355","timeZones":"-7"},{"enName":"Algeria","cnName":"阿尔及利亚","sortName":"DZ","countryCode":"213","timeZones":"-8"},{"enName":"Andorra","cnName":"安道尔共和国","sortName":"AD","countryCode":"376","timeZones":"-8"},{"enName":"Anguilla","cnName":"安圭拉岛","sortName":"AI","countryCode":"1264","timeZones":"-12"},{"enName":"Antigua and Barbuda","cnName":"安提瓜和巴布达","sortName":"AG","countryCode":"1268","timeZones":"-12"},{"enName":"Argentina","cnName":"阿根廷","sortName":"AR","countryCode":"54","timeZones":"-11"},{"enName":"Armenia","cnName":"亚美尼亚","sortName":"AM","countryCode":"374","timeZones":"-6"},{"enName":"Ascension","cnName":"阿森松","sortName":"","countryCode":"247","timeZones":"-8"},{"enName":"Australia","cnName":"澳大利亚","sortName":"AU","countryCode":"61","timeZones":"+2"},{"enName":"Austria","cnName":"奥地利","sortName":"AT","countryCode":"43","timeZones":"-7"},{"enName":"Azerbaijan","cnName":"阿塞拜疆","sortName":"AZ","countryCode":"994","timeZones":"-5"}]
     */

    private String searchName;
    private List<ListBean> list;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * enName : Angola
         * cnName : 安哥拉
         * sortName : AO
         * countryCode : 244
         * timeZones : -7
         */

        private String enName;
        private String cnName;
        private String sortName;
        private String countryCode;
        private String timeZones;

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getSortName() {
            return sortName;
        }

        public void setSortName(String sortName) {
            this.sortName = sortName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getTimeZones() {
            return timeZones;
        }

        public void setTimeZones(String timeZones) {
            this.timeZones = timeZones;
        }
    }
}