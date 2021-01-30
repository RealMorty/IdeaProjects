package com.hust.cqb.SuperTest.Day06;

import java.util.Locale;
import java.util.function.Consumer;

/**
 * 需要两个Consumer接口，可以把两个Consumer接口组合到一起，再对数据进行消费
 * 例如：
 *  Consumer<String> con1
 *  Consumer<String> con2
 *  String s = "Hello";
 *  con1.accept(s);
 *  con2.accept(s);
 *  连接两个Consumer接口，再进行消费
 *  con1.andThen(con2).accept(s);//谁写前面谁先消费
 */
public class AndThenTest {
    public static void method(String str, Consumer<String> con1,Consumer<String> con2){
//        con1.accept(str);
//        con2.accept(str);
        con1.andThen(con2).accept(str);
    }

    public static void main(String[] args) {
        String morty = "Morty";
        method(morty,
                (t)->{
                    System.out.println(t.toUpperCase());
                },
                (t)->{
                    System.out.println(t.toLowerCase());
                });
    }
}
