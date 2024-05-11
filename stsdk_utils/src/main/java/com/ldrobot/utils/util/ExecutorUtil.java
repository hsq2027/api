package com.ldrobot.utils.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by MOSL
 * Date 2021/4/26
 */
public class ExecutorUtil {

    private static ExecutorService fixExecutorService;

    public static ExecutorService getFixInstance() {
        if (fixExecutorService == null) {
            fixExecutorService = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
        }
        return fixExecutorService;
    }
}