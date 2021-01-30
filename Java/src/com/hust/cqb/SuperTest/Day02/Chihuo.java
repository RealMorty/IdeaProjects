package com.hust.cqb.SuperTest.Day02;

public class Chihuo extends Thread{
    private Baozi baozi;

    public Chihuo(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baozi) {
                if (baozi.flag==false) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃"+baozi.pi+baozi.xian+"的包子。");
                baozi.flag=false;
                baozi.notify();
                System.out.println("吃货已经把"+baozi.pi+baozi.xian+"的包子吃完了。包子铺开始生产包子。");
                System.out.println("-------------------------");
            }
        }
    }
}
