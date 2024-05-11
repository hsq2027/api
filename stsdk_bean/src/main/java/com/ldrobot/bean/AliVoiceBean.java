package com.ldrobot.bean;

import java.util.List;

/**
 * 创建时间：2019/12/19  16:11
 * 作者：5#
 * 描述：本地Bean   语音包
 * 注意：
 */
public class AliVoiceBean {

    /**
     * voiceVersion : 1
     * voicePackets : [{"language":"CN","src_dir":"CN","language_dec":"中国","img":"cn.png","lists":[{"name":"cn_sample","dec":"测试语音"},{"name":"cn_standard","dec":"中文标准"}]},{"language":"KR","src_dir":"KR","language_dec":"한국","img":"kr.png","lists":[{"name":"kr_sample","dec":"LD 보기."}]},{"language":"EN","src_dir":"EN","language_dec":"English","img":"en.png","lists":[{"name":"en_sample","dec":"English sample"}]}]
     */

    private String voiceVersion;
    private List<VoicePacketsBean> voicePackets;

    public String getVoiceVersion() {
        return voiceVersion;
    }

    public void setVoiceVersion(String voiceVersion) {
        this.voiceVersion = voiceVersion;
    }

    public List<VoicePacketsBean> getVoicePackets() {
        return voicePackets;
    }

    public void setVoicePackets(List<VoicePacketsBean> voicePackets) {
        this.voicePackets = voicePackets;
    }

    public static class VoicePacketsBean {
        /**
         * language : CN
         * src_dir : CN
         * language_dec : 中国
         * img : cn.png
         * lists : [{"name":"cn_sample","dec":"测试语音"},{"name":"cn_standard","dec":"中文标准"}]
         */

        private String voiceId;
        private String language;
        private String src_dir;
        private String language_dec;
        private String img;
        private List<ListsBean> lists;
        private String name;
        private String dec;
        private String TitleImg;
        private String test_music;//试听链接
        private boolean isPlaying;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getSrc_dir() {
            return src_dir;
        }

        public void setSrc_dir(String src_dir) {
            this.src_dir = src_dir;
        }

        public String getLanguage_dec() {
            return language_dec;
        }

        public void setLanguage_dec(String language_dec) {
            this.language_dec = language_dec;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public List<ListsBean> getLists() {
            return lists;
        }

        public void setLists(List<ListsBean> lists) {
            this.lists = lists;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDec() {
            return dec;
        }

        public void setDec(String dec) {
            this.dec = dec;
        }

        public String getTitleImg() {
            return TitleImg;
        }

        public void setTitleImg(String titleImg) {
            TitleImg = titleImg;
        }

        public String getTest_music() {
            return test_music;
        }

        public void setTest_music(String test_music) {
            this.test_music = test_music;
        }

        public boolean isPlaying() {
            return isPlaying;
        }

        public void setPlaying(boolean playing) {
            isPlaying = playing;
        }

        public String getVoiceId() {
            return voiceId;
        }

        public void setVoiceId(String voiceId) {
            this.voiceId = voiceId;
        }

        public static class ListsBean {
            /**
             * name : cn_sample
             * dec : 测试语音
             */

            private String name;
            private String dec;
            private String TitleImg;
            private int position; //本地字段，主要引起刷新
            private String test_music;

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDec() {
                return dec;
            }

            public void setDec(String dec) {
                this.dec = dec;
            }

            public String getTitleImg() {
                return TitleImg;
            }

            public void setTitleImg(String titleImg) {
                TitleImg = titleImg;
            }

            public String getTest_music() {
                return test_music;
            }

            public void setTest_music(String test_music) {
                this.test_music = test_music;
            }
        }
    }
}