package web.filter;

import domain.User;

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
                || uri.contains("/fonts/") || uri.contains("/error/") || uri.contains("/CustomerRegisterServlet")
                || uri.contains("/checkCode") || uri.contains("/images/")
                || uri.contains("/img/") || uri.contains("/register.jsp") || uri.contains("/index.jsp")
                || uri.contains("/isCheckCodeRightServlet") || uri.contains("/isUserNameExists")
                || uri.contains("/activeUserServlet") || uri.contains("/RegisterVerify.jsp")) {
            chain.doFilter(request, response);
        } else {
            User user = (User) req.getSession().getAttribute("CurrentUser");
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("errorReason", "您尚未登陆，请登录");
                req.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }

    }
}
