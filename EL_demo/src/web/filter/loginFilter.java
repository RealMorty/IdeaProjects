package web.filter;

import domain.RootUser;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @implNote 登录验证的过滤器
 */
@WebFilter("/*")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        System.out.println(request);
        //1.强转
        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();
        //要注意排除图片验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/")
                || uri.contains("/fonts/") || uri.contains("/CheckCodeServlet") || uri.contains("/ChangeCode")) {
            chain.doFilter(request, response);
        } else {
            Object rootUser = (RootUser) req.getSession().getAttribute("rootUser");
            if (rootUser != null) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("errorReason3", "您尚未登陆，请登录");
                req.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }

    }
}
