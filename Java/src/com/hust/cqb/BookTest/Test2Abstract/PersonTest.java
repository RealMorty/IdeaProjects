package com.hust.cqb.BookTest.Test2Abstract;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("Morty", 400000, 2022, 10, 15);
        people[1] = new Student("Daisy", "Economic");

        for (Person p : people) {
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }
}
