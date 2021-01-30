package com.hust.cqb.SuperTest.Day06;

import java.util.function.Predicate;

public class PredicateTest3 {
    public static boolean checkString(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(s);
    }

    public static void main(String[] args) {
        String s = "Morty";
        boolean b = checkString(s
                    ,(String str)-> str.length()>5
                    ,(String str)-> str.contains("o"));
        System.out.println(b);
    }
}
