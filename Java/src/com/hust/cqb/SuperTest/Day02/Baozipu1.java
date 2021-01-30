package com.hust.cqb.SuperTest.Day02;

public class Baozipu1 extends Thread{
    private Baozi1 baozi = new Baozi1();

    public Baozipu1(Baozi1 baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (baozi) {
                if (baozi.flag==false) {
                    if (count%2==0) {
                        baozi.pi = "薄皮";
                        baozi.xian = "三鲜馅";
                    } else {
                        baozi.pi = "冰皮";
                        baozi.xian = "牛肉大葱馅";
                    }
                    count++;
                    System.out.println("程琪滨正在生产"+baozi.pi+baozi.xian+"包子");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("程琪滨已经做好了包子，程泽可以开始吃了");
                    System.out.println("--------------------------------");
                    baozi.notify();
                    baozi.flag = true;
                }
                try {
                    baozi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
