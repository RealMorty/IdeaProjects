package com.hust.cqb.demo02.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author : JavaMorty
 * @date :
 */
/*public class CalcAgeToDay {
    public static void main(String[] args) throws ParseException {
        Scanner bir = new Scanner(System.in);
        *//**System.out.println("Pls input your birthday(xxxx/xx/xx):");
        String str1 = bir.nextLine();
        System.out.println(str1);
        Date date1 = new Date(str1);*//*
        *//*Date date2 = new Date(15651413513465L);
        Date date3 = new Date(17651413513465L);
        Date date6 = new Date(18551413513465L);

        System.out.println(date2);
        System.out.println(date3);*//*

        *//**boolean flag = date2.after(date3);
        System.out.println(flag);
        Object date4 = date3.clone();
        System.out.println(date4);
        int com1 = date2.compareTo(date3);
        System.out.println(com1);
        Date date5 = date3;
        System.out.println(date3.equals(date5));
        int com2 = date5.compareTo(date3);
        System.out.println(com2);
        int com3 = date6.compareTo(date3);
        System.out.println(com3);
//        System.out.println(date1.toString());
 * @author 15827*/
        /**
        Date now = new Date();
        Object temp = now;
        System.out.println(now instanceof Object);
//        if (temp instanceof String) {
//            temp = (String) temp;
//        } else {
//            temp = null;
//        }
        char c= '2';
        System.out.println(Character.isAlphabetic(c));
//        System.out.println(now.getTime());
        System.out.println(getBirthDays());




//        int millisec = now.getDay();

    }
    private static int getBirthDays() throws ParseException {
        //1997-12-1
        System.out.println("please enter birthday formatter:yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        //这是当前的时间
        Date now = new Date();
        long nowTime = now.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(input);
        long date1Time = date1.getTime();
        long diffTime = nowTime-date1Time;
        int days = (int) (diffTime/(1000*60*60*24));
        return days;
    }
}*/
public class CalcAgeToDay {
    public static void main(String[] args) throws ParseException {
        CalcDays();
    }
    private static void CalcDays() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls input your birthday(Format: yyyy/mm/dd):");
        String str = sc.nextLine();
        System.out.println(str);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
        Date date1 = dateFormat.parse(str);
        Date date2 = new Date();
        System.out.println(date2);

        long millisecond1 = date1.getTime();
        long millisecond2 = date2.getTime();
        System.out.println(millisecond1);
        System.out.println(millisecond2);

        int days = (int)((millisecond2 - millisecond1)/1000/60/60/24);
        System.out.println("You have survived for "+ days +" days!");
    }
}














