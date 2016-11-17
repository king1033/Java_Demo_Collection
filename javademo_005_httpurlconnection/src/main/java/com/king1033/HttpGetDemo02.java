package com.king1033;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author:king1033
 * @Desc:
 * @Time:2016/11/17
 */
public class HttpGetDemo02 {
    private static long total_size=0;
    public static void main(String[] args) throws IOException {
        String urlString="http://image.tianjimedia.com/uploadImages/2015/129/56/J63MI042Z4P8.jpg";
        //获取文件名
        String fileName=getFileName(urlString);
        //获取流
        InputStream is=getResultFromNetwork(urlString);
        //写入文件
        boolean flag=saveFile(is, "Desktop"+fileName);
        if(flag){
            System.out.println("保存文件成功!");
        }else {
            System.out.println("保存文件失败!");
        }
    }

    private static String getFileName(String urlString) {
        int start=urlString.lastIndexOf('/');
        return urlString.substring(start);
    }

    public static InputStream getResultFromNetwork(String urlString) throws IOException{
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

        //(4)获取数据
        if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
            //获取响应的数据总大小
            total_size=conn.getContentLength();
            InputStream is=conn.getInputStream();
            return is;
        }
        return null;
    }

    public static boolean saveFile(InputStream is,String filePath) throws IOException{
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        FileOutputStream fos=new FileOutputStream(new File(filePath));
        byte[] buffer=new byte[1024];
        int length=0;
        long curProgess=0;
        if(is !=null){
            while((length=is.read(buffer))!=-1){
                //显示当前进度
                curProgess+=length;
                int progess=(int) ((curProgess*100)/total_size);
                System.out.println("progress="+progess+"%");
                baos.write(buffer,0,length);
            }
            baos.flush();
            fos.write(baos.toByteArray());
            baos.close();
            fos.close();
            return true;
        }

        return false;
    }
}
