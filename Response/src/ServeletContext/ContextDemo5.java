package ServeletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ContextDemo5")
public class ContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String b = servletContext.getRealPath("/b.txt");//web目录下的文件访问
        System.out.println(b);
        String c = servletContext.getRealPath("/WEB-INF/c.txt");//web-inf下的文件访问
        System.out.println(c);
        String a = servletContext.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
