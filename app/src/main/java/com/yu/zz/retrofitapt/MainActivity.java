package com.yu.zz.retrofitapt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yu.zz.retrofitapt.weather.api.WeatherApi;


/**
 * step 1 新建一个project (加入联网权限，以及为Layout的设定)
 * <p>
 * step 2 gradle app 导入我们需要的三方数据
 * <p>
 * step 3 开始写网络请求(本次网络接口，用的阿里云的免费天气接口，为什么用这个，，，因为是免费的)
 * 3.1 写出实体bean {@link CityBean,com.yu.zz.retrofitapt.Bean.CityWeatherBean}
 * 3.2 写出rerforit 所需interface {@link com.yu.zz.retrofitapt.API.WeatherService}
 * 3.3 对于API 的封装 {@link com.yu.zz.retrofitapt.API.Api}
 * <p>
 * step 4 对于Converter第一次 代码设计
 * 4.1 通用的Converter {@link com.yu.zz.retrofitapt.Retrofit.DefualtConverter}
 * 4.2 ConverterFactory {@link com.yu.zz.retrofitapt.Retrofit.DefualtConverterFactory}
 * <p>
 * step 5 接口调试 （项目准备了两个接口，但是实际测试目前为止，只试过一个）
 * 5.1 recyclerview Adapter {@link CityAdapter}
 * 5.2 数据调试 {@link #getNetData()}
 * <p>
 * step 6. 加入apt ,生成ApiFactory
 * 6.1 新建 module :lib  新建注解 {@link com.zz.yu.lib.ApiFactory}
 * 6.2 新建 module :apt (要选择 java library ,并且对gradle :apt进行三方库的引入)
 * 6.3 apt 新建Processor (AnnotationProcessor) 代码设计 onApi()
 * 6.4 加入注解 {@link com.yu.zz.retrofitapt.API.WeatherService} ApiFactory
 * 代码替换 {@link #getNetData()}
 * <p>
 * step 7 利用Apt 生成 {@link com.apt.NewConverter}
 * 7.1 lib 新建注解 {@link com.zz.yu.lib.ConverterInstance}
 * 7.2  Converter更改 {@link com.yu.zz.retrofitapt.Retrofit.DefualtConverter}
 * 新增{@link com.yu.zz.retrofitapt.Retrofit.AbstractConverter}
 * 新增 apt AnnotationProcessor 中加入 onConverter()
 * 7.3 {@link WeatherService#getAllCity()} 加入注解
 * 7.4 更改 {@link com.yu.zz.retrofitapt.Retrofit.DefualtConverterFactory } 逻辑
 */
public class MainActivity extends AppCompatActivity {
    //用来显示数据
    private RecyclerView rcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherApi weatherApi;
        setContentView(R.layout.activity_main);
        //view 初始化设置
        rcl = findViewById(R.id.rcl);
        rcl.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //测试接口
        getNetData();
    }

    //网络请求 感觉是接口原因，得到数据比较慢
    private void getNetData() {
        /*------------------step 5.2 始-------------------*/
//        Api.getInstance().weatherService.getAllCity()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<ArrayList<CityBean>>() {
//                    @Override
//                    public void call(ArrayList<CityBean> cityBeen) {
//                        CityAdapter adpter = new CityAdapter(MainActivity.this, cityBeen);
//                        rcl.setAdapter(adpter);
//                    }
//                });
        /*------------------step 5.2 终-------------------*/
        /*------------------step 6.4 始-------------------*/
        /*------------------step 6.4 终-------------------*/
    }

}
