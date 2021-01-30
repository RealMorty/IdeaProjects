package com.hust.cqb.SuperTest.Day06;

import java.util.function.Supplier;

public class SupplierTest {
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
//        String s = getString(()->{
//           return "ert";
//        });
        String s = getString(()->"ert");
        System.out.println(s);
    }
}
