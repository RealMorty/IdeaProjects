package com.hust.cqb.SuperTest.Day04;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class Reader {
    public static void main(String[] args) {
        way2();
    }

    private static void way2() {
        try {
            FileReader fileReader = new FileReader("FileTest/test03.txt");
            int len;
            char[] bytes = new char[2];
            while ((len=fileReader.read(bytes))!=-1) {
                System.out.println(new String(bytes,0,len));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void way1() {
        try {
            FileReader fileReader = new FileReader("FileTest/test03.txt");
            int b;
            while ((b=fileReader.read())!=-1) {
                System.out.print((char)b);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
