package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterDemo3 implements Filter {
    //启动服务器后创建filter对象，调用 此方法
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    //服务器正常关闭后销毁
    public void destroy() {
        System.out.println("destroy...");
    }

    //每次请求资源时被执行，执行多次
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(request, response);
    }
}
