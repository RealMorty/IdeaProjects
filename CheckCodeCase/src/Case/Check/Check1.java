package Case.Check;

import Case.Dao.UserDao;
import Case.Domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Set;

@WebServlet("/Check1")
public class Check1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> login_inf = request.getParameterMap();

        //首先检查验证码
        HttpSession session = request.getSession();
        String s1 = (String) session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        if (s1==null || !s1.equalsIgnoreCase(login_inf.get("checkcode")[0])) {
            request.setAttribute("errorReason1","验证码输入错误");
//            request.getRequestDispatcher("/Fail.jsp").forward(request, response);
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
//        System.out.println(login_inf.get("checkcode")[0]);
//        System.out.println(session.getAttribute("checkcode"));
//        System.out.println(session.getAttribute("checkcode").equals(login_inf.get("checkcode")[0]));

        //再判断用户名和密码是否正确
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,login_inf);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);


        if (user == null) {
            request.setAttribute("errorReason2","用户名或密码输入错误");
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        } else {
            session.setAttribute("user", user.getUsername());
            request.getRequestDispatcher("/Success.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
