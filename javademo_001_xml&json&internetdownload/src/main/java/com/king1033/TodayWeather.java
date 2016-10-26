package com.king1033;

/**
 * @Author:king1033
 * @Desc:
 * 创建TodayWeather实体类
 * @Time:2016/9/23
 *
 * 创建TodayWeather实体类，需要：
 * 1、构造TodayWeather函数
 * 2、实现get（）与set（）方法
 * 3、实现equals（）与hashCode（）方法
 * 4、实现toString（）方法
 */
public class TodayWeather {
    private String data;
    private String weather;
    private String wind;
    private String temp;

    //构造TodayWeather函数
    public TodayWeather(String data, String weather, String wind, String temp) {
        this.data = data;
        this.weather = weather;
        this.wind = wind;
        this.temp = temp;
    }

    //创建GET与SET方法
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    //toString()
    @Override
    public String toString() {
        return "TodayWeather{" +
                "data='" + data + '\'' +
                ", weather='" + weather + '\'' +
                ", wind='" + wind + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }

    //equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodayWeather that = (TodayWeather) o;

        if (!data.equals(that.data)) return false;
        if (!weather.equals(that.weather)) return false;
        if (!wind.equals(that.wind)) return false;
        return temp.equals(that.temp);

    }

    //hashCode()
    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + weather.hashCode();
        result = 31 * result + wind.hashCode();
        result = 31 * result + temp.hashCode();
        return result;
    }
}
