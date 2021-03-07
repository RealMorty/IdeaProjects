package pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Person {
    @Resource(name = "dog122")
    private Dog dog;
    @Resource(name = "cat12")
    private Cat cat;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public Cat getCat() {
        return cat;
    }

    public String getName() {
        return name;
    }

}
