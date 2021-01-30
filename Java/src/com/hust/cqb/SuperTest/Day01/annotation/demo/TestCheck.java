package Java.src.com.hust.cqb.SuperTest.Day01.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculator c = new Calculator();
        int number = 0;
        Writer out;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        Class aClass = c.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(c);
                    System.out.println("进入方法了");
                } catch (Exception e) {
                    number++;
                    bw.write(method.getName()+"方法出异常");
                    bw.newLine();
                    bw.write("异常名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------------------");
                    bw.newLine();
//                    e.printStackTrace();

                }
            }
        }
        bw.write("共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
