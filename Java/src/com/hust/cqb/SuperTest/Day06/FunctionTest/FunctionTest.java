package com.hust.cqb.SuperTest.Day06.FunctionTest;

import java.util.function.Function;

public class FunctionTest {
    public static void change(String s, Function<String,Integer> fun){
        Integer in = fun.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        String str1 = "123";
        change(str1,(String str)-> Integer.parseInt(str));
    }
}
