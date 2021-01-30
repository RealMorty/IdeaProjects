package com.hust.cqb;


import java.util.*;

/**
 * @author 15827
 */
/**
public class CollectionTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int N=10;
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }
        for (Integer i : list) {
            System.out.print(i+" ");
        }
        System.out.println();
        int old = list.set(3,5);
        System.out.println(old);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
*/
class Test01 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("Morty");
        coll.add("is");
        coll.add("Hero");
        coll.add("Rick");
        System.out.println(coll);

        boolean result = coll.remove("Hero");
        boolean result1 = coll.contains("Rick");
        Object[] arr = coll.toArray();
        //遍历数组
        for(Object str: arr){
            System.out.println(str);
        }
        System.out.println(result1);
        System.out.println(result);
        /*coll.clear();*/
        System.out.println(coll);
    }
}
