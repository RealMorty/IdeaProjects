package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebServlet("/user/*")
public class userServlet extends baseServlet {
    private UserService service = new UserServiceImpl();

    /**
     * 判断验证码是否正确
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void VerifyCheckCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        String check = request.getParameter("check");

        Map<String, Object> map = new HashMap<>();
        if (!checkcode_server.equalsIgnoreCase(check) || check.equals("") ||
                check.length() == 0) {
            map.put("msg_check", "❌");
            map.put("msg_flag", false);
        } else {
            map.put("msg_check", "✔");
            map.put("msg_flag", true);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    /**
     * 判断注册时的用户名是否已经存在
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void CheckUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        Map<String, Object> map = new HashMap<>();
        if (service.isUserNameExists(username) || username.equals("")) {
            map.put("msg_username", "❌");
            map.put("msg_flag", false);
        } else {
            map.put("msg_username", "✔");
            map.put("msg_flag", true);
        }

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(), map);
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Map<String, String[]> register_info = request.getParameterMap();
        User RegisterUser = new User();
        try {
            BeanUtils.populate(RegisterUser, register_info);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        service.register(RegisterUser);
        HttpSession session = request.getSession();
        session.setAttribute("active", true);
        session.setAttribute("CurrentUser", RegisterUser);
        session.removeAttribute("CHECKCODE_SERVER");
        request.getRequestDispatcher("/emailVerify.jsp").forward(request, response);
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> login_inf = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, login_inf);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //判断用户名和密码是否正确
        HttpSession session = request.getSession();
        session.setAttribute("active", false);
        User checkUser = service.login(login_inf.get("username")[0],
                login_inf.get("password")[0]);

        if (checkUser == null) {
            request.setAttribute("loginError", "❌用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        if (checkUser != null && !"Y".equals(checkUser.getStatus())) {
            request.setAttribute("loginError", "❌您尚未激活，请激活");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (checkUser != null && "Y".equals(checkUser.getStatus())){
            session.setAttribute("CurrentUser", checkUser);
            session.setAttribute("active", true);
            request.getSession().removeAttribute("CHECKCODE_SERVER");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    /**
     * 退出登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void Exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    /**
     * 用户激活
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void Active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code != null) {
            boolean flag = service.active(code);

            String msg = null;
            if (flag) {
                msg = "激活成功，点此<a href='login.jsp'>登录</a>";
            } else {
                msg = "激活失败，请联系管理员！";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/RegisterVerify.jsp").forward(request, response);
        }
    }

    /**
     * 创建验证码
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void CreateCheckCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0, 0, width, height);

        //产生4个随机验证码，12Ey
        String checkCode = getCheckCode();
        //将验证码放入HttpSession中
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写入验证码
        g.drawString(checkCode, 15, 25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

}
