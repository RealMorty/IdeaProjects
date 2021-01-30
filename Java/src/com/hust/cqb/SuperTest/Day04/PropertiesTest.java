package com.hust.cqb.SuperTest.Day04;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        demo2();
    }

    private static void demo2() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("FileTest/a.txt"));
        Set<String> stringSet = properties.stringPropertyNames();
        for (String key: stringSet) {
            System.out.println(key+"--"+properties.getProperty(key));
        }
    }

    private static void demo1() {
        Properties properties = new Properties();
        properties.setProperty("filename","a.txt");
        properties.setProperty("length","23231223");
        properties.setProperty("location","FileTest");
        System.out.println(properties);
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        Set<String> stringSet = properties.stringPropertyNames();
        for (String key : stringSet) {
            System.out.println(key+"--"+properties.getProperty(key));
        }
    }
}
