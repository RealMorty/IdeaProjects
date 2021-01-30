package com.hust.cqb.demo04.Generic;

import java.util.Calendar;

/**
 * @author : JavaMorty
 * @date :
 */
public class Demo02GenericClass {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        Demo01Generic gc = new Demo01Generic();
        gc.setName("只能是字符串");

//        Object name = gc.getName();
//        创建Demo01Generic对象，泛型使用Integer类型
        Demo01Generic<Integer> gc2 = new Demo01Generic<>();
        gc2.setName(34);
        Integer name = gc2.getName();
        System.out.println(name);

        demo02();


    }

    private static void demo02() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,1998);

        System.out.println(c.get(Calendar.YEAR));
    }

    private static void demo01() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);

        int date = c.get(Calendar.DATE);
        System.out.println(date);
    }
}
