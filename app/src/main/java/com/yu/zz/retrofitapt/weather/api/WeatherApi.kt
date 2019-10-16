package com.yu.zz.retrofitapt.weather.api

import com.yu.zz.retrofitapt.Retrofit.DefualtConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import java.io.IOException

class WeatherApi {
    //okHttp 拦截器
    private val mInterceptor = object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(chain.request().newBuilder()
                    .addHeader("Authorization", "APPCODE e2147361ac1343fbb9096e7ca8481612")
                    .build())
        }
    }
    private val mOkHttpClient = OkHttpClient.Builder()
            .addInterceptor(mInterceptor)
            .build()
    val retrofit: Retrofit = Retrofit.Builder()
            .client(mOkHttpClient)
            .addConverterFactory(DefualtConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl("https://iweather.market.alicloudapi.com/")
            .build()
}