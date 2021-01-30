package com.hust.cqb.SuperTest.Day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * void	close()
 *      Closes this output stream and releases any system resources associated with this stream.
 * void	flush()
 *      Flushes this output stream and forces any buffered output bytes to be written out.
 * void	write(byte[] b)
 *      Writes b.length bytes from the specified byte array to this output stream.
 * void	write(byte[] b, int off, int len)
 *      Writes len bytes from the specified byte array starting at offset off to this output stream.
 * abstract void write(int b)
 *      Writes the specified byte to this output stream.
 *
 *
 *      java.io.FileOutputStream extends OutputStream:文件字节输出流，把内存中的数据写入到硬盘的文件中
 *      FileOutputStream(File file)
 *          Creates a file output stream to write to the file represented by the specified File object.
 *       FileOutputStream(String name)
 *          Creates a file output stream to write to the file with the specified name.
 *
 *      创建一个FileOutputStream对象，并将其指向
 *
 *      写入原理：（内存-->硬盘）
 *          Java程序-->JVM-->OS-->OS调用写数据的方法-->把数据写入到文件中
 *      读取原理：（硬盘-->内存）
 *          Java程序-->JVM-->OS-->OS调用读数据的方法-->读取文件
 *      字节输出流使用步骤：
 *          1.创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
 *          2.调用FileOutputStream对象中的方法write，把数据写入到文件中
 *          3.释放资源
 *      字节输入流使用步骤：
 *          1.创建一个FileIntputStream对象，构造方法中传递写入数据的目的地
 *          2.调用FileIntputStream对象中的方法read，读取文件
 *          3.释放资源
 *
 *      字符串转换为字节数组
 *      getBytes():
 *          Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.
 *
 *      FileOutputStream(File file, boolean append)
 *          Creates a file output stream to write to the file represented by the specified File object.
 *      FileOutputStream(String name, boolean append)
 *          Creates a file output stream to write to the file with the specified name.
 *      boolean append:追加写开关
 *          true:创建对象不会覆盖原文件，继续在文件末尾追加写数据
 *          false:创建一个新文件，覆盖原文件
 *      写换行：
 *          windows:\r\n
 *          linux:/n
 *          mac:/r
 */
public class IOStream {

    public static void main(String[] args) {
        outputstream1();
    }

    private static void inputstream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("FileTest/test01.txt");
//            int b;
//            while ((b=fileInputStream.read())!=-1){
//                System.out.print((char) b);
//            }
//            fileInputStream.close();
//            System.out.println("----------------------------------------");
            byte[] bytes = new byte[1024];
            int len = 0;
//            while ((len = fileInputStream.read(bytes))!=-1) {
//                System.out.println(new String(bytes,0,len));
//            }
            System.out.println(fileInputStream.read(bytes));
//            System.out.println(len);
//            System.out.println(Arrays.toString(bytes));
//            System.out.println(new String(bytes));
//            for (int i = 0; i < 3; i++) {
//                System.out.println("第"+(i+1)+"次读取结果:"+fileInputStream.read(bytes));
//                System.out.println("读取后数组的内容为："+Arrays.toString(bytes));
//            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputstream2() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("FileTest/test02.txt", true);
            for (int i = 0; i < 10; i++) {
                fileOutputStream.write("\r\n增加一些数".getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputstream1() {
        try {
            FileOutputStream fos = new FileOutputStream("FileTest/test02.txt");
//            byte[] bytes = {65,66,67,68};
            byte[] bytes = {-65,-66,67,68};//烤CD
            fos.write(bytes,0,2);//烤
//            fos.write(46);


            byte[] bytes2 = "你好Hello123".getBytes();
            System.out.println(Arrays.toString(bytes2));
            fos.write(bytes2);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




















