package com.hust.cqb.BookTest.Test3Equals;

import java.util.ArrayList;
import java.util.HashMap;

public class EqualsTest {
    public static void main(String[] args) {
        Employee employee = new Employee("Morty", 400000, 2022, 10, 15);
        Employee employee1 = employee;
        Employee employee2 = new Employee("Morty", 400000, 2022, 10, 15);
        Employee employee3 = new Employee("Rick", 800000, 2012, 7, 1);

        System.out.println("employee==employee1:" + (employee == employee1)); //true
        System.out.println("employee==employee2:" + (employee == employee2)); //false
        System.out.println("employee.equals(employee1):" + employee.equals(employee1)); //true
        System.out.println("employee.equals(employee2):" + employee.equals(employee2)); //true
        System.out.println("employee.equals(employee3):" + employee.equals(employee3)); //false

        System.out.println("employee3.toString(): " + employee3);
//        System.out.println("employee: "+employee.hashCode());
//        System.out.println("employee2: "+employee2.hashCode());


//        Employee e1 = new Employee("xiaoming",1,1,1,1);
//        Employee e2 = new Employee("xiaoming",1,1,1,1);
//        Employee e3 = new Employee("goudan",1,1,1,1);
//        HashMap<Employee,Integer>map = new HashMap<>(64);
//        map.put(e1,1);
//        map.put(e2,2);
//        map.put(e3,1);
//
//        for (Employee e : map.keySet()) {
//            System.out.println(e.getName()+":"+map.get(e));
//        }
        Manager daisy = new Manager("Daisy", 200000, 2022, 11, 7);
        Manager daisy1 = new Manager("Daisy", 200000, 2022, 11, 7);
        daisy1.setBonus(10000);

        System.out.println("daisy1.toString(): " + daisy1);//daisy1.toString(): Employee{name='Daisy', salary=200000.0, hireDay=Mon Nov 07 00:00:00 CST 2022}{bonus=10000.0}
        System.out.println("daisy.equals(daisy1): " + daisy.equals(daisy1));//false
        System.out.println("employee.hashCode(): " + employee.hashCode());//1716867095
        System.out.println("employee2.hashCode(): " + employee2.hashCode());//1716867095
        System.out.println("employee3.hashCode(): " + employee3.hashCode());//-1276663594
        System.out.println("daisy.hashCode(): " + daisy.hashCode());//-449876948
        System.out.println("daisy1.hashCode(): " + daisy1.hashCode());//636679212

        System.out.println(daisy.getName());//返回类的名字Daisy
    }
}
