package com.hust.cqb.SuperTest.Day02;

public class BaoziManager1 {
    public static void main(String[] args) {
        Baozi1 baozi1 = new Baozi1();

        new Baozipu1(baozi1).start();
        new Chihuo1(baozi1).start();
    }
}

