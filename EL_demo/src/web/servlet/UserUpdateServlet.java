package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> updateUser = request.getParameterMap();
        User updatedUser = new User();
        try {
            BeanUtils.populate(updatedUser,updateUser);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();

        new UserServiceImpl().updateUser(updatedUser, (int) session.getAttribute("UpdateUserId"));

        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
