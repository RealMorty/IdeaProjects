package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo4")
public class demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 演示获取referer
         */
        String referer = request.getHeader("referer");
        System.out.println(referer);

        String contextPath = request.getContextPath();

        //防盗链
        if (referer.contains(contextPath)) {
            System.out.println("播放电影");
        } else {
            System.out.println("想看电影吗？来优酷。。。");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
