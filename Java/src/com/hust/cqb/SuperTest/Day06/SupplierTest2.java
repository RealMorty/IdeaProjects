package com.hust.cqb.SuperTest.Day06;

import java.util.function.Supplier;

public class SupplierTest2 {
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] integers = {100,0,50,88,99};
        int maxValue = getMax(()->{
            int max = integers[0];
            for (int integer : integers) {
                if (integer>max){
                    max = integer;
                }
            }
            return max;
        });
        System.out.println(maxValue);
    }
}
