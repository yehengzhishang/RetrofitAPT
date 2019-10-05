package com.yu.zz.retrofitapt.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.zz.yu.lib.ConverterInstance;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 设计模式，总体上模仿{@link retrofit2.converter.gson.GsonConverterFactory}
 */
public class DefualtConverterFactory extends Converter.Factory {

    private Gson gson;

    private DefualtConverterFactory() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").serializeNulls().create();

    }

    public static DefualtConverterFactory create() {
        return new DefualtConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                            Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        AbstractConverter<?> converter = null;

              /*------------------step 4.2 始-------------------*/
//        DefualtConverter converter = new DefualtConverter();
//        converter.setAdapter(adapter);
              /*------------------step 4.2 终-------------------*/


              /*------------------step 7.4 始-------------------*/
        //找到方法中的所有注解，找到我们自定义的ConverterInstance
        for (Annotation a : annotations) {
            if (a instanceof ConverterInstance) {
                Class c = ((ConverterInstance) a).value();
//                converter = NewConverter.create(c);
                break;
            }
        }
        //如果没有标明用什么Converter ,生成默认的Converter
        if (null == converter)
            converter = new DefualtConverter();
        converter.setAdapter(adapter);
            /*------------------step 7.4 终-------------------*/
        return converter;
    }

}
