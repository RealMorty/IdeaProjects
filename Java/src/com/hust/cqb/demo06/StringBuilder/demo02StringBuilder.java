package com.hust.cqb.demo06.StringBuilder;

/**
 * @author : JavaMorty
 * @date :
 */
public class demo02StringBuilder {
    public static void main(String[] args) {
        //String->StringBuilder
        String str = new String("Hello");
        System.out.println("str:"+str);

        StringBuilder bu = new StringBuilder(str);
        System.out.println("bu:"+bu);

        bu.append("world");
        System.out.println("bu:"+bu);

        //StringBuilder->String
        String str1 = bu.toString();
        System.out.println("str1:"+str1);

    }
}
