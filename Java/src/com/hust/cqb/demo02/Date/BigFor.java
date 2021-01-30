package com.hust.cqb.demo02.Date;

import java.util.ArrayList;

/**
 * @author : JavaMorty
 * @date :
 */
public class BigFor {
    public static void main(String[] args) {
        demo02();
    }

    private static void demo02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Morty");
        list.add("Rick");
        list.add("Beth");
        list.add("Joe");
        list.add("Amy");
        for(String str01: list){
            System.out.println(str01);
        }
    }

    private static void demo01() {
        int[] arr = {1,2,3,4,5};
        for(int i: arr){
            System.out.print(i);
        }
    }

}

