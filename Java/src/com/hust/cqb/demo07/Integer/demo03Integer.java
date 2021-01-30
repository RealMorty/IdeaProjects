package com.hust.cqb.demo07.Integer;

/**
 * @author : JavaMorty
 * @date :
 */
public class demo03Integer {
    public static void main(String[] args) {
        int num = 1212121010;

        long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            String str = num + "";
        }
        long end = System.currentTimeMillis();
        System.out.println("num+\"\":"+(end-start));

        start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            String str = String.valueOf(num);
        }
        end = System.currentTimeMillis();
        System.out.println("num+\"\":"+(end-start));

        start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            String str = Integer.toString(num);
        }
        end = System.currentTimeMillis();
        System.out.println("num+\"\":"+(end-start));
    }
}
