package com.hust.cqb.SuperTest.Day06;

import java.util.function.Consumer;

public class consumerTest {
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        String morty = "Morty";
        method(morty,(String name)->{
//            System.out.println(name);
            String reName = new StringBuilder(name).reverse().toString();
            System.out.println(reName);
        });
    }
}
