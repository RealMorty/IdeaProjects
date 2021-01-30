package Java.src.com.hust.cqb.SuperTest.Scratches;


import Java.src.com.hust.cqb.SuperTest.Day01.Reflect.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化，资源申请
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * 释放资源方法
     * 所有程序执行完后，自动执行该方法
     */
    @After
    public void close() {
        System.out.println("close...");
    }



    /**
     * 测试add方法
     */
    @Test
    public void testAdd() {
//        System.out.println("done!");
        //1.创建计算器对象
        System.out.println("testAdd...");
        Calculator c = new Calculator();
        //调用add方法
        double result = c.add(1, 2);
//        System.out.println(result);
        //3.断言 断言结果是3
        Assert.assertEquals(3,result, 4);
    }

    @Test
    public void testSub() {
        Calculator c = new Calculator();
//        double result = c.sub(1, 2);
        double expected = -1;
        System.out.println("testSub...");
//        Assert.assertEquals(expected, result, 0.001);
    }
}
