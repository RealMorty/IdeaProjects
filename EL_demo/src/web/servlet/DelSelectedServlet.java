package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/DelSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkBoxIds = request.getParameterValues("checkBoxId");
        UserService userService = new UserServiceImpl();
        userService.delSelectedUsers(checkBoxIds);

        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
