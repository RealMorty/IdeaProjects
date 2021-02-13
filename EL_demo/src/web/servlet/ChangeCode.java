package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/ChangeCode")
public class ChangeCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个对象，在内存中图片（验证码图片对象）
        int width = 80;
        int height = 32;
        int fontsize = height/2;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片
        //1.填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.white);
        g.fillRoundRect(0,0,width,height,4,4);
        //2.画边框
        g.setColor(Color.white);
        g.drawRoundRect(0,0,width-1,height-1,4,4);
        //3.写验证码
        g.setColor(Color.black);
        g.setFont(new Font("Berlin Sans FB", Font.BOLD, fontsize));
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random ran = new Random();

        char[] checkcode_char = new char[4];

        //获取字符
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            checkcode_char[i-1] =  ch;
            g.drawString(ch+" ",width/5*i,height/2+fontsize/3);
        }

        String checkcode = new String(checkcode_char);
        HttpSession session = request.getSession();
        session.setAttribute("verifycode",checkcode);
//        System.out.println(checkcode);
        //画干扰线
        g.setColor(Color.ORANGE);
//        g.drawLine(1,1,30,30);
        //随机生成坐标点

        for (int i = 0; i < 5; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        //输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
