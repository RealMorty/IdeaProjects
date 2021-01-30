package com.hust.cqb.SuperTest.Day05;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo09PrintStream2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我是在控制台输出");

        PrintStream ps = new PrintStream("FileTest/test04.txt");
        System.setOut(ps);
        System.out.println("我是在打印流的目的地中输出");

        ps.close();
    }
}
