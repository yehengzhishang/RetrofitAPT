package com.yu.zz.retrofitapt.Retrofit;

/**
 * Created by zz on 2017/1/13.
 */

public class RequestException extends RuntimeException {

    private String status;

    private String msg;


    public RequestException(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
