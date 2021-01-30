package com.hust.cqb.SuperTest.Day01.annotation;

import java.lang.reflect.Method;

/**
 * 框架类
 */
@Pro(className = "com.hust.cqb.SuperTest.Day01.annotation.Test1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        String className = annotation.className();
        String s = annotation.methodName();
        System.out.println(className+"      " +s);

        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(s);
        String name = method.getName();
        System.out.println(name);
        System.out.println(className);
    }
}
