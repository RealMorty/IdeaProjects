package com.hust.cqb.BookTest;

import com.hust.cqb.BookTest.Test3Equals.Employee;
import com.hust.cqb.BookTest.Test3Equals.EqualsTest;

import java.text.DateFormatSymbols;
import java.util.*;

public class Scratch {
    public static void main(String[] args) {
//        long starttime = System.currentTimeMillis();
        demo07();
//        long endtime = System.currentTimeMillis();
//        System.out.println(endtime-starttime);
    }

    private static void demo07() {
            Map<String,String> map = new HashMap<String, String>();

            map.put("xiaocui1","gongchen");
            map.put("xiaocui3","daima");
            map.put("xiaocui3","daima");
            map.put("xiaocui4","dagong");

            System.out.println(map.keySet());
        System.out.println(map.get("xiaocui1"));

            System.out.println("-----分割线-----");
            for(String map1 : map.keySet()){
                System.out.println(map1);
            }
    }

    private static void demo06() {
        String s = "java.util.Date";
        Class cl1 = Date.class;
        Class cl2 = int.class;
        Class cl3 = Integer.class;
        Class cl4 = Double.class;
        Class cl5 = Scratch.class;
        Class cl7 = EqualsTest.class;

        try {
            Object m = Class.forName(s).newInstance();
            Class cl = Class.forName(s);
            Class cl6 = Class.forName("com.hust.cqb.BookTest.Test3Equals.Manager");
            System.out.println(m.getClass());
            System.out.println(cl);
            System.out.println(cl1);
            System.out.println(cl2);
            System.out.println(cl3);
            System.out.println(cl4);
            System.out.println(cl5);
            System.out.println(cl6);
            System.out.println(cl7);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void demo05() {
        Date date = new Date();
        Class<? extends Date> aClass = date.getClass();
        String name = aClass.getName();

        String className = "java.util.Date";
        Class<?> aClass1 = null;
        try {
            aClass1 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass1);
        System.out.println(int.class);
        System.out.println(Employee.class);

        String s = "java.util.Date";
        Date m = null;
        try {
            m = (Date)Class.forName(s).newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("m: "+m);
    }

    private static void demo04() {
        Employee e = new Employee("m", 1,1,1,1);
        String c1 = e.getClass().getName();
        System.out.println(c1+"   "+e.getSalary());
    }

    private static void demo03() {
        int[] LuckNumbers = {2, 3, 5, 7, 11, 13};
        String s = ""+LuckNumbers;
        System.out.println(s);//[I@1b6d3586
        String s1 = Arrays.toString(LuckNumbers);
        System.out.println(s1);//[2, 3, 5, 7, 11, 13]

    }

    private static void demo02() {
        String s = "OK";
        StringBuilder stringBuilder = new StringBuilder(s);
//        String t = new String("OK");
        String t = "OK";
        StringBuilder stringBuilder1 = new StringBuilder(t);
        System.out.println("s:"+s.hashCode());
        System.out.println("stringBuilder:"+stringBuilder.hashCode());
        System.out.println("t:"+t.hashCode());
        System.out.println("stringBuilder1:"+stringBuilder1.hashCode());
        System.out.println(s==t);
    }

    private static void demo01() {
        /**
         * 根据程序运行时的日期打印当前月的日历
         */
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int today = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int month = gregorianCalendar.get(Calendar.MONTH);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH,1);
        int weekday = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = gregorianCalendar.getFirstDayOfWeek();
        int index = 0;
        while (weekday != firstDayOfWeek)
        {
            index++;
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
            weekday = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
        }
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s",weekdayNames[weekday]);
            gregorianCalendar.add(Calendar.DAY_OF_WEEK,1);
            weekday = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();
        for (int i=0;i<index;i++) System.out.print("   ");
        gregorianCalendar.set(Calendar.DAY_OF_MONTH,1);
        do {
            int day = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if(day==today) System.out.print("*  ");
            else System.out.print("   ");
            gregorianCalendar.add(Calendar.DAY_OF_MONTH,1);
            weekday = gregorianCalendar.get(Calendar.DAY_OF_WEEK);
            if(weekday==firstDayOfWeek) System.out.println();
        } while (gregorianCalendar.get(Calendar.MONTH) ==month);
        System.out.println();
    }
}
