package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User addUser = new User();
        Map<String, String[]> newUser = request.getParameterMap();
        try {
            BeanUtils.populate(addUser,newUser);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(addUser.getAge());
        if (addUser.getName() == null || addUser.getAddress() == null ||
                addUser.getAge() == 0 || addUser.getEmail() == null || addUser.getGender() == null ||
                addUser.getQq() == null
            ) {
            request.setAttribute("errorAdd","添加失败，请注意是否有漏填");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        } else {
            new UserServiceImpl().addUser(addUser);
            response.sendRedirect("/EL_demo/UserListServlet");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
