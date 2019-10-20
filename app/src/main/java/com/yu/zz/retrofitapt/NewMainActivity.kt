package com.yu.zz.retrofitapt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.apt.WeatherServiceApiFactory
import com.google.gson.GsonBuilder
import com.yu.zz.retrofitapt.weather.api.WeatherApi
import com.yu.zz.retrofitapt.weather.api.WeatherService
import com.yu.zz.retrofitapt.weather.bean.WeatherBaseBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


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
 * step 5 接口请求测试 [request]
 * <p>
 * step 6. 加入apt ,生成ApiFactory
 * 6.1 新建 module :lib  新建注解 {@link com.zz.yu.lib.ApiFactory}
 * 6.2 新建 module :apt (要选择 java library ,并且对gradle :apt进行三方库的引入)
 * 6.3 apt 新建Processor (AnnotationProcessor) 代码设计 onApi()
 * 6.4 引入 kapt lib apt
 * 6.5 加入注解 [WeatherService] ApiFactory
 * 代码替换 [request]
 */
class NewMainActivity : AppCompatActivity() {
    private val mDataContent = MutableLiveData<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        btnCity.setOnClickListener { request() }
    }

    /*------------------step 5 start -------------------*/
    private fun request() {
        /*------------------step 6.5 start -------------------*/
//        WeatherApi.retrofit.create(WeatherService::class.java)
        WeatherServiceApiFactory
                /*------------------step 6.5 end -------------------*/
                .address("西湖", "杭州", "1", "浙江")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<WeatherBaseBean>() {
                    override fun onNext(bean: WeatherBaseBean) {
                        mDataContent.value = GsonBuilder().setPrettyPrinting().create().toJson(bean)
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        if (!isDisposed) {
                            dispose()
                        }
                    }
                })
    }

    private fun bind() {
        mDataContent.observe(this, Observer {
            tvContent.text = it
        })
    }
    /*------------------step 5 end -------------------*/
}