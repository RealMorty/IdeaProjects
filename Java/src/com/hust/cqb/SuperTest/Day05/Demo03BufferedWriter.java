package com.hust.cqb.SuperTest.Day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo03BufferedWriter {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("FileTest/test04.txt"));
            for (int i = 0; i < 10; i++) {
                bw.write("芜湖起飞");
                //bw.write("\r\n");
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
