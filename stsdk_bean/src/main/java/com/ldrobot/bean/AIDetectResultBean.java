package com.ldrobot.bean;

import java.util.List;

/**
 * @Author: hsq
 * @CreateTime: 2022/9/29 10:39
 * @Description: java类作用描述
 */
public class AIDetectResultBean {
    /**
     * time : 1664419056578
     * value : [{"time_stamp":"1298409305","pos":"0.184307,-0.302114,-1.296710","confidence":5577,"name":"/tmp/store/ai/1664418987/216907_1298409305","label":1,"pos_pixel":"444,380,276,74"},{"time_stamp":"1299866467","pos":"0.342242,-0.048489,0.450206","confidence":5070,"name":"/tmp/store/ai/1664418987/537191_1299866467","label":2,"pos_pixel":"820,330,394,158"},{"time_stamp":"1312744571","pos":"0.090986,0.311831,0.372972","confidence":4563,"name":"/tmp/store/ai/1664418987/597977_1312744571","label":1,"pos_pixel":"224,382,348,86"},{"time_stamp":"1329651491","pos":"-1.271062,0.693864,1.693383","confidence":4563,"name":"/tmp/store/ai/1664418987/999864_1329651491","label":0,"pos_pixel":"792,390,330,58"},{"time_stamp":"1353598138","pos":"-0.454720,-1.086698,-0.146529","confidence":5070,"name":"/tmp/store/ai/1664418987/368994_1353598138","label":1,"pos_pixel":"478,372,176,42"},{"time_stamp":"1382315984","pos":"1.921364,0.280031,2.358156","confidence":4563,"name":"/tmp/store/ai/1664418987/852081_1382315984","label":1,"pos_pixel":"510,324,126,82"}]
     */

    private long time;
    private List<ValueBean> value;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<ValueBean> getValue() {
        return value;
    }

    public void setValue(List<ValueBean> value) {
        this.value = value;
    }

    public static class ValueBean {
        /**
         * time_stamp : 1298409305
         * pos : 0.184307,-0.302114,-1.296710
         * confidence : 5577
         * name : /tmp/store/ai/1664418987/216907_1298409305
         * label : 1
         * pos_pixel : 444,380,276,74
         */

        private String time_stamp;
        private String pos;
        private int confidence;
        private String name;
        private int label;
        private String pos_pixel;
        private String mask_pixels;

        public String getTime_stamp() {
            return time_stamp;
        }

        public void setTime_stamp(String time_stamp) {
            this.time_stamp = time_stamp;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public int getConfidence() {
            return confidence;
        }

        public void setConfidence(int confidence) {
            this.confidence = confidence;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public String getPos_pixel() {
            return pos_pixel;
        }

        public void setPos_pixel(String pos_pixel) {
            this.pos_pixel = pos_pixel;
        }

        public String getMask_pixels() {
            return mask_pixels;
        }

        public void setMask_pixels(String mask_pixels) {
            this.mask_pixels = mask_pixels;
        }
    }
}