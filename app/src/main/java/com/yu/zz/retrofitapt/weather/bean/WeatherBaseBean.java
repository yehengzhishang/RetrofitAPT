package com.yu.zz.retrofitapt.weather.bean;


import com.google.gson.annotations.SerializedName;

public class WeatherBaseBean {
    private String ret;
    // 感觉像是相应时间
    private float qt;

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
        @SerializedName("provinces")
        public String provinces;
        public String city;
        public String area;
        public String id;
        public String prov_py;
        public String city_py;
        public String qh;
        public String jb;
        public String yb;
        public String area_py;
        public String area_short_code;
        public String lng;
        public String lat;
    }

    public static class NowBean {
        @SerializedName(value = "id")
        public String id;
        @SerializedName(value = "area_name")
        public String areaName;
        @SerializedName(value = "city")
        public CityWeatherBean cityWeather;
        @SerializedName("detail")
        public CityWeatherBean cityWeatherBean;
    }

    public static class CityWeatherBean {
        @SerializedName(value = "night_air_temperature")
        public String nightAirTemperature;
        @SerializedName(value = "day_air_temperature")
        public String dayAirTemperature;
        @SerializedName(value = "wind_direction")
        public String windDirection;
        @SerializedName(value = "wind_power")
        public String windPower;
        @SerializedName(value = "weather")
        public String weather;
        @SerializedName(value = "update_time")
        public long updateTime;
    }

    public static class DetailBean {
        @SerializedName("time")
        public String time;
        @SerializedName("date")
        public String date;
        @SerializedName("week")
        public String week;
        @SerializedName("temperature")
        public String temperature;
        @SerializedName("wind_direction")
        public String windDirection;
        @SerializedName("wind_direction_str")
        public String windDirectionStr;
        @SerializedName("wind_power")
        public String windPower;
        @SerializedName("humidity")
        public String humidity;
        @SerializedName("weather")
        public String weather;
        @SerializedName("weather_english")
        public String weatherEnglish;
        @SerializedName("qy")
        public String qy;
        @SerializedName("njd")
        public String njd;
        @SerializedName("rain")
        public String rain;
        @SerializedName("aqi")
        public String aqi;
        @SerializedName("quality")
        public String quality;
        @SerializedName("aqi_pm25")
        public String aqiPm25;
        @SerializedName("nongli")
        public String nongli;
        @SerializedName("sun_begin")
        public String sun_begin;
        @SerializedName("sun_end")
        public String sun_end;
    }
}

//{
//    "ret": 200,
//    "data": {
//        "cityinfo": {
//            "provinces": "浙江",
//            "city": "杭州",
//            "area": "西湖",
//            "id": "101210113",
//            "prov_py": "zhejiang",
//            "city_py": "hangzhou",
//            "qh": "0571",
//            "jb": "3",
//            "yb": "310000",
//            "area_py": "xihu",
//            "area_short_code": "xh",
//            "lng": "120.12979",
//            "lat": "30.25949"
//        },
//        "now": {
//            "id": "101210113",
//            "area_name": "西湖",
//            "city": {
//                "night_air_temperature": "16",
//                "day_air_temperature": "21",
//                "wind_direction": "南风转西风",
//                "wind_power": "<3级转3-4级",
//                "weather": "多云"
//            },
//            "detail": {
//                "time": "20:35",
//                "date": "10月16日",
//                "week": "三",
//                "temperature": "17",
//                "wind_direction": "北风",
//                "wind_direction_str": "N",
//                "wind_power": "1级",
//                "wind_speed": "<12km/h",
//                "humidity": "64%",
//                "weather": "阴",
//                "weather_english": "Overcast",
//                "qy": "1019",
//                "njd": "11.49km",
//                "rain": "0.0",
//                "aqi": "75",
//                "quality": "良",
//                "aqi_pm25": "",
//                "nongli": "九月十八",
//                "sun_begin": "06:01",
//                "sun_end": "17:28"
//            },
//            "update_time": 1571230880
//        }
//    },
//    "qt": 0.021
//}


