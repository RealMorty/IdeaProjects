package com.hust.cqb.SuperTest.Day06;

import java.util.function.Consumer;

public class consumerTest2 {
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2){
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }
    public static void main(String[] args) {
        String[] arr = {"迪丽热巴，女","古力娜扎，女","马儿扎哈，男"};
        printInfo(arr,
                (message)->{
                    String name = message.split("，")[0];
                    System.out.print("姓名："+name);
                },
                (message)->{
                    String gender = message.split("，")[1];
                    System.out.println(" 性别："+gender+"。");
                }
        );
    }
}
