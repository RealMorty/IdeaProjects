package JDBC_Learning.src.com.hust.cqb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class test04 {
    public static void main(String[] args) throws SQLException {
        Student student = new Student();
        Connection connection = JdbcUtils.getConnection();
        String TABLE_NAME = "student";
        String FIELD_NAME_1 = "id";
        String sql = "select * from "+TABLE_NAME+" where "+FIELD_NAME_1+"=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,2);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getBoolean("gender"));
            student.setBirthDate(rs.getDate("birthDay"));
        }
        JdbcUtils.close(connection, ps, rs);
        System.out.println(student);
    }
}
