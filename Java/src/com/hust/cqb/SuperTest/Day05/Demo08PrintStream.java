package com.hust.cqb.SuperTest.Day05;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo08PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("FileTest/test04.txt");
        ps.write(97);
        ps.println(97);
        ps.println('a');
        ps.println(97);
        ps.println(true);
        ps.println(97);
        ps.close();
    }
}
