package com.hust.cqb.SuperTest.Day04;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream = new FileInputStream("FileTest/snow.jpg");
//            FileOutputStream fileOutputStream = new FileOutputStream("FileTest/test02.txt",true);
            FileOutputStream fileOutputStream = new FileOutputStream("FileTest/child1/snow.jpg");
//            fileOutputStream.write(13);
            byte[] bytes1 = new byte[10240];
//            byte[] bytes2;
            int len = 0;
            while ((len=fileInputStream.read(bytes1))!=-1) {
                fileOutputStream.write(bytes1,0,len);
            }
            fileOutputStream.close();
            fileInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("持续时间："+(end-start)+"ms");
    }

}
