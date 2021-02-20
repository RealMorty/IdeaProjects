package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> login_inf = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, login_inf);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //判断用户名和密码是否正确
        HttpSession session = request.getSession();
        session.setAttribute("active",false);
        boolean checkUser = new UserServiceImpl().checkUser(login_inf.get("username")[0],
                login_inf.get("password")[0]);

        if (!checkUser) {
            request.setAttribute("loginError","❌用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } else {
            session.setAttribute("CurrentUser",user);
            session.setAttribute("active",true);
            request.getSession().removeAttribute("CHECKCODE_SERVER");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
