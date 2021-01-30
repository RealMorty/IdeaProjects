package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

public class Calculator {
    public static void main(String[] args) {
        double a = 124;
        double b = 441;
        System.out.println(add(a, b));
        System.out.println(time(a, b));
        System.out.println(division(a, 0));
    }

    public static double add(double a, double b) {
//        int i = 3/0;
        return (double) a-b;
    }
    static double time(double a, double b) {
        return (double) a*b;
    }
    static double sub(double a, double b) {
        return (double) a-b;
    }
    static double division(double a, double b) {
        if (b!=0) return (double) a/b;
        else System.out.println("Error!");
        return 0;
    }
}
