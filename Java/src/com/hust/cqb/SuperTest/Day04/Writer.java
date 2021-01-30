package com.hust.cqb.SuperTest.Day04;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * java.io.Reader:字符输入流，是字符输入流的最顶层的父类，定义了一些共性的成员方法，抽象类
 *
 * 共性的成员方法：
 * abstract void	close()
 *                  Closes the stream and releases any system resources associated with it.
 * int	            read()
 *                  Reads a single character.
 * int	            read(char[] cbuf)
 *                  Reads characters into an array.
 * java.io.FileReader extends InputStreamReader extends Reader
 * FileReader:文件字符输入流
 * 作用：把硬盘文件中的数据以字符的方式读取到内容中
 * 构造方法：
 *      FileReader(String fileName)
 *      FileReader(File file)
 *      参数：读取文件的数据源
 */
public class Writer {
    public static void main(String[] args) {
        way3();
    }

    private static void way3() {
        try {
            FileWriter fileWriter = new FileWriter("FileTest/test03.txt",true);
            String msg = "Morty is me!";
            fileWriter.write(msg);
            fileWriter.write(msg,2,2);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void way2() {
        try {
            FileWriter fileWriter = new FileWriter("FileTest/test03.txt",true);
            char[] chars = "Morty".toCharArray();

            fileWriter.write(chars);
            fileWriter.write(chars,2,2);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void way1() {
        try {
            FileWriter fileWriter = new FileWriter("FileTest/test03.txt",true);
            fileWriter.write("Morty ");
            fileWriter.flush();
            fileWriter.write("is ");
            fileWriter.flush();

            fileWriter.write("closed ");
            fileWriter.close();
//            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
