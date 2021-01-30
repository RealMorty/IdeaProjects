package com.hust.cqb.SuperTest.Day02;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        Person[] array = {
                new Person("柳岩",38),
                new Person("迪丽热巴",18),
                new Person("古力娜扎",19)
        };

//        Arrays.sort(array,new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() -o2.getAge();
//            }
//        });
        Arrays.sort(array,(Person o1, Person o2)->{
            return o2.getAge() -o1.getAge();
        });
        for (Person person : array) {
            System.out.println(person);
        }
    }
}
