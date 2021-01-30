package com.hust.cqb.SuperTest.Day02;

public class Baozipu extends Thread{
    private Baozi baozi;

    public Baozipu(Baozi baozi) {
        this.baozi = baozi;
    }
    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (baozi) {
                if (baozi.flag==true) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count==0) {
                    baozi.pi = "薄皮";
                    baozi.xian = "三鲜馅";
                } else {
                    baozi.pi = "冰皮";
                    baozi.xian = "牛肉大葱馅";
                }
                count++;
                System.out.println("包子铺正在生产："+baozi.pi+baozi.xian+"包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baozi.flag = true;
                baozi.notify();
                System.out.println("包子铺已经生产好了"+baozi.pi+baozi.xian+"的包子，吃货可以开始吃了。");
            }
        }

    }
}
