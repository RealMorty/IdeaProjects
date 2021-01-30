package JDBC_Learning.src.com.hust.cqb;

import java.sql.*;
import java.util.Scanner;

public class test03 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        login(name,password);
    }

    private static void login(String name, String password) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from user where name=? and password=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,password);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功："+name);
        }
        else {
            System.out.println("登录失败");
        }
        JdbcUtils.close(connection,ps,resultSet);
    }
}
