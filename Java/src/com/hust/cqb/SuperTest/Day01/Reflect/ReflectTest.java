package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */

public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //可以创建任意类的对象，可以执行任意方法
//        Person p = new Person();
//        p.eat();
        //1、加载配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类
        Class aClass = Class.forName(className);
        //4.创建对象
        Object obj = aClass.newInstance();
        //5.获取方法对象
        Method method = aClass.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }
}
