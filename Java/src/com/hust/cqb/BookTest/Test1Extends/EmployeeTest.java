package com.hust.cqb.BookTest.Test1Extends;

/**
 * 雇员主代码
 */

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];

        Manager boss = new Manager("Beth", 5000000, 2017, 07, 01);

        staff[0] = boss;
        staff[1] = new Employee("Morty", 400000, 2022, 10, 15);
        staff[2] = new Employee("Daisy", 300000, 2022, 11, 04);
        staff[3] = new Employee("Rick", 800000, 2012, 07, 01);


        boss.setBonus(3000000);
//        System.out.println(boss.getSalary());

//        for (Employee e:staff) {
//            e.raiseSalary(5);
//        }
        for (Employee e:staff) {
            System.out.println(e);
        }
//        swap(staff[0], staff[1]);
//        System.out.println(staff[0]+"\n"+staff[1]);

        System.out.println(boss.getClass().getName()+"   "+boss.getName());
    }

    /*private static void swap(Employee staff, Employee staff1) {
        Employee temp = staff;
        staff = staff1;
        staff1 = temp;
    }*/
}

