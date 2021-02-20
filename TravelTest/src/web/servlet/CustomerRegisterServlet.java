package web.servlet;


import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> register_info = request.getParameterMap();
        User RegisterUser = new User();
        try {
            BeanUtils.populate(RegisterUser, register_info);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();
        service.register(RegisterUser);
        HttpSession session = request.getSession();
        session.setAttribute("active", true);
        session.setAttribute("CurrentUser", RegisterUser);
        session.removeAttribute("CHECKCODE_SERVER");
        request.getRequestDispatcher("/emailVerify.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
