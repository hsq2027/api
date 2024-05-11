package com.ldrobot.utils.http;

import androidx.annotation.NonNull;

import com.ldrobot.utils.bean.EventBusBean;
import com.ldrobot.utils.util.FileUtil;
import com.ldrobot.utils.util.LogUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Emiya on 16/8/23.
 */
public class RetrofitUtil {

    private String TAG = getClass().getSimpleName();
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private static final AtomicReference<RetrofitUtil> INSTANCE = new AtomicReference<>();
    private static final AtomicReference<RetrofitUtil> INSTANCE1 = new AtomicReference<>();

    private Retrofit downloadRetrofit;

    public interface RetrofitType {
        int defaultType = 0;//默认
        int pgyerDownload = 1;//蒲公英下载
    }

    public static final RetrofitUtil getInstance() {
        RetrofitUtil singleton = INSTANCE.get();
        if (singleton == null) {
            singleton = new RetrofitUtil(RetrofitType.defaultType);
            if (!INSTANCE.compareAndSet(null, singleton)) {
                singleton = INSTANCE.get();
            }
        }
        return singleton;
    }

    public static final RetrofitUtil getDownloadInstance() {
        RetrofitUtil singleton = INSTANCE1.get();
        if (singleton == null) {
            singleton = new RetrofitUtil(RetrofitType.pgyerDownload);
            if (!INSTANCE1.compareAndSet(null, singleton)) {
                singleton = INSTANCE1.get();
            }
        }
        return singleton;
    }

    /**
     * @param retrofitType 参考{@link RetrofitType}
     */
    private RetrofitUtil(int retrofitType) {
        if (retrofitType == RetrofitType.pgyerDownload) {
            downloadRetrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BaseHttpUrl.URL_HEAD_PGYER)
                    .build();
        } else {
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.addInterceptor(new LoggingInterceptor());

            retrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BaseHttpUrl.URL_HEAD)
                    .build();
        }
    }

    public <T> T getRetrofitApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    public <T> T getDownloadRetrofitApi(Class<T> clazz) {
        return downloadRetrofit.create(clazz);
    }

    public void setObservable(Observable observable, Subscriber subscriber) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 请求网络数据
     *
     * @return 返回订阅对象，用于取消网络请求
     */
    public Subscriber requestHttpResponse(HttpRequest httpRequest, HttpCallback httpCallBack) {
        if (httpCallBack != null) {
            httpCallBack.onShowProgress(httpRequest.getIdentify());
        }
        Subscriber subscriber = getSubscription(httpRequest.getIdentify(), httpCallBack);
        setObservable(httpRequest.getObservable(), subscriber);
        return subscriber;
    }

    public Subscriber<ResponseBody> downloadFile(HttpRequest httpRequest, String saveDir, String fileName, HttpCallback httpCallBack) {
        if (httpCallBack != null) {
            httpCallBack.onShowProgress(httpRequest.getIdentify());
        }
        Subscriber<ResponseBody> subscriber = new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                LogUtils.e("下载.onCompleted：");
                if (httpCallBack != null) {
                    httpCallBack.onSuccess(httpRequest.getIdentify(), null);
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("下载.onError：" + e);
                if (httpCallBack != null) {
                    httpCallBack.onFailure(httpRequest.getIdentify(), e);
                }
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                LogUtils.e("下载.onNext：");
            }
        };
        httpRequest.getObservable()
                .subscribeOn(Schedulers.io())//subscribeOn和ObserOn必须在io线程
                .observeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        FileUtil.writeFileToSDCard(httpRequest.getIdentify(), responseBody, saveDir, fileName, httpCallBack);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        return subscriber;
    }

    /**
     * 网络数据返回
     */
    protected <T> Subscriber getSubscription(final String identify, final HttpCallback httpCallBack) {
        return new Subscriber<HttpResponse<T>>() {

            @Override
            public void onCompleted() {
                LogUtils.e("getSubscription===onCompleted");
                if (httpCallBack != null) {
                    httpCallBack.onDismissProgress(identify);
                }
                if (!this.isUnsubscribed()) {
                    this.unsubscribe();
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("getSubscription===onError：" + e.toString());
                if (httpCallBack != null) {
                    httpCallBack.onDismissProgress(identify);
                    WeakReference<String> weakClass = new WeakReference<>(identify);
                    HttpResponse httpResponse = new HttpResponse();
                    httpResponse.setMessage(e.toString());
                    httpCallBack.onFailure(weakClass.get(), httpResponse);
                }
                if (!this.isUnsubscribed()) {
                    this.unsubscribe();
                }
            }


            @Override
            public void onNext(HttpResponse<T> httpResponse) {
                LogUtils.e("getSubscription===onNext：" + httpResponse);
                String code = httpResponse.getCode();
                if (code != null) {
                    switch (code) {
                        case "0":
                            if (httpCallBack != null) {
                                httpCallBack.onDismissProgress(identify);
                                WeakReference<String> weakClass = new WeakReference<>(identify);
                                httpCallBack.onSuccess(weakClass.get(), httpResponse);
                            }
                            break;
                        case "1002"://登录过期
                        case "10050"://登录过期
                            EventBus.getDefault().post(new EventBusBean(EventBusBean.EventCode.LOGIN_EXPIRE));
                            if (httpCallBack != null) {
                                httpCallBack.onDismissProgress(identify);
                                httpCallBack.onTokenInvalid(httpResponse);
                            }
                            break;
//                        case "1004"://用户不存在
//                            if (httpCallBack != null) {
//                                httpCallBack.onDismissProgress();
//                                WeakReference<String> weakClass = new WeakReference<>(identify);
//                                httpCallBack.onFailure(weakClass.get(), httpResponse);
//                            }
//                            EventBus.getDefault().post(new MessageBean(MessageBean.MsgCode.TOKEN_INVALID));
//                            break;
                        default:
                            if (httpCallBack != null) {
                                httpCallBack.onDismissProgress(identify);
                                WeakReference<String> weakClass = new WeakReference<>(identify);
                                httpCallBack.onFailure(weakClass.get(), httpResponse);
                            }
                            break;
                    }
                }
            }
        };
    }

    class LoggingInterceptor implements Interceptor {
        @NonNull
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            LogUtils.e(TAG, String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            LogUtils.e(TAG, String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));


            ResponseBody body = response.body();
            if (body != null) {
                final String responseString = new String(body.bytes());
                LogUtils.e(TAG, "Response: " + responseString);
                return response.newBuilder()
                        .body(ResponseBody.create(body.contentType(), responseString))
                        .build();
            } else {
                return response;
            }
        }
    }
}