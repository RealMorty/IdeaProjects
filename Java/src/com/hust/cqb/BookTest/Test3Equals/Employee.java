package com.hust.cqb.BookTest.Test3Equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month-1, day);
        this.hireDay = gregorianCalendar.getTime();
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

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Double.compare(employee.salary, salary) == 0 &&
//                Objects.equals(name, employee.name) &&
//                Objects.equals(hireDay, employee.hireDay);
//    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(name, salary, hireDay);
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Double.compare(employee.salary, salary) == 0 &&
//                Objects.equals(name, employee.name) &&
//                Objects.equals(hireDay, employee.hireDay);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}

class Manager extends Employee {
    private double bonus = 0;
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary+bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Manager manager = (Manager) o;
//        return Double.compare(manager.bonus, bonus) == 0;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return super.toString() +
                "{bonus=" + bonus +
                '}';
    }
}
