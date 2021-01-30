package com.hust.cqb.SuperTest.Day06;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest5 {
    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> list = new ArrayList<>();
//        {"迪丽热巴，女","古力娜扎，女","马儿扎哈，男"}
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if (b) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] strings = {"迪丽热巴，女","古力娜扎，女","马儿扎哈，男"};
        ArrayList<String> list = filter(strings,(String s)->{
            return s.split("，")[1].equals("女");
        },(String s)->{
            return s.split("，")[0].length()==4;
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
