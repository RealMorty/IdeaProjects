package com.hust.cqb.SuperTest.Day03;

import java.io.File;

public class Recursion {
    public static void main(String[] args) {
//        int num = 0;
//        int sum = getSum(num);
//        int value = getValue(num);
//        System.out.println(num+"的阶乘为"+value);
        File dir = new File("C:\\Users\\Morty\\IdeaProjects");
//        print(dir);
        printDir2(dir);
    }

    private static void printDir2(File dir) {
//        File[] files = dir.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".java")
//                    ||pathname.isDirectory();
//            }
//        });
        File[] files = dir.listFiles(pathname -> pathname.getName().endsWith(".java")
                    ||pathname.isDirectory());
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名："+file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }
    }

    private static void printDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    System.out.println("文件名："+file.getAbsolutePath());
                }
            } else {
                printDir(file);
            }
        }
    }

    private static void print(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名："+file.getAbsolutePath());
            } else {
                System.out.println("目录："+file.getAbsolutePath());
                print(file);
            }
        }
    }

    private static int getValue(int num) {
        if (num==0) {
            return 1;
        }
        return num * getValue(num-1);
    }

    private static int getSum(int num) {
        if (num==0) {
            return 0;
        }
        return num+getSum(num-1);
    }

    private static void test2() {

    }

    public Recursion() {
    }

    private static void test1(int i) {
        System.out.println(i);
        if (i==10) {
            return;
        }
        test1(++i);
    }
}
