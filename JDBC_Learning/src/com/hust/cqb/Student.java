package JDBC_Learning.src.com.hust.cqb;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthday;
    }

    public void setBirthDate(Date birthDate) {
        this.birthday = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthday +
                '}';
    }
}
