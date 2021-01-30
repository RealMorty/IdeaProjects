package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

public class ReflectDemo01 {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.hust.cqb.SuperTest.Day01.Reflect.Person");
            System.out.println(aClass);
            System.out.println(Person.class);

            Person p = new Person();
            System.out.println(p.getClass());

            System.out.println(aClass==Person.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
