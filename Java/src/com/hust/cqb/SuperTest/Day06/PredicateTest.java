package com.hust.cqb.SuperTest.Day06;

import java.util.function.Predicate;

public class PredicateTest {
    public static boolean checkString(String s, Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "Morty";
//        boolean b = checkString(s,(String str)->{
//            return str.length()>5;
//        });
        boolean b = checkString(s,(String str)->str.length()>5);
        System.out.println(b);
    }
}
