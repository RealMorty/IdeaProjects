package com.hust.cqb.SuperTest.Day06;

/**
 * 函数式接口的使用，作为方法的参数和返回值类型
 */
public class Demo {
    public static void show(FunctionInterface myInter){
        myInter.method();
    }

    public static void main(String[] args) {
        show(new MyFunctionInterface());

        show(new MyFunctionInterface(){
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        show(()->{
            System.out.println("Lambda表达式");
        });
        show(()->System.out.println("Lambda表达式"));
    }
}
