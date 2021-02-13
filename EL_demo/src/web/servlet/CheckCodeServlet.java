package web.servlet;

import domain.RootUser;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(request);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> login_inf = request.getParameterMap();
        RootUser rootUser = new RootUser();

        try {
            BeanUtils.populate(rootUser, login_inf);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //首先检查验证码
        HttpSession session = request.getSession();
        String s1 = (String) session.getAttribute("verifycode");
        session.removeAttribute("verifycode");
        if (s1==null || !s1.equalsIgnoreCase(login_inf.get("verifycode")[0])) {
            request.setAttribute("errorReason1","验证码输入错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        //再判断用户名和密码是否正确
        Boolean checkAdmin = new AdminServiceImpl().checkAdmin(login_inf.get("username")[0],
                                                                login_inf.get("password")[0]);

        if (!checkAdmin) {
            request.setAttribute("errorReason2","用户名或密码输入错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } else {
            session.setAttribute("rootUser",rootUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
