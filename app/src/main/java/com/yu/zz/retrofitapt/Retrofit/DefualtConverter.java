package com.yu.zz.retrofitapt.Retrofit;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * 解析格式
 * <p>
 * 正确数据
 * {
 * "status": "0",
 * "msg": "ok",
 * "result":{得到数据}
 * }
 */

    /*------------------step 4.1 始-------------------*/
//public final class DefualtConverter<T> implements Converter<ResponseBody, T> {
//
//    protected TypeAdapter<T> adapter;
//
//    public void setAdapter(TypeAdapter adapter) {
//        this.adapter = adapter;
//    }
//
//    @Override
//    public T convert(ResponseBody value) throws IOException {
//        Log.e("converter", "DefualtConverter");
//        String str_allData = value.string();
//        T bean = null;
//        try {
//            JSONObject allData = new JSONObject(str_allData);
//            String status = allData.optString("status");
//            String msg = allData.optString("msg");
//
//            if ("0".equals(status) && "ok".equals(msg)) {
//                Object mainData = allData.opt("result");
//                bean = adapter.fromJson(mainData.toString());
//            } else {
//                throw new RequestException(status, msg);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } finally {
//            value.close();
//        }
//        return bean;
//    }
//}
       /*------------------step 4.1 终-------------------*/

     /*------------------step 7.2 始-------------------*/
public final class DefualtConverter<T> extends AbstractConverter<T> {


    @Override
    public T convert(ResponseBody value) throws IOException {
        Log.e("converter", "DefualtConverter");
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
        /*------------------step 7.2 终-------------------*/
}
