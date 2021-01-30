package com.hust.cqb.SuperTest.Day06.FunctionTest;

import java.util.function.Function;

public class FunctionAndThen {
    public static void change1(String s, Function<String,Integer> fun1, Function<Integer,String> fun2){
//        Integer integer = fun1.apply(s);
//        s = fun2.apply(integer);
        String s1 = fun1.andThen(fun2).apply(s);
        System.out.println(s1);
    }

    public static void change2(String s, Function<String,String> fun1, Function<String,Integer> fun2, Function<Integer, String> fun3){
//        Integer integer = fun1.apply(s);
//        s = fun2.apply(integer);
        String s1 = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(s1);
    }

    public static void main(String[] args) {
        String string = "赵丽颖,20";
        change2(string,(String str)->str.split(",")[1],(String str)->Integer.parseInt(str)+100,(Integer integer)->integer.toString());
    }
}
