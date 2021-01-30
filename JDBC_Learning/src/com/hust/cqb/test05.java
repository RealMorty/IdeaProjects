package JDBC_Learning.src.com.hust.cqb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test05 {
    public static void main(String[] args) throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = JdbcUtils.getConnection();
        String TABLE_NAME = "student";
        String sql = "select * from "+TABLE_NAME;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getBoolean("gender"));
            student.setBirthDate(resultSet.getDate("birthday"));
            students.add(student);
        }
        JdbcUtils.close(connection,preparedStatement,resultSet);
        for (Student stu:students){
            System.out.println(stu);
        }
    }
}
