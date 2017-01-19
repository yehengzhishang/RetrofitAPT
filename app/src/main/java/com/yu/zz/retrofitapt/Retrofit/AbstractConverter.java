package com.yu.zz.retrofitapt.Retrofit;

import com.google.gson.TypeAdapter;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Converter抽象类，
 * 方便做一些处理
 * 比如apt中的return 的类别
 * setAdapter中调用（为啥不在构造方法中加入adapter参数。。。。因为。apt不好写）
 */
public abstract class AbstractConverter<T> implements Converter<ResponseBody, T> {

    protected TypeAdapter<T> adapter;

    public AbstractConverter() {

    }

    public void setAdapter(TypeAdapter adapter) {
        this.adapter = adapter;
    }
}
