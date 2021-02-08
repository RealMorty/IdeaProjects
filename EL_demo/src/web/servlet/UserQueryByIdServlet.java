package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserQueryByIdServlet")
public class UserQueryByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int queryId = Integer.parseInt(request.getParameter("id"));
//        request.getSession().setAttribute("queryById",queryId);
        User queryUser = new UserServiceImpl().queryUserById(queryId);
        request.setAttribute("queryByIdUser",queryUser);

        HttpSession session = request.getSession();
        session.setAttribute("UpdateUserId", queryUser.getId());
//        System.out.println("id="+queryUser.getId());
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
