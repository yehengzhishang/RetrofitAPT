package com.yu.zz.retrofitapt.weather.bean;


public class WeatherBaseBean {
    private String ret;

    public static class CityBean {
        /**
         * provinces : 浙江
         * city : 杭州
         * area : 西湖
         * id : 101210113
         * prov_py : zhejiang
         * city_py : hangzhou
         * qh : 0571
         * jb : 3
         * yb : 310000
         * area_py : xihu
         * area_short_code : xh
         * lng : 120.12979
         * lat : 30.25949
         */
        private String provinces;
        private String city;
        private String area;
        private String id;
        private String prov_py;
        private String city_py;
        private String qh;
        private String jb;
        private String yb;
        private String area_py;
        private String area_short_code;
        private String lng;
        private String lat;

        public String getProvinces() {
            return provinces;
        }

        public void setProvinces(String provinces) {
            this.provinces = provinces;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProv_py() {
            return prov_py;
        }

        public void setProv_py(String prov_py) {
            this.prov_py = prov_py;
        }

        public String getCity_py() {
            return city_py;
        }

        public void setCity_py(String city_py) {
            this.city_py = city_py;
        }

        public String getQh() {
            return qh;
        }

        public void setQh(String qh) {
            this.qh = qh;
        }

        public String getJb() {
            return jb;
        }

        public void setJb(String jb) {
            this.jb = jb;
        }

        public String getYb() {
            return yb;
        }

        public void setYb(String yb) {
            this.yb = yb;
        }

        public String getArea_py() {
            return area_py;
        }

        public void setArea_py(String area_py) {
            this.area_py = area_py;
        }

        public String getArea_short_code() {
            return area_short_code;
        }

        public void setArea_short_code(String area_short_code) {
            this.area_short_code = area_short_code;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }
}
