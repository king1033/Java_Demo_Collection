package com.king1033;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author:king1033
 * @Desc:
 * @Time:2016/11/17
 */
public class HttpGetDemo01 {
    public static void main(String[] args) throws IOException {
        String urlString="http://www.devtf.cn/?p=909";

        //(1)获取URL
        URL url=new URL(urlString);
        //(2)打开连接到服务器
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        //(3)设置属性
        conn.setConnectTimeout(5*1000);
        conn.setReadTimeout(5*1000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        //GET方式不需要输出，设置为false
        conn.setDoOutput(false);
        //(4)读取数据
        if(conn.getResponseCode()== HttpURLConnection.HTTP_OK){
            InputStream is=conn.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line=null;
            FileWriter fw=new FileWriter("/Users/teacher/Desktop/youxi.html");
            StringBuffer sb=new StringBuffer();
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            fw.write(sb.toString());

            //断开连接
            conn.disconnect();
            //关闭流
            fw.close();
            br.close();
            is.close();
        }
    }

}
