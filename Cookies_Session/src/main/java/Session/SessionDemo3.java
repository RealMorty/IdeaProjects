package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo3")
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //共享数据
        HttpSession session = request.getSession();
        Cookie jsession = new Cookie("JSESSION", session.getId());
        jsession.setMaxAge(60 * 60);
        response.addCookie(jsession);
        System.out.println(session);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
