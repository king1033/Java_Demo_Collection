package com.king1033;

/**
 * @Author:king1033
 * @Desc:创建Weather实体类
 * @Time:2016/9/23
 */
public class Weather {
    private String weather;
    private String today;

    //创建Weather的空构造函数
    public Weather() {
    }

    //创建Weather的有参造函数
    public Weather(String weather, String today) {
        this.weather = weather;
        this.today = today;
    }

    //实现get()与set()方法
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    //实现toString()方法

    @Override
    public String toString() {
        return "Weather{" +
                "weather='" + weather + '\'' +
                ", today='" + today + '\'' +
                '}';
    }

    //实现equals()与hash Code()的方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather1 = (Weather) o;

        if (!weather.equals(weather1.weather)) return false;
        return today.equals(weather1.today);

    }

    @Override
    public int hashCode() {
        int result = weather.hashCode();
        result = 31 * result + today.hashCode();
        return result;
    }
}
