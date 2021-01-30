package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo3")
public class demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 演示获取user-agent
         */
        String agent = request.getHeader("user-agent");
        //判断浏览器版本
        if (agent.contains("Chrome")){
            System.out.println("Chrome");//谷歌
        } else if (agent.contains("Firefox")){
            System.out.println("Firefox");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
