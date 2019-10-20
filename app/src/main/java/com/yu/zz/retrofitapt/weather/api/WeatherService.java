package com.yu.zz.retrofitapt.weather.api;

import com.yu.zz.retrofitapt.weather.bean.WeatherBaseBean;
import com.zz.yu.lib.ApiFactory;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@ApiFactory(createCode = "com.yu.zz.retrofitapt.weather.api.WeatherApi.Companion.getRetrofit().create(<ClassName>.class)")
public interface WeatherService {
    @GET("address")
    Observable<WeatherBaseBean> address(@Query("area") String area, @Query("city") String city, @Query("needday") String needDay, @Query("prov") String prov);
}
