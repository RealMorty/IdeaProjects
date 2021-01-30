package Java.src.com.hust.cqb.BookTest.Test8Clone;



import java.util.*;

/**
 * This program demonstrates cloning.
 */


public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("Morty", 400000);
            original.setHireDay(2022,10,15);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2022, 11,07);
            System.out.println("original: "+original);
            System.out.println("copy: "+copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}

class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public Employee clone() throws CloneNotSupportedException {
        //call Object.clone()
        Employee cloned = (Employee) super.clone();

        //clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Set the hireDay to a given date.
     * @param year the year of the hire day
     * @param month the month of the hire day
     * @param day the day of the hire day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", hireDay=").append(hireDay);
        sb.append('}');
        return sb.toString();
    }
}
