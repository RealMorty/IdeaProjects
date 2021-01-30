package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

public class Person {
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", a='").append(a).append('\'');
        sb.append(", b='").append(b).append('\'');
        sb.append(", c='").append(c).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void eat() {
        System.out.println("Eat...");
    }

    public void eat(String food) {
        System.out.println("eat..."+food);
    }
}
