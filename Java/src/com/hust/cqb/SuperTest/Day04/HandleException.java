package com.hust.cqb.SuperTest.Day04;

import java.io.FileWriter;
import java.io.IOException;

public class HandleException {
    public static void main(String[] args) throws IOException {
        handleException2();
    }

    private static void handleException2() {
        try (FileWriter fileWriter = new FileWriter("FileTest/test03.txt");) {
            fileWriter.write("Yes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleException1() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("FileTest/test03.txt");
            fileWriter.write("Yes!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter!=null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
