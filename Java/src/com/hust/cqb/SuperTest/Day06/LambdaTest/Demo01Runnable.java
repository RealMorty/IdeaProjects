package com.hust.cqb.SuperTest.Day06.LambdaTest;

public class Demo01Runnable {
    public static void startThread(Runnable run){
        new Thread(run).start();
    }

    public static void main(String[] args) {
        startThread(()-> System.out.println(Thread.currentThread().getName()+"-->开启线程"));
    }
}
