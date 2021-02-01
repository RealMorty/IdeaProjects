package Cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookiesTest")
public class CookiesTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies!=null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前："+str_date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后："+str_date);
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为"+value+"</h1>");

                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || !flag) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie = new Cookie("lastTime",str_date);

            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
