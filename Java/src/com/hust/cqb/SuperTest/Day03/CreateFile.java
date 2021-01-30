package com.hust.cqb.SuperTest.Day03;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) throws IOException {
//        String pathname = "C:\\test\\aaa.txt";
//        File file1 = new File(pathname);
//
//        String pathname2 = "C:\\test\\bbb.txt";
//        File file2 = new File(pathname2);
//
//        String parent = "C:\\test";
//        String child = "bbb.txt";
//        File file3 = new File(parent,child);
//
//        File parentDir = new File("C:\\test");
//        String child1 = "bbb.txt";
//        File file4 = new File(parentDir, child1);
//        System.out.println(parentDir);
//        C:\Users\Morty\IdeaProjects\Java\FileTest\test01.txt
        test2();
    }

    private static void test2() {
        File dir = new File("FileTest");
        String[] names = dir.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("---------------------------");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    private static void test1() throws IOException {
        File file = new File("FileTest","test01.txt");
        File file1 = new File("FileTest","child1");
        file.createNewFile();
        file1.mkdir();
        System.out.println(file.length());
        System.out.println(file);
        File file3 = new File("FileTest","test02.txt");

    }
}



