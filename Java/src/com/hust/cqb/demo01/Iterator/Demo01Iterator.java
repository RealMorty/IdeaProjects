package com.hust.cqb.demo01.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * java.util.Iterator接口：迭代器（对集合Collection进行遍历）
 * 有两个常用的方法：
 * 1、boolean hasNext()：如果仍有元素可以迭代，则返回true
 * 2、next():返回迭代的下一个元素
 * Collection接口中有一个方法，叫iterator()，这个方法返回的就是迭代器的实现类对象
 * Iterator<E> iterator() 返回在此collection的元素上进行迭代的迭代器
 * @author 15827
 */
public class Demo01Iterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("科比");
        coll.add("姚明");
        coll.add("姚明");
        coll.add("科比");

        coll.add("姚明");
        coll.add("科比");
        coll.add("科比");
        coll.add("麦迪");

        Iterator<String> it = coll.iterator();
        boolean b = it.hasNext();
        System.out.println(b);
        String s = it.next();
        System.out.println(s);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
