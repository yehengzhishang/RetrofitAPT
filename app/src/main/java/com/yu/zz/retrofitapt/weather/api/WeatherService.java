package com.yu.zz.retrofitapt.weather.api;

import com.yu.zz.retrofitapt.weather.bean.WeatherBaseBean;
import com.zz.yu.lib.ApiFactory;

import io.reactivex.Observable;

@ApiFactory(createCode = "com.yu.zz.retrofitapt.weather.api.WeatherApi.Companion.getRetrofit().create(<ClassName>.class)")
public interface WeatherService {
    Observable<WeatherBaseBean> address(String prov, String needDay, String city, String area);
}
