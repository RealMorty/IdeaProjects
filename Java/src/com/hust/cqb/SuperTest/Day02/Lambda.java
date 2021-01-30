package com.hust.cqb.SuperTest.Day02;

public class Lambda {
    public static void main(String[] args) {
        //使用匿名内部类的方式实现多线程
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了。");
            }
        }).start();
        //使用lambda表达式，实现多线程
        new Thread(()->
            {
                System.out.println(Thread.currentThread().getName()+"新线程创建了。");
            }
        ).start();
    }
}
