package com.example;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import java.util.Date;
import java.util.Scanner;

/**
 * @Author:king1033
 * @Desc:
 * This program demonstrates console input
 * 注意：
 * 由于输入是可见的，所以Scanner类不适用于从控制台读取密码。在Java SE 6中引入Console 类来实现这个目的。
 * 示例如下：
 * Console cons = System.console;
 * String username = cons.readLine("User name: ");
 * char[] password = cons.readPassword("Password: ");
 * 小结：
 * 1、为了安全起见，返回的密码存放在一维字符数组中，而不是字符串中
 * 2、在对密码进行处理后，应该马上用一个填充值覆盖数组元素
 * 3、采用Console对象处理输入时，每次只能读取一行输入，而没有能够读取一个单词或一个数值的方法
 *
 * @Time:2016/10/25
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //get first input
        System.out.print("What is your name?");
        String name = in.nextLine();

        //get second input
        System.out.print("How old are you?");
        int age = in.nextInt();

        //display output on console
        System.out.println("Hello, "+ name + ", Next year, you'll be "+ (age + 1));

        //格式化打印当前的时间
        System.out.printf("%tc",new Date());
    }
}
