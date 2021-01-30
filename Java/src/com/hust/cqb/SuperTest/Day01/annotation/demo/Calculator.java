package Java.src.com.hust.cqb.SuperTest.Day01.annotation.demo;

public class Calculator {
    @Check
    public void add() {
//        int i = 3/0;
        System.out.println(1+5/0);
    }
    @Check
    public void time() {
        System.out.println(1*4);
    }
    @Check
    public void sub() {
        System.out.println(1-5/0);
    }
    @Check
    public void division() {
        System.out.println(1/0);
    }

    public void Say() {
        System.out.println("Never used!");
    }
}
