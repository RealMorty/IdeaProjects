package com.hust.cqb.BookTest.Test6Reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 利用反射监听一个程序
 */

public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i=1; i<=5; i++) squares.add(i*i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}

class ObjectAnalyzer {
    /**
     * 将object对象中的所有域用字符串列出
     * @param obj an object
     * @return a string with the object's class name and all field names and
     * values
     */
    private ArrayList<Object> visited = new ArrayList<Object>();
    public String toString(Object obj) {
        if (obj==null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i=0;i< Array.getLength(obj);i++) {
                if (i>0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();

        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f:fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Object val = f.get(obj);
                        r += toString(val);
                    }
                    catch (Exception e) { e.printStackTrace(); }
                }
            }
            r += "]\n";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }

}