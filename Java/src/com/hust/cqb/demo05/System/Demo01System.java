package com.hust.cqb.demo05.System;

import java.util.Arrays;
import java.util.Date;

/**
 * @author : JavaMorty
 * @date :
 */
public class Demo01System {
    public static void main(String[] args) {
        demo02();
    }

    private static void demo02() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};

        System.out.println("复制前："+ Arrays.toString(dest));
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("复制后："+ Arrays.toString(dest));

//        for(int m: src){
//            System.out.println(m+ " ");
//        }
//        System.out.println("");
//        for(int n:dest){
//            System.out.println(n+" ");
//        }

        for (int i : src){
            System.out.print(i+" ");
        }

    }

    private static void demo01() {
        long StartTime;
        long EndTime;
        StartTime = System.currentTimeMillis();
        for (int i=0;i<100000;i++) {
            System.out.println(i);
        }
        EndTime = System.currentTimeMillis();
        double Duration = (double) (EndTime - StartTime)/1000;
        System.out.println("打印0~999共花费"+Duration+"秒");
    }
}
