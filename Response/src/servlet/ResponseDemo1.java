package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //自动跳转到ResponseDemo2
//        System.out.println("demo1被访问。。。");
//        response.setStatus(302);
//        response.setHeader("location","/Response/ResponseDemo2");
        String contextPath = request.getContextPath();
        //简单方法
        response.sendRedirect(contextPath+"/ResponseDemo2");
//        response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
