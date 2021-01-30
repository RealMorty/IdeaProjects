package Java.src.com.hust.cqb.BookTest.Test8Clone;

public class CloneTest4 {
    public static void main(String[] args) {
        try {
            CloneTest2.Student student1 = new CloneTest2.Student(22,"morty");
            Teacher teacher1 = new Teacher();
            teacher1.setStudent(student1);
            teacher1.setName("Dr.Rick");

            Teacher teacher2 = (Teacher) teacher1.clone();
            teacher2.setName("Dr.Ham");
            CloneTest2.Student student2 = (CloneTest2.Student) teacher2.getStudent();
            student2.setName("daisy");
            student2.setAge(22);

            System.out.println(teacher1);
            System.out.println(teacher2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class Teacher implements Cloneable {
        private String name;
        private CloneTest2.Student student;

//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//            Teacher teacher = (Teacher) super.clone();
//            teacher.setStudent((CloneTest2.Student) teacher.getStudent().clone());
//            return teacher;
//        }


        @Override
        protected Object clone() throws CloneNotSupportedException {
            Teacher teacher = (Teacher) super.clone();
            student = teacher.getStudent().clone();
            teacher.setStudent(student);
            return teacher;
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
            sb.append(", student=").append(student);
            sb.append('}');
            return sb.toString();
        }


    }

}
