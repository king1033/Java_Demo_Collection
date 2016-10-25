package com.example;

/**
 * @Author:king1033
 * @Desc:
 * 1、类常量：在Java中某个常量可以在一个类中的多个方法中使用
 * 2、类常量一般使用关键字static final来修饰
 * 3、注意：类常量的定义一般位于main方法的外部
 * @Time:2016/10/25
 */
public class Constants2 {
    public static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        double paperWidth = 8.5;
        double pagerHeight = 11;
        System.out.println("Pager size in centimeters:" + paperWidth * CM_PER_INCH + " by " + pagerHeight * CM_PER_INCH);
    }
}
