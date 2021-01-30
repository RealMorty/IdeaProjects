package Java.src.com.hust.cqb.BookTest.Test8Clone;

/**
 * other example of clone
 */

public class CloneTest2 {
    public static void main(String[] args) {
        try {
            Student morty = new Student(22, "Morty");
            Student daisy = morty.clone();
            daisy.setName("Daisy");
            daisy.setAge(21);
            System.out.println(morty);
            System.out.println(daisy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static class Student implements Cloneable {
        private int age;
        private String name;

        public Student clone() throws CloneNotSupportedException {
            return (Student) super.clone();
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Student{");
            sb.append("age=").append(age);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
