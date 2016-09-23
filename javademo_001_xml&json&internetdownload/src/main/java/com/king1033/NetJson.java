package com.king1033;

import java.io.IOException;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import net.sf.json.JSONObject;

public class NetJson {
    public static final String URL_JSON = "http://weather.123.duba.net/static/weather_info/101200101.html";

    public static TodayWeather parseJson(String jsonString) {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);

        String data = jsonObject.getString("date_y");
        String weather = jsonObject.getString("weather1");
        String wind = jsonObject.getString("wind1");
        String temp = jsonObject.getString("temp1");

        TodayWeather translator = new TodayWeather(data, weather, wind, temp);

        return translator;

    }

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(URL_JSON).build();

        client.newCall(request).enqueue(new Callback() {

            public void onResponse(Response response) throws IOException {
                System.out.println("网络访问成功");

                String result = response.body().string();

                //去除Json解析时出现的干扰部分
                result = result.substring(result.indexOf("{\"city_en"), result.indexOf(",\"update_time\""));

                System.out.println(result);
                TodayWeather translator = parseJson(result);
                System.out.println("日期：" + translator.getData());
                System.out.println("天气：" + translator.getWeather());
                System.out.println("风向：" + translator.getWind());
                System.out.println("温度：" + translator.getTemp());
            }

            public void onFailure(Request request, IOException exception) {
                System.out.print("网络访问失败");
            }
        });

    }
}
