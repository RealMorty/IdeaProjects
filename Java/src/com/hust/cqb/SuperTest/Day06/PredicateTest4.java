package com.hust.cqb.SuperTest.Day06;

import java.util.function.Predicate;

public class PredicateTest4 {
    public static boolean checkString(String s, Predicate<String> pre) {
        return !pre.test(s);
    }

    public static void main(String[] args) {
        String s = "Mortty";
        boolean b = checkString(s
                    ,(String str)-> str.length()>5);
        System.out.println(b);
    }
}
