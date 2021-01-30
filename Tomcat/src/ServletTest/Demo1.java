package ServletTest;
/**
 * Servlet方法
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Demo1")
public class Demo1 implements Servlet{


    /**
     * 初始化方法，在Servlet被创建时执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.....");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法，每一次被访问时执行
     * @return
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }

    /**
     * 获取Servlet一些信息，版本，作者。。。
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在Servlet被杀死时执行
     * 在服务器正常关闭时执行
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
