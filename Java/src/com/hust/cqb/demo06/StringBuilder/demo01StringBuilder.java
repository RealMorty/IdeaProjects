package com.hust.cqb.demo06.StringBuilder;

/**
 * @author : JavaMorty
 * @date :
 */
public class demo01StringBuilder {
    public static void main(String[] args) {
        StringBuilder bu1 = new StringBuilder();
        System.out.println("bu1"+bu1);
        System.out.println(bu1.length());

        StringBuffer bu2 = new StringBuffer("abc");
        System.out.println(bu2);
        bu2.append("1.32");//append方法可以接收任何类型的数据
        bu2.append(1.5);
        bu2.append(true);
        System.out.println(bu2);
        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase());
        System.out.println(bu2.append(2.09).append(true).append("era"));

        StringBuilder bu3 = new StringBuilder();
        StringBuilder bu4 = bu3.append("abc");
        System.out.println(bu4);
        System.out.println(bu4==bu3);

    }
}
