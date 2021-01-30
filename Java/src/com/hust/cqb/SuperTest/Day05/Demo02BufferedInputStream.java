package com.hust.cqb.SuperTest.Day05;

import java.io.*;

public class Demo02BufferedInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("FileTest/test04.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
//            int len = 0;
//            while ((len=bis.read())!=-1) {
//                System.out.print((char) len);
//            }
//            bis.close();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=bis.read(bytes))!=-1) {
                System.out.print(new String(bytes,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
