package web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/resetUserServlet")
public class resetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name",null);
        request.setAttribute("address",null);
        request.setAttribute("email",null);

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> stringSet = parameterMap.keySet();
//        System.out.println("================stringSet==================");
//        for (String s : stringSet) {
//            System.out.println(Arrays.toString(parameterMap.get(s)));
//        }
        request.getRequestDispatcher("/findUserByPageServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
