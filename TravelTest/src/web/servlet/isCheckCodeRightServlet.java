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

@WebServlet("/isCheckCodeRightServlet")
public class isCheckCodeRightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        String check = request.getParameter("check");

        Map<String,Object> map = new HashMap<>();
        if (!checkcode_server.equalsIgnoreCase(check) || check.equals("") ||
                check.length()==0) {
            map.put("msg_check","❌");
            map.put("msg_flag",false);
        } else {
            map.put("msg_check","✔");
            map.put("msg_flag",true);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
