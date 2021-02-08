package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int currentPage = request.getParameter("currentPage") == null ||
                              request.getParameter("currentPage").equals("") ?
                              1 : Integer.parseInt(request.getParameter("currentPage"));
        int rows = request.getParameter("rows") == null || request.getParameter("rows").equals("") ? 5 : 5;
        Map<String, String[]> condition = request.getParameterMap();
//        Set<String> stringSet = condition.keySet();
//        for (String s : stringSet) {
//            System.out.println(s + ":" + Arrays.toString(condition.get(s)));
//        }
//        System.out.println(condition);
        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.currentPageBean(currentPage, rows, condition);
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("condition",condition);//查询条件存入request
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
