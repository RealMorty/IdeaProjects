package com.hust.cqb.SuperTest.Day05;

import java.io.*;

public class Demo06GBK_UTF8 {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("FileTest/我是GBK格式的文本.txt"),"GBK");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("FileTest/我是utf_8格式的文件.txt"),"UTF-8");
            int len = 0;
            while ((len=isr.read())!=-1) {
                osw.write(len);
            }
            osw.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
