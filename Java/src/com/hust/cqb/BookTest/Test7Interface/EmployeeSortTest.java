package com.hust.cqb.BookTest.Test7Interface;

//import org.jetbrains.annotations.NotNull;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * This program demonstrates the use of the Comparable interface.
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];

        staff[0] = new Employee("Morty", 400000);
        staff[1] = new Employee("Daisy", 200000);
        staff[2] = new Employee("aisy", 200000);
        staff[3] = new Employee("Rick", 800000);

        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public int compareTo(@NotNull Employee o) {
        if(salary==o.salary)
            return name.compareTo(o.name);
        else if(salary>o.salary)
            return 1;
        else
            return -1;
    }
}
//class Boss implements Comparator<Boss> {
//    @Override
//    public int compare(Boss o1, Boss o2) {
//        return 0;
//    }
//}

