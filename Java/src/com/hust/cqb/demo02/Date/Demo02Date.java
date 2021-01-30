package com.hust.cqb.demo02.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.Format;
/**
 * @author : JavaMorty
 * @date :
 */
public class Demo02Date {
    public static void main(String[] args) throws ParseException {
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date);
        Date d1 = new Date(0L);
        System.out.println(d1.toString());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        String str = "2018年04月15日 09:08:32";
        Date d2 = simpleDateFormat.parse(str);
        System.out.println(d2);

    }
}
