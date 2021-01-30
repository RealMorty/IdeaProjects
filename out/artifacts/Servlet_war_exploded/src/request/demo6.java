package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo6")
public class demo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        System.out.println("GET:");
//        System.out.println(username);
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String s = parameterNames.nextElement();
//            System.out.println(s);
//            String value = request.getParameter(s);
//            System.out.println(value);
//        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> stringSet = parameterMap.keySet();
        for (String s : stringSet) {
            String[] strings = parameterMap.get(s);
            System.out.println(s);
            for (String string : strings) {
                System.out.print(string);
                System.out.print(",");
            }
            System.out.println("----------------------");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
