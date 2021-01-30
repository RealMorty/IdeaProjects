package com.hust.cqb.SuperTest.TCP.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建BS版本的TCP服务器
 */
public class TCPServerThread {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket
        ServerSocket server = new ServerSocket(8080);
        /**
         * 浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独开启一个线程，读取服务器的图片
         * 我们就让服务器一直处于监听状态，客户端请求一次服务器就回写一次
         */
        while (true) {
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        //        int len = 0;
                        //        byte[] bytes = new byte[1024];
                        //        while ((len=is.read(bytes))!=-1) {
                        //            System.out.println(new String(bytes,0,len));
                        //        }
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String readline = br.readLine();
                        System.out.println(readline);
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

//        server.close();
    }
}
