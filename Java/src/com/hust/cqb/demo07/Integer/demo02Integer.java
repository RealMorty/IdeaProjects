package com.hust.cqb.demo07.Integer;

/**
 * @author : JavaMorty
 * @date :
 *
 */

import java.util.ArrayList;

/**
 * 自动装箱与拆箱
 * 基本类型和包装类自动相互转换
 */
public class demo02Integer {
    public static void main(String[] args) {
        Integer in = 1; //自动装箱

        //自动拆箱：in是包装类，无法直接参与运算，可以自动转换为基本类型的数据再参与计算
        //in + 2:就相当于 in.intValue() + 3 = 3;
        //in = in + 2；就相当于 in = new Integer(3)自动装箱
        in = in + 2;
        System.out.println(in);

        //ArrayList集合无法直接存储整数，可以存储Integer包装类
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); //自动装箱 list.add(new Integer(1))

        int a = list.get(0); //自动拆箱 list.get(0).intValue()
    }
}
