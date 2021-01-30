package com.hust.cqb.SuperTest.Day02;

public class invokeCalc {
    public static void main(String[] args) {
        invokeCalc(233, 21, (int a, int b)->{
            return a+b;
        });
    }

    public static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是"+result);
    }
}
