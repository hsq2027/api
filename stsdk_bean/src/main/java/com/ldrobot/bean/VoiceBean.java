package com.ldrobot.bean;

/**
 * @Author: hsq
 * @CreateTime: 2022/7/6 16:12
 * @Description: java类作用描述
 */
public class VoiceBean {
    private String voiceId;
    private String voiceName;
    private String languageName;
    private String voiceImg;
    private String auditionUrl;//试听链接
    private String voiceUrl;//语音包链接
    private String voiceMd5;
    private boolean isPlaying;//是否正在播放

    public String getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(String voiceId) {
        this.voiceId = voiceId;
    }

    public String getVoiceName() {
        return voiceName;
    }

    public void setVoiceName(String voiceName) {
        this.voiceName = voiceName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getVoiceImg() {
        return voiceImg;
    }

    public void setVoiceImg(String voiceImg) {
        this.voiceImg = voiceImg;
    }

    public String getAuditionUrl() {
        return auditionUrl;
    }

    public void setAuditionUrl(String auditionUrl) {
        this.auditionUrl = auditionUrl;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public String getVoiceMd5() {
        return voiceMd5;
    }

    public void setVoiceMd5(String voiceMd5) {
        this.voiceMd5 = voiceMd5;
    }
}