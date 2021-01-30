package com.hust.cqb.SuperTest.Day05;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Demo01BufferedOutputStream {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("FileTest/test04.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write("我把数据写入到内部缓冲区中".getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
