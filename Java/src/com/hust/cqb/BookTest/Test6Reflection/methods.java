package com.hust.cqb.BookTest.Test6Reflection;

import java.lang.reflect.*;
import com.hust.cqb.BookTest.Test3Equals.Employee;

/**
 * 代码展示了如何通过反射调用methods
 */
public class methods {
    public static void main(String[] args) {
        //get method pointers to the square and sqrt methods
        Method square = null;
        Method sqrt = null;
        try {
            square = methods.class.getMethod("square", double.class);
            sqrt = Math.class.getMethod("sqrt", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //print tables of x- and y-values

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    public static double square(double x) {
        return x * x;
    }

    private static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x++) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


}
