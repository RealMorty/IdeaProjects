package com.hust.cqb.BookTest.Test5Enum;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size(SMALL, MEDIUM, LARGE, EXTRA_LARGE): ");
        String input = scanner.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size= "+size);
        System.out.println("Abbreviation="+size.getAbbreviation());
        if(size == Size.EXTRA_LARGE) {
            System.out.println("Good Job!");
        }
    }
}
