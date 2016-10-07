package com.example;

/**
 * @Author:king1033
 * @Desc:WelcomeDemo
 * @Time:2016/10/7
 */

public class Welcome {

    public static void main(String[] args) {
        String[] greeting = new String[3];
        greeting[0] = "Welcome to Core Java";
        greeting[1] = "by King1033";
        greeting[2] = "and Tom";

        for (String g:greeting){
            System.out.println(g);
        }
    }
}
