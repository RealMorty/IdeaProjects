package com.hust.cqb.SuperTest.Day04;

import java.io.*;

/**
 * 使用字节流读取中文文件
 * 1个中文：
 *  GBK-两个字节
 *  UTF-8-三个字节
 *
 *
 */
public class InputStream {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("FileTest/test01.txt",true);
            for (int i = 0; i < 0; i++) {
                fileWriter.write("Morty"+i+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