//{
//    "ret": 200,
//    "data": {
//        "cityinfo": {
//            "provinces": "浙江",
//            "city": "杭州",
//            "area": "西湖",
//            "id": "101210113",
//            "prov_py": "zhejiang",
//            "city_py": "hangzhou",
//            "qh": "0571",
//            "jb": "3",
//            "yb": "310000",
//            "area_py": "xihu",
//            "area_short_code": "xh",
//            "lng": "120.12979",
//            "lat": "30.25949"
//        },
//        "day7": [
//            {
//                "date": "20191016",
//                "week": "三",
//                "nongli": "九月十八",
//                "day_air_weather": "多云",
//                "night_air_weather": "多云",
//                "day_air_temperature": "21",
//                "night_air_temperature": "16",
//                "day_wind_power": "<3级",
//                "night_wind_power": "3-4级",
//                "day_wind_direction": "南风",
//                "night_wind_direction": "西风",
//                "sun_begin": "06:01",
//                "sun_end": "17:28",
//                "day_weather_pic": "/day/01.png",
//                "night_weather_pic": "/night/01.png",
//                "aqi": "75",
//                "quality": "良",
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "较适宜",
//                        "desc": "早晨气象条件较适宜晨练，但风力稍大，晨练时请注意选择避风的地点，避免迎风锻炼。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "较舒适",
//                        "desc": "白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "较舒适",
//                        "desc": "建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "较适宜",
//                        "desc": "较适合垂钓，但风力稍大，会对垂钓产生一定的影响。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "较弱",
//                        "desc": "紫外线强度较弱，建议涂擦SPF在12-15之间，PA+的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，在这种天气里去逛街，既可畅快地放松身心，又会有很多意外收获，真是无比惬意。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "较适宜",
//                        "desc": "白天较适宜划船，但较大的风力会对划船产生一定的影响。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "天气较好，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "适宜",
//                        "desc": "天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "适宜",
//                        "desc": "气温适宜，但风力较大，这会导致空气中漂浮的尘埃增加，容易弄脏头发，请注意保持头发的清洁，并坚持使用润发露，有效防止头发干燥。　"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，虽然有点风，但仍比较适宜夜生活，您可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "较适宜",
//                        "desc": "温暖舒适，较适宜放风筝。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "良",
//                        "desc": "气象条件有利于空气污染物稀释、扩散和清除。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "弱",
//                        "desc": "紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "较好",
//                        "desc": "天气较好，温度适宜，心情会不错，学习、工作效率较高。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然有点风，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "天气较好，不会降水，因此您可放心出门，无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气不热，在炎炎夏日中十分难得，可以告别暑气漫漫啦~"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "较易波动",
//                        "desc": "血糖较易波动，注意监测。"
//                    }
//                }
//            },
//            {
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "较适宜",
//                        "desc": "早晨气象条件较适宜晨练，但天气阴沉，风力稍大，请选择合适的地点晨练。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "较舒适",
//                        "desc": "白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "较舒适",
//                        "desc": "建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "不宜",
//                        "desc": "天气不好，有风，不适合垂钓。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "弱",
//                        "desc": "属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "较适宜",
//                        "desc": "阴天，较适宜逛街的，穿上吸汗透气的衣服就可以放心出门了。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "较适宜",
//                        "desc": "白天较适宜划船，但阴沉的天气和较大的风力，会对划船产生一定的影响。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "阴天，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "阴天，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "不太适宜",
//                        "desc": "天气阴沉，不利于水分的迅速蒸发，不太适宜晾晒。若需要晾晒，请尽量选择通风的地点。"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "适宜",
//                        "desc": "气温适宜，但风力较大，这会导致空气中漂浮的尘埃增加，容易弄脏头发，请注意保持头发的清洁，并坚持使用润发露，有效防止头发干燥。　"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "虽然是阴天，有点风，但仍比较适宜夜生活，只要您稍作准备就可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "不宜",
//                        "desc": "天气不好，不适宜放风筝。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "良",
//                        "desc": "气象条件有利于空气污染物稀释、扩散和清除。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，风稍大，但温度适宜，总体来说还是好天气。这样的天气适宜旅游，您可以尽情享受大自然的风光。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "最弱",
//                        "desc": "属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "较差",
//                        "desc": "天气阴沉，会感觉莫名的压抑，情绪低落，此时将所有的悲喜都静静地沉到心底，在喧嚣的尘世里，感受片刻恬淡的宁静。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "较不宜",
//                        "desc": "有降水，且风力较强，气压较低，推荐您在室内进行低强度运动；若坚持户外运动，须注意避雨防风。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然天空有些阴沉，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "阴天，但降水概率很低，因此您在出门的时候无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气舒适，对易中暑人群来说非常友善。"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天天空阴沉，但太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "易波动",
//                        "desc": "血糖易波动，注意监测。"
//                    }
//                },
//                "date": "20191017",
//                "week": "四",
//                "nongli": "九月十九",
//                "day_air_weather": "阴",
//                "night_air_weather": "阴",
//                "day_air_temperature": "21",
//                "night_air_temperature": "15",
//                "day_wind_power": "3-4级",
//                "night_wind_power": "<3级",
//                "day_wind_direction": "微风",
//                "night_wind_direction": "微风",
//                "sun_begin": "06:02",
//                "sun_end": "17:27",
//                "day_weather_pic": "/day/02.png",
//                "night_weather_pic": "/night/02.png",
//                "aqi": "71",
//                "quality": "良"
//            },
//            {
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "较适宜",
//                        "desc": "早晨气象条件较适宜晨练，但风力稍大，晨练时请注意选择避风的地点，避免迎风锻炼。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "较舒适",
//                        "desc": "白天天气晴好，早晚会感觉偏凉，午后舒适、宜人。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "较舒适",
//                        "desc": "建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "较适宜",
//                        "desc": "较适合垂钓，但风力稍大，会对垂钓产生一定的影响。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "较弱",
//                        "desc": "紫外线强度较弱，建议涂擦SPF在12-15之间，PA+的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，在这种天气里去逛街，既可畅快地放松身心，又会有很多意外收获，真是无比惬意。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "较适宜",
//                        "desc": "白天较适宜划船，但较大的风力会对划船产生一定的影响。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "天气较好，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "适宜",
//                        "desc": "天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "适宜",
//                        "desc": "气温适宜，但风力较大，这会导致空气中漂浮的尘埃增加，容易弄脏头发，请注意保持头发的清洁，并坚持使用润发露，有效防止头发干燥。　"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，虽然有点风，但仍比较适宜夜生活，您可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "较适宜",
//                        "desc": "温暖舒适，较适宜放风筝。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "良",
//                        "desc": "气象条件有利于空气污染物稀释、扩散和清除。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "弱",
//                        "desc": "紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "较好",
//                        "desc": "天气较好，温度适宜，心情会不错，学习、工作效率较高。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然有点风，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "天气较好，不会降水，因此您可放心出门，无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气舒适，对易中暑人群来说非常友善。"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "易波动",
//                        "desc": "血糖易波动，注意监测。"
//                    }
//                },
//                "date": "20191018",
//                "week": "五",
//                "nongli": "九月二十",
//                "day_air_weather": "多云",
//                "night_air_weather": "晴",
//                "day_air_temperature": "21",
//                "night_air_temperature": "13",
//                "day_wind_power": "3-4级",
//                "night_wind_power": "<3级",
//                "day_wind_direction": "微风",
//                "night_wind_direction": "微风",
//                "sun_begin": "06:03",
//                "sun_end": "17:26",
//                "day_weather_pic": "/day/01.png",
//                "night_weather_pic": "/night/00.png",
//                "aqi": "73",
//                "quality": "良"
//            },
//            {
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "较适宜",
//                        "desc": "早晨气象条件较适宜晨练，但风力稍大，晨练时请注意选择避风的地点，避免迎风锻炼。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "舒适",
//                        "desc": "白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "较舒适",
//                        "desc": "建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "较适宜",
//                        "desc": "较适合垂钓，但风力稍大，会对垂钓产生一定的影响。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "中等",
//                        "desc": "属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，在这种天气里去逛街，既可畅快地放松身心，又会有很多意外收获，真是无比惬意。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "较适宜",
//                        "desc": "白天较适宜划船，但较大的风力会对划船产生一定的影响。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "天气较好，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "适宜",
//                        "desc": "天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "适宜",
//                        "desc": "风大，头发不仅需要保持清洁，还要注意防晒，含防晒和滋润成分洗发护发品都是很好的选择。"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，虽然有点风，比较适宜夜生活，您可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "适宜",
//                        "desc": "天气不错，这种天气去放风筝既可以舒展筋骨，又可放松身心，超然自逸于广袤的天地之间。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "良",
//                        "desc": "气象条件有利于空气污染物稀释、扩散和清除。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "中等",
//                        "desc": "属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "好",
//                        "desc": "天气较好，空气温润，和风飘飘，美好的天气会带来一天接踵而来的好心情。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然有点风，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "天气较好，您在出门的时候无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气不热，在炎炎夏日中十分难得，可以告别暑气漫漫啦~"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天天气晴朗，太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的遮阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "较易波动",
//                        "desc": "血糖较易波动，注意监测。"
//                    }
//                },
//                "date": "20191019",
//                "week": "六",
//                "nongli": "九月廿一",
//                "day_air_weather": "晴",
//                "night_air_weather": "晴",
//                "day_air_temperature": "23",
//                "night_air_temperature": "12",
//                "day_wind_power": "3-4级",
//                "night_wind_power": "<3级",
//                "day_wind_direction": "东北风",
//                "night_wind_direction": "微风",
//                "sun_begin": "06:03",
//                "sun_end": "17:25",
//                "day_weather_pic": "/day/00.png",
//                "night_weather_pic": "/night/00.png",
//                "aqi": "98",
//                "quality": "良"
//            },
//            {
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "较适宜",
//                        "desc": "早晨气象条件较适宜晨练，但风力稍大，晨练时请注意选择避风的地点，避免迎风锻炼。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "舒适",
//                        "desc": "白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "较舒适",
//                        "desc": "建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "较适宜",
//                        "desc": "较适合垂钓，但风力稍大，会对垂钓产生一定的影响。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "较弱",
//                        "desc": "紫外线强度较弱，建议涂擦SPF在12-15之间，PA+的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，在这种天气里去逛街，既可畅快地放松身心，又会有很多意外收获，真是无比惬意。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "较适宜",
//                        "desc": "白天较适宜划船，但较大的风力会对划船产生一定的影响。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "天气较好，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "适宜",
//                        "desc": "天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "适宜",
//                        "desc": "气温适宜，但风力较大，这会导致空气中漂浮的尘埃增加，容易弄脏头发，请注意保持头发的清洁，并坚持使用润发露，有效防止头发干燥。　"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，虽然有点风，但仍比较适宜夜生活，您可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "较适宜",
//                        "desc": "温暖舒适，较适宜放风筝。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "良",
//                        "desc": "气象条件有利于空气污染物稀释、扩散和清除。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "弱",
//                        "desc": "紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "较好",
//                        "desc": "天气较好，温度适宜，心情会不错，学习、工作效率较高。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然有点风，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "天气较好，不会降水，因此您可放心出门，无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气舒适，对易中暑人群来说非常友善。"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "较易波动",
//                        "desc": "血糖较易波动，注意监测。"
//                    }
//                },
//                "date": "20191020",
//                "week": "日",
//                "nongli": "九月廿二",
//                "day_air_weather": "多云",
//                "night_air_weather": "多云",
//                "day_air_temperature": "23",
//                "night_air_temperature": "12",
//                "day_wind_power": "3-4级",
//                "night_wind_power": "<3级",
//                "day_wind_direction": "东风",
//                "night_wind_direction": "微风",
//                "sun_begin": "06:04",
//                "sun_end": "17:24",
//                "day_weather_pic": "/day/01.png",
//                "night_weather_pic": "/night/01.png",
//                "aqi": "93",
//                "quality": "良"
//            },
//            {
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "适宜",
//                        "desc": "天气不错，空气清新，是您晨练的大好时机，建议不同年龄段的人们积极参加户外健身活动。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "舒适",
//                        "desc": "白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "舒适",
//                        "desc": "建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "较适宜",
//                        "desc": "较适合垂钓，但风力稍大，会对垂钓产生一定的影响。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "较弱",
//                        "desc": "紫外线强度较弱，建议涂擦SPF在12-15之间，PA+的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "适宜",
//                        "desc": "天气较好，在这种天气里去逛街，既可畅快地放松身心，又会有很多意外收获，真是无比惬意。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "适宜",
//                        "desc": "白天天气较好，适宜划船或嬉玩各种水上运动。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "天气较好，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "适宜",
//                        "desc": "天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "极适宜",
//                        "desc": "温湿适宜，风力较小，这为您的头发创造一个健康、洁净的生长环境，加上您细心的呵护打理，您的秀发定能飘逸动人。"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "天气较好，虽然有点风，但仍比较适宜夜生活，您可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "较适宜",
//                        "desc": "温暖舒适，较适宜放风筝。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "中",
//                        "desc": "气象条件对空气污染物稀释、扩散和清除无明显影响。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "弱",
//                        "desc": "紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "较好",
//                        "desc": "天气较好，温度适宜，心情会不错，学习、工作效率较高。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "适宜",
//                        "desc": "天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然有点风，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "天气较好，不会降水，因此您可放心出门，无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气不热，在炎炎夏日中十分难得，可以告别暑气漫漫啦~"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "较易波动",
//                        "desc": "血糖较易波动，注意监测。"
//                    }
//                },
//                "date": "20191021",
//                "week": "一",
//                "nongli": "九月廿三",
//                "day_air_weather": "多云",
//                "night_air_weather": "阴",
//                "day_air_temperature": "23",
//                "night_air_temperature": "14",
//                "day_wind_power": "<3级",
//                "night_wind_power": "<3级",
//                "day_wind_direction": "微风",
//                "night_wind_direction": "微风",
//                "sun_begin": "06:05",
//                "sun_end": "17:23",
//                "day_weather_pic": "/day/01.png",
//                "night_weather_pic": "/night/02.png",
//                "aqi": "",
//                "quality": ""
//            },
//            {
//                "live": {
//                    "ac": {
//                        "name": "空调开启指数",
//                        "title": "较少开启",
//                        "desc": "您将感到很舒适，一般不需要开启空调。"
//                    },
//                    "ag": {
//                        "name": "过敏指数",
//                        "title": "较易发",
//                        "desc": "天气条件较易诱发过敏，外出宜穿长衣长裤，远离过敏源，适当佩戴眼镜和口罩。"
//                    },
//                    "cl": {
//                        "name": "晨练指数",
//                        "title": "较适宜",
//                        "desc": "早晨气象条件较适宜晨练，但天气阴沉，风力稍大，请选择合适的地点晨练。"
//                    },
//                    "co": {
//                        "name": "舒适度指数",
//                        "title": "舒适",
//                        "desc": "白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"
//                    },
//                    "ct": {
//                        "name": "穿衣指数",
//                        "title": "较舒适",
//                        "desc": "建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"
//                    },
//                    "dy": {
//                        "name": "钓鱼指数",
//                        "title": "不宜",
//                        "desc": "天气不好，有风，不适合垂钓。"
//                    },
//                    "fs": {
//                        "name": "防晒指数",
//                        "title": "弱",
//                        "desc": "属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"
//                    },
//                    "gj": {
//                        "name": "逛街指数",
//                        "title": "较适宜",
//                        "desc": "阴天，较适宜逛街的，穿上吸汗透气的衣服就可以放心出门了。"
//                    },
//                    "gm": {
//                        "name": "感冒指数",
//                        "title": "少发",
//                        "desc": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
//                    },
//                    "hc": {
//                        "name": "划船指数",
//                        "title": "较适宜",
//                        "desc": "白天较适宜划船，但阴沉的天气和较大的风力，会对划船产生一定的影响。"
//                    },
//                    "jt": {
//                        "name": "交通指数",
//                        "title": "良好",
//                        "desc": "阴天，路面干燥，交通气象条件良好，车辆可以正常行驶。"
//                    },
//                    "lk": {
//                        "name": "路况指数",
//                        "title": "干燥",
//                        "desc": "阴天，路面比较干燥，路况较好。"
//                    },
//                    "ls": {
//                        "name": "晾晒指数",
//                        "title": "不太适宜",
//                        "desc": "天气阴沉，不利于水分的迅速蒸发，不太适宜晾晒。若需要晾晒，请尽量选择通风的地点。"
//                    },
//                    "mf": {
//                        "name": "美发指数",
//                        "title": "适宜",
//                        "desc": "气温适宜，但风力较大，这会导致空气中漂浮的尘埃增加，容易弄脏头发，请注意保持头发的清洁，并坚持使用润发露，有效防止头发干燥。　"
//                    },
//                    "nl": {
//                        "name": "夜生活指数",
//                        "title": "较适宜",
//                        "desc": "虽然是阴天，有点风，但仍比较适宜夜生活，只要您稍作准备就可以放心外出。"
//                    },
//                    "pj": {
//                        "name": "啤酒指数",
//                        "title": "较适宜",
//                        "desc": "适量的饮用啤酒可能会更增加您舒适的感觉，但要注意千万不要过量呦。"
//                    },
//                    "pk": {
//                        "name": "放风筝指数",
//                        "title": "不宜",
//                        "desc": "天气不好，不适宜放风筝。"
//                    },
//                    "pl": {
//                        "name": "空气污染扩散条件指数",
//                        "title": "良",
//                        "desc": "气象条件有利于空气污染物稀释、扩散和清除。"
//                    },
//                    "pp": {
//                        "name": "化妆指数",
//                        "title": "保湿",
//                        "desc": "风力不大，建议用中性保湿型霜类化妆品，无需选用防晒化妆品。"
//                    },
//                    "tr": {
//                        "name": "旅游指数",
//                        "title": "适宜",
//                        "desc": "天气较好，风稍大，但温度适宜，总体来说还是好天气。这样的天气适宜旅游，您可以尽情享受大自然的风光。"
//                    },
//                    "uv": {
//                        "name": "紫外线强度指数",
//                        "title": "最弱",
//                        "desc": "属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"
//                    },
//                    "wc": {
//                        "name": "风寒指数",
//                        "title": "无",
//                        "desc": "温度未达到风寒所需的低温，稍作防寒准备即可。"
//                    },
//                    "xc": {
//                        "name": "洗车指数",
//                        "title": "适宜",
//                        "desc": "适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。"
//                    },
//                    "xq": {
//                        "name": "心情指数",
//                        "title": "较差",
//                        "desc": "天气阴沉，会感觉莫名的压抑，情绪低落，此时将所有的悲喜都静静地沉到心底，在喧嚣的尘世里，感受片刻恬淡的宁静。"
//                    },
//                    "yd": {
//                        "name": "运动指数",
//                        "title": "较不宜",
//                        "desc": "有降水，且风力较强，气压较低，推荐您在室内进行低强度运动；若坚持户外运动，须注意避雨防风。"
//                    },
//                    "yh": {
//                        "name": "约会指数",
//                        "title": "较适宜",
//                        "desc": "虽然天空有些阴沉，但情侣们可以放心外出，不用担心天气来调皮捣乱而影响了兴致。"
//                    },
//                    "ys": {
//                        "name": "雨伞指数",
//                        "title": "不带伞",
//                        "desc": "阴天，但降水概率很低，因此您在出门的时候无须带雨伞。"
//                    },
//                    "zs": {
//                        "name": "中暑指数",
//                        "title": "无中暑风险",
//                        "desc": "天气舒适，对易中暑人群来说非常友善。"
//                    },
//                    "gl": {
//                        "name": "太阳镜指数",
//                        "title": "必要",
//                        "desc": "白天天空阴沉，但太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜"
//                    },
//                    "rw": {
//                        "name": "减肥气象指数",
//                        "title": "null",
//                        "desc": "null"
//                    },
//                    "bl": {
//                        "name": "健臻·血糖指数",
//                        "title": "较易波动",
//                        "desc": "血糖较易波动，注意监测。"
//                    }
//                },
//                "date": "20191022",
//                "week": "二",
//                "nongli": "九月廿四",
//                "day_air_weather": "阴",
//                "night_air_weather": "阴",
//                "day_air_temperature": "23",
//                "night_air_temperature": "16",
//                "day_wind_power": "3-4级",
//                "night_wind_power": "<3级",
//                "day_wind_direction": "东风",
//                "night_wind_direction": "微风",
//                "sun_begin": "06:05",
//                "sun_end": "17:22",
//                "day_weather_pic": "/day/02.png",
//                "night_weather_pic": "/night/02.png",
//                "aqi": "",
//                "quality": ""
//            }
//        ]
//    },
//    "qt": 0.023
//}
