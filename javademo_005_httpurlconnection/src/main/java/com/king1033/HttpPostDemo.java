package com.king1033;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:king1033
 * @Desc:
 * @Time:2016/11/17
 */
public class HttpPostDemo {
    public static void main(String[] args) throws IOException {
        String urlString="http://oa.1000phone.net/oa.php/Admin/login";

        //(1)获取URL
        URL url=new URL(urlString);
        //(2)打开连接
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        //(3)设置属性
        conn.setConnectTimeout(5*1000);
        conn.setReadTimeout(5*1000);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        //设置请求的头部
        conn.setRequestProperty("Connection", "keep-alive");
        //(4)设置参数
        OutputStream os=conn.getOutputStream();
        //String params="AdminName=xiaxin%401000phone.com&PassWord=seam123%21%40%23";
        Map<String, Object> map=new HashMap<>();
        map.put("AdminName", "xiaxin%401000phone.com");
        map.put("PassWord", "seam123%21%40%23");

        //写入参数
        writeParams(os, map);

        //(5)获取数据
        if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
            InputStream is=conn.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer sb=new StringBuffer();
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            FileWriter fw=new FileWriter("/Users/teacher/Desktop/hhhhh.html");
            fw.write(sb.toString());
            fw.close();
            is.close();
        }
        //(6)断开连接
        conn.disconnect();
        os.close();


    }

    public static void writeParams(OutputStream os,Map<String,Object> map) throws IOException{

        String[] keyArray=new String[map.size()];
        Set set=map.keySet();
        set.toArray(keyArray);

        StringBuffer sb=new StringBuffer();
        for(int i=0; i<keyArray.length;i++){
            String key=keyArray[i];
            String value=(String) map.get(key);
            sb.append(key).append("=").append(value);
            sb.append("&");
        }

        String params=sb.toString();
        String paString=params.substring(0,params.length()-1);

        paString=URLEncoder.encode(paString,"utf-8");
        os.write(paString.getBytes());
        os.flush();
        os.close();
    }
}
