package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class baseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("baseServlet的service方法被执行啦。。。");
        String uri = request.getRequestURI();
        System.out.println("请求uri:"+uri);
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("方法名称："+methodName);
        System.out.println(this);

        try {
            Method method = this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将传入的对象序列化为json，并返回客户端
     * @param object
     * @param response
     * @throws IOException
     */
    public void writeValue(Object object, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset:utf-8");
        mapper.writeValue(response.getOutputStream(),object);
    }

    /**
     * 将传入的对象序列化为json，返回
     * @param object
     * @return
     * @throws IOException
     */
    public String writeValueAsString(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}
