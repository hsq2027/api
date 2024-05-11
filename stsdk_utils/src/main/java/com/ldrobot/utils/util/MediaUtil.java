package com.ldrobot.utils.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * @Author: hsq
 * @CreateTime: 2022/5/9 9:55
 * @Description: java类作用描述
 */
public class MediaUtil {
    //播放本地音频
    public static MediaPlayer playMedia(Context context, int raw) {
        LogUtils.e("开始：" + raw);
        MediaPlayer mPlayer = MediaPlayer.create(context, raw);
        mPlayer.start();
        return mPlayer;
    }

    //播放本地音频
    public static MediaPlayer playMedia(Context context, int raw, MediaPlayer.OnCompletionListener listener, MediaPlayer.OnPreparedListener preparedListener) {
        LogUtils.e("开始：" + raw);
        MediaPlayer mPlayer = MediaPlayer.create(context, raw);
        mPlayer.setOnPreparedListener(preparedListener);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (listener != null) {
                    listener.onCompletion(mediaPlayer);
                }
            }
        });
        mPlayer.start();
        return mPlayer;
    }

    //播放网络音频
    public static MediaPlayer playMedia(String url) {
        return playMedia(url, null, null, null);
    }

    public static MediaPlayer playMedia(String url, MediaPlayer.OnPreparedListener preparedListener, MediaPlayer.OnErrorListener errorListener, MediaPlayer.OnCompletionListener completionListener) {
        LogUtils.e("开始：" + url);
        MediaPlayer mPlayer = new MediaPlayer();
        try {
            mPlayer.reset();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.setDataSource(url);
            mPlayer.prepareAsync();
            mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mPlayer) {
                    LogUtils.e("onPrepared");
                    mPlayer.start();
                    if (preparedListener != null) {
                        preparedListener.onPrepared(mPlayer);
                    }
                }
            });
            mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mPlayer, int what, int extra) {
                    LogUtils.e("播放错误：" + what + "---" + extra);
                    if (mPlayer != null) {
                        mPlayer.release();
                        mPlayer = null;
                    }
                    if (errorListener != null) {
                        errorListener.onError(mPlayer, what, extra);
                    }
                    return false;
                }
            });
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mPlayer) {
                    LogUtils.e("onCompletion");
                    if (mPlayer != null) {
                        mPlayer.release();
                        mPlayer = null;
                    }
                    if (completionListener != null) {
                        completionListener.onCompletion(mPlayer);
                    }
                }
            });
        } catch (IOException e) {
            LogUtils.e("MediaPlayer异常：" + e);
            e.printStackTrace();
            if (errorListener != null) {
                errorListener.onError(mPlayer, -66, -66);
            }
        }
        return mPlayer;
    }

    public static void stopMedia(MediaPlayer mediaPlayer) {
        LogUtils.e("调用stopMedia111");
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            LogUtils.e("调用stopMedia222");
        }
    }
}