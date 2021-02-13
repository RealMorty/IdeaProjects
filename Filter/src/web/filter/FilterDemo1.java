package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")//访问所有资源之前都会执行该过滤器
public class FilterDemo1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo1 is init successfully!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1 is running...");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("FilterDemo1 is returning...");
    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo1 is destroyed successfully!");
    }
}
