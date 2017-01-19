package com.yu.zz.retrofitapt.Retrofit;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * 当前解析过程与{@link DefualtConverter}无区别
 * 只是用来测试，解析中的Log输出不一样，方便测试
 */
public final class SpecialConvert<T> extends AbstractConverter<T> {

    @Override
    public T convert(ResponseBody value) throws IOException {
        Log.e("converter", "SpecialConvert");
        String str_allData = value.string();
        T bean = null;
        try {
            JSONObject allData = new JSONObject(str_allData);
            String status = allData.optString("status");
            String msg = allData.optString("msg");

            if ("0".equals(status) && "ok".equals(msg)) {
                Object mainData = allData.opt("result");
                bean = adapter.fromJson(mainData.toString());
            } else {
                throw new RequestException(status, msg);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            value.close();
        }
        return bean;
    }
}
