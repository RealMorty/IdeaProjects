package com.hust.cqb.SuperTest.Day06.LambdaTest;

import java.util.Arrays;
import java.util.Comparator;

public class Demo02Comparator {
    public static Comparator<String> getComparator(){
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();
//            }
//        }
        return (o1, o2)->o2.length()-o1.length();
    }

    public static void main(String[] args) {
        String[] str = {"abc","bd","cde"};
        System.out.println(Arrays.toString(str));
        Arrays.sort(str,getComparator());
        System.out.println(Arrays.toString(str));
    }

}
