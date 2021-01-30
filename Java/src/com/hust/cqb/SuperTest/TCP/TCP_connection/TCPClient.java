package com.hust.cqb.SuperTest.TCP.TCP_connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据
 * 表示客户端的类：
 *  java.net.Socket:此类实现客户端套接字，套接字是两台机器间的通信端点。
 *  套接字：包含了IP地址和端口号的网络单位
 *
 *  构造方法：Socket(String host, int port)创建一个流套接字并将其连接到指定主机上的指定端口号
 *      参数:String host----服务器主机的名称、服务器的IP地址
 *          int port-------服务器的端口号
 *
 *  成员方法：
 *  1.OutputStream getOutputStream() 返回此套接字的输出流
 *  2.InputStream getInputStream() 返回此套接字的输入流
 *  3.void close() 关闭此套接字
 *
 *  实现步骤:
 *  1.创建Socket，绑定IP和端口号
 *  2.getOutputStream()获取OutputStream流
 *  3.write()给服务器发送数据
 *  4.getInputStream()获取网络字节输入流InputStream对象
 *  5.read()读取服务器回写数据
 *  6.释放资源（Socket）
 *
 *  注意事项：
 *  1.客户端和服务器端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
 *  2.创建客户端Socket的时候，就会去请求服务器，经过三次握手建立连接通路
 *      这时如果服务器没有启动，就会抛出异常
 *      已经启动则可以交互
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建Socket，绑定IP和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //2.getOutputStream()获取OutputStream流
        OutputStream os = socket.getOutputStream();
        //3.write()给服务器发送数据
        os.write("你好服务器".getBytes());

        //4.getInputStream()获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //5.read()读取服务器回写数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);

        System.out.println(new String(bytes,0,len));


        //6.释放资源（Socket）
        socket.close();
    }
}
