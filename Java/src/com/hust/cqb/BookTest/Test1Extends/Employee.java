package com.hust.cqb.BookTest.Test1Extends;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 雇员子函数
 */
public class Employee {
    //field
    private String name;
    private double salary;
    private Date hireDay;

    //construction
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
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

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + getSalary() +
                ", hireDay=" + hireDay +
                '}';
    }
    //method
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

}

class Manager extends Employee {
    /**
     * @param name the employee's name
     */

    private double bonus = 0;
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary+bonus;
    }

    //    public void setBonus(double b) {
//        bonus = b;
//    }
//
}

