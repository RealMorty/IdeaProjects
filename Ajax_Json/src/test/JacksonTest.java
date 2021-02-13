package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {
    //Java对象转为Jason
    @Test
    public void test1() {
        Person p1 = new Person();
        p1.setName("Morty");
        p1.setAge(23);
        p1.setGender("male");

        ObjectMapper mapper = new ObjectMapper();

        /**
         * writeValue(参数,obj)
         * writeValueAsString(obj):将对象转换为json字符串
         */
        try {
            String json = mapper.writeValueAsString(p1);
            mapper.writeValue(new FileWriter("C:\\Users\\Morty\\Desktop\\b.txt"),p1);
//            mapper.writeValue(new File("C:\\Users\\Morty\\Desktop\\a.txt"),p1);
//            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws Exception {
        Person p = new Person();
        p.setName("Morty");
        p.setAge(23);
        p.setGender("male");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(p);
        System.out.println(string);
    }

    @Test
    public void test3() throws Exception {
        Person p1 = new Person();
        p1.setName("Morty");
        p1.setAge(23);
        p1.setGender("male");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("Morty");
        p2.setAge(23);
        p2.setGender("male");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("Morty");
        p3.setAge(23);
        p3.setGender("male");
        p3.setBirthday(new Date());

        List<Person> ps = new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(ps);
        System.out.println(string);
    }

    @Test
    public void test4() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Morty1");
        map.put("age","23");
        map.put("gender","male");




        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(map);
        System.out.println(string);
    }

    //json-->java
    @Test
    public void test5() throws Exception {
        String json = "{\"gender\":\"male\",\"name\":\"Morty1\",\"age\":\"23\"}";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }

}
