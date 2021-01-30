package com.hust.cqb.SuperTest.TCP.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建BS版本的TCP服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        while ((len=is.read(bytes))!=-1) {
//            System.out.println(new String(bytes,0,len));
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readline = br.readLine();
        String[] arr = readline.split(" ");
        String htmlpath = arr[1].substring(1);
        FileInputStream fis = new FileInputStream(htmlpath);
        OutputStream os = socket.getOutputStream();
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        //必须要写入空行，否则浏览器不解析
        os.write("\r\n".getBytes());

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=fis.read(bytes))!=-1) {
            os.write(bytes,0,len);
        }
        fis.close();
        socket.close();
        server.close();
    }
}
