package com.hust.cqb.SuperTest.TCP.TCP_connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通信的服务器端：接收客户端的请求，读取客户端发送的数据，给客户端回写数据
 * 表示服务器的类：
 *  java.net.ServerSocket:此类实现服务器套接字
 *
 *  构造方法：
 *      ServerSocket(int port) 创建绑定端口号的服务器套接字
 *  成员方法：
 *      Socket accept() 侦听并接受此套接字的连接
 *
 *  实现步骤：
 *     1.创建ServerSocket对象和指定端口号
 *     2.使用accept()
 *     3.getInputStream()获取网络字节输入流InputStream对象
 *     4.使用read()读取客户端发送的数据
 *     5.getOutputStream()获取OutputStream流
 *     6.使用OutputStream对象的write,给客户端回写数据
 *     7.释放资源(Socket, ServerSocket)
 *
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);

        System.out.println(new String(bytes,0,len));

        OutputStream os = socket.getOutputStream();
        os.write("收到谢谢".getBytes());
        socket.close();
        server.close();
    }
}
