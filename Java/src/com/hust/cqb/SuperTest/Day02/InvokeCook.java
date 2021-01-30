package com.hust.cqb.SuperTest.Day02;

public class InvokeCook {
    public static void main(String[] args) {
        InvokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了");
            }
        });
        InvokeCook(()->{
            System.out.println("吃饭了");
        });
    }

    public static void InvokeCook(Cook cook) {
        cook.makeFood();
    }
}
