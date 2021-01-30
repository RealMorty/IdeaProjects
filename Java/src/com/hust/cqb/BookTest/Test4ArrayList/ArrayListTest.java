package com.hust.cqb.BookTest.Test4ArrayList;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Morty", 400000, 2022, 10, 15));
        employees.add(new Employee("Daisy", 200000, 2022, 11, 7));
        employees.add(new Employee("Rick", 800000, 2012, 7, 1));

        employees.add(1,new Employee("Beth", 5000000, 2000,3,17));
//        employees.remove(2);


        for (Employee employee : employees) {
            employee.raiseSalary(5);
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
