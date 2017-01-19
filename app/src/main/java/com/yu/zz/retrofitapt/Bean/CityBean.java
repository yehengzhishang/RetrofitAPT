package com.yu.zz.retrofitapt.Bean;

/**
 *
 * step 3.1.1
 * 有关城市的实体
 * Created by zz on 2017/1/13.
 */

public class CityBean {

    /**
     * cityid : 1
     * parentid : 0
     * citycode : 101010100
     * city : 北京
     */

    private String cityid;
    private String parentid;
    private String citycode;
    private String city;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
