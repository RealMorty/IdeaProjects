package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/isUserNameExists")
public class isUserNameExists extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        Map<String,Object> map = new HashMap<>();
        UserService service = new UserServiceImpl();
        if (service.isUserNameExists(username) || username.equals("")) {
            map.put("msg_username","❌");
            map.put("msg_flag",false);
        } else {
            map.put("msg_username","✔");
            map.put("msg_flag",true);
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
