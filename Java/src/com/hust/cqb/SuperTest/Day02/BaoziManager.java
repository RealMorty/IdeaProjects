package com.hust.cqb.SuperTest.Day02;

public class BaoziManager {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();
        new Baozipu(baozi).start();
        new Chihuo(baozi).start();
    }
}
