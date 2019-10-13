package com.yu.zz.retrofitapt.API;

import com.yu.zz.retrofitapt.Bean.CityBean;
import com.yu.zz.retrofitapt.Bean.CityWeatherBean;
import com.yu.zz.retrofitapt.Retrofit.DefualtConverter;
import com.yu.zz.retrofitapt.Retrofit.SpecialConvert;
import com.zz.yu.lib.ApiFactory;
import com.zz.yu.lib.ConverterInstance;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * step 3.2
 */
@ApiFactory(createCode = "com.yu.zz.retrofitapt.API.Api.getInstance().retrofit.create(<ClassName>.class)")
public interface WeatherService {

    /*------------------step 3.2-------------------*/
//    @GET("weather/city")
//    Observable<ArrayList<CityBean>> getAllCity();

//    @GET("weather/query")
//    Observable<CityWeatherBean> getCityWeatherService(@Query("city") String city, @Query("citycode") String citycode, @Query("cityid") String cityid);
    /*------------------step 3.2-------------------*/

    /*------------------step 7.4 始-------------------*/
    @ConverterInstance(DefualtConverter.class)
    @GET("weather/city")
    Observable<ArrayList<CityBean>> getAllCity();

    //
    @ConverterInstance(SpecialConvert.class)
    @GET("weather/query")
    Observable<CityWeatherBean> getCityWeatherService(@Query("city") String city, @Query("citycode") String citycode, @Query("cityid") String cityid);
    /*------------------step 7.4 终-------------------*/
}
