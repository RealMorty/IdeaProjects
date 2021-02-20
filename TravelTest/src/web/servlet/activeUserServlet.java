package web.servlet;

import service.ServiceImpl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class activeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code != null) {
            UserServiceImpl userService = new UserServiceImpl();
            boolean flag = userService.active(code);

            String msg = null;
            if (flag) {
                msg = "激活成功，点此<a href='login.jsp'>登录</a>";
            } else {
                msg ="激活失败，请联系管理员！";
            }
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/RegisterVerify.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
