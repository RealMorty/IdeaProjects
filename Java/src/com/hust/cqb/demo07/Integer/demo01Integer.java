package com.hust.cqb.demo07.Integer;

/**
 * @author : JavaMorty
 * @date :
 */

/**
 * 装箱：把基本类型变成包装类
 *      构造方法：
 *      1、Integer(int value)
 *          构造一个新分配的 Integer对象，该对象表示指定的 int值。
 *      2、Integer(String s)·
 *          构造一个新分配 Integer对象，表示String参数所指示的int值。
 *          传递的字符串必须是基本类型的字符串，否则会抛出异常，比如：“100”正确；“a”异常
 *      静态方法：
 *      static Integer valueOf(int i)   返回一个表示指定的int值的Integer实例
 *      static Integer valueOf(String s)   返回保存指定的值的String的值的 Integer对象
 *拆箱：在包装类中取出基本类型的数据（包装类->基本类型）
 *      成员方法：
 *      intValue():以int类型返回该Integer的值
 */
public class demo01Integer {
    public static void main(String[] args) {
        Integer in1 = new Integer("1");
        Integer in2 = Integer.valueOf("1");
        System.out.println(in1);

        int i = Integer.valueOf(in2);
        System.out.println(i);
    }
}
