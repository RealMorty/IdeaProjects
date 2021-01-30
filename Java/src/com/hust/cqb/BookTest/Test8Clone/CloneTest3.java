package Java.src.com.hust.cqb.BookTest.Test8Clone;

public class CloneTest3 {
    public static void main(String[] args) {
        try {
            CloneTest2.Student student1 = new CloneTest2.Student(22, "morty");
            Teacher teacher1 = new Teacher();
            teacher1.setName("Dr.Rick");
            teacher1.setAge(45);
            teacher1.setStudent(student1);

            Teacher teacher2 = (Teacher) teacher1.clone();
            CloneTest2.Student student2 = teacher2.getStudent();

            teacher2.setName("Dr.Ham");
            teacher2.setAge(46);
            student2.setAge(23);
            student2.setName("daisy");

            System.out.println(teacher1);
            System.out.println(teacher2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    static class Teacher implements Cloneable {
        private String name;
        private int age;
        private CloneTest2.Student student;

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

        public CloneTest2.Student getStudent() {
            return student;
        }

        public void setStudent(CloneTest2.Student student) {
            this.student = student;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Teacher{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append(", student=").append(student);
            sb.append('}');
            return sb.toString();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
