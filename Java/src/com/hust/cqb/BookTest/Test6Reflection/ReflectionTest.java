package com.hust.cqb.BookTest.Test6Reflection;


import java.lang.reflect.*;
import java.util.*;


public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = scanner.next();
        }
//        System.out.println(name);

        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print("modifiers为"+modifiers+" ");
            System.out.print("class " + name);
            if (supercl != null && supercl != Object.class) System.out.print(" extends " + supercl.getName());

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        System.out.println("Field描述类的域");
        for (Field f: fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.println(type.getName()+" "+name+";");
        }
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        System.out.println("Method描述类的方法");
        for (Method m :methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.println("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName()+" "+name+"(");

            Class[] paramTypes = m.getParameterTypes();
            for (int j=0;j < paramTypes.length;j++) {
                if (j>0) System.out.println(", ");
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all constructors of a class
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        System.out.println("Constructor描述类的构造器");
        for (Constructor c: constructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j=0; j<paramTypes.length; j++) {
                if (j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(")");
        }
    }
}
