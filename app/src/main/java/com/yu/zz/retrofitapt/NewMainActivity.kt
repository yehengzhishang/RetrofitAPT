package com.yu.zz.retrofitapt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * step 1 新建一个project (加入联网权限，以及为Layout的设定)
 * <p>
 * step 2 gradle app 导入我们需要的三方数据
 * <p>
 * step 3 开始写网络请求(本次网络接口，用的阿里云的免费天气接口，为什么用这个，，，因为是免费的)
 * 3.1 写出实体bean [com.yu.zz.retrofitapt.weather.bean.WeatherBaseBean]
 * 3.2 写出Retrofit 所需interface [com.yu.zz.retrofitapt.weather.api.WeatherService]
 * 3.3 对于API 的封装 [WeatherApi]
 * <p>
 * step 4 已删除
 * <p>
 */
class NewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}