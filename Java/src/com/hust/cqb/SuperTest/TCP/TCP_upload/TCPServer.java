package com.hust.cqb.SuperTest.TCP.TCP_upload;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传案例的服务器端：读取客户端上传的文件，保存到服务器的硬盘上，给客户端回写“上传成功”
 *
 * 明确：
 *  1.数据源：客户端上传文件
 *  2.目的地：服务器硬盘C:\\Users\\Morty\\Pictures\\Camera Roll\\upload
 * 实现步骤：
 *  1.创建一个服务器ServerSocket对象，和系统要指定的端口号
 *  2.使用ServerSocket对象中的方法accept，获取到请求的客户端Socket对象
 *  3.使用Socket对象中的方法getInputStream获取到网络字节输入流InputStream对象
 *  4.判断是否有文件夹，没有就创建一个
 *  5.创建一个本地字节输出流对象FileOutputStream对象，构造方法中绑定要输出的目的地
 *  6.使用网络字节输入流InputStream中的方法read，读取客户端上传的文件
 *  7.使用本地字节输出流FileOutputStream对象中的方法write，把读取到的文件保存到服务器的硬盘上
 *  8.使用Socket对象中的方法getOutputStream，获取到网络字节输出流OutputStream对象
 *  9.使用网络字节输出流OutputStream对象中的方法write，给客户端回写“上传成功”
 *  10.释放资源（FileOutputStream,Socket,ServerSocket）
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        File file = new File("C:\\Users\\Morty\\Pictures\\Camera Roll\\upload");
        if (!file.exists()) {
            file.mkdir();
        }
        FileOutputStream fos = new FileOutputStream(file+"\\1.jpg");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1) {
            fos.write(bytes,0,len);
        }
        OutputStream os = socket.getOutputStream();
        os.write("上传成功".getBytes());
        fos.close();
        socket.close();
        server.close();
    }
}
