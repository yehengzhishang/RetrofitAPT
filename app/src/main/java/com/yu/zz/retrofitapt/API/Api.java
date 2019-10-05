package com.yu.zz.retrofitapt.API;

import com.yu.zz.retrofitapt.Retrofit.DefualtConverterFactory;
import com.yu.zz.retrofitapt.Z;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * step 3.3
 */

public class Api {

    /*rertfofi 所用本体*/
    private Retrofit retrofit;
    /*有关天气的接口*/
    private WeatherService weatherService;

    //单例
    private Api() {
        //okhttp 拦截器
        Interceptor mInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder()
                        .addHeader("Authorization", Z.APP_CPDE)
                        .build());
            }
        };

        //网络请求
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(DefualtConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Z.BASE_URL)
                .build();

        weatherService = retrofit.create(WeatherService.class);
    }

    public static Api getInstance() {
        return ApiHolder.INSTANCE;
    }

    //单例Holder
    private static class ApiHolder {
        private final static Api INSTANCE = new Api();
    }


}
