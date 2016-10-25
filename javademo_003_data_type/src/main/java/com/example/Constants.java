package com.example;

/**
 * @Author:king1033
 * @Desc:
 * 1、在Java中利用final指示常量
 * 2、关键字final表示这个常量只能被赋值一次，一旦被赋值后该常量就不能再更改了
 * 3、习惯上，常量名的名称使用大写字母表示
 * @Time:2016/10/25
 */
public class Constants {
    public static void main(String[] args) {
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double pagerHeight = 11;
        System.out.println("Pager size in centimeters:" + paperWidth * CM_PER_INCH + " by " + pagerHeight * CM_PER_INCH);
    }
}
