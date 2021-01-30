package com.hust.cqb.SuperTest.TCP.TCP_upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传案例的客户端：读本地文件，上传到服务器，读取服务器回写的数据
 * 明确：数据源："C:\Users\Morty\Pictures\ocean.jpg"
 *      目的地：服务器
 *
 * 实现步骤：
 *      1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源
 *      2.创建一个客户端Socket方法，绑定IP和端口号
 *      3.使用getOutputStream，获取网络中的字节输出流OutputStream对象
 *      4.使用本地字节输入流FileInputStream对象中的方法read，读取本地文件
 *      5.使用网络字节输出流OutputStream对象中的方法write，把读取的文件上传到服务器
 *      6.使用getInputStream，获取网络中的字节输入流InputStream对象
 *      7.read方法读取服务器回写的数据
 *      8.释放资源（FileInputStream,Socket）
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Morty\\Pictures\\ocean.jpg");
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=fis.read(bytes))!=-1) {
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len=is.read(bytes))!=-1) {
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
