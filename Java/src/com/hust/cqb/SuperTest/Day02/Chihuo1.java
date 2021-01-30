package com.hust.cqb.SuperTest.Day02;

public class Chihuo1 extends Thread {
    private Baozi1 baozi;

    public Chihuo1(Baozi1 baozi) {
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
                } else {
                    System.out.println("程泽正在吃"+baozi.pi+baozi.xian+"包子。");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    baozi.flag = false;
                    baozi.notify();
                    System.out.println("程泽已经把"+baozi.pi+baozi.xian+"包子吃完了，程琪滨快开始做");
                }
            }
        }

    }
}
