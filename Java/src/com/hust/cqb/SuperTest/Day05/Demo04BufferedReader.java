package com.hust.cqb.SuperTest.Day05;

import java.io.*;

public class Demo04BufferedReader {
    private BufferedReader br;

    public static void main(String[] args) {
        try {
             BufferedReader br = new BufferedReader(new FileReader("FileTest/test04.txt"));
             String  len = null;
             while ((len=br.readLine())!=null) {
                 System.out.println(len);
             }
             br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
