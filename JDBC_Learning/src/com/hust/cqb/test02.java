package JDBC_Learning.src.com.hust.cqb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test02 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        login(name, password);
    }

    private static void login(String name, String password) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String TABLE_NAME = "user";
            String FIELD_NAME1 = "name";
            String FIELD_NAME2 = "password";
            String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FIELD_NAME1+"='"+name+"'"+" AND "+FIELD_NAME2+"= '"+password+"'";
            System.out.println(sql);
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println("登录成功，欢迎您："+ name);
            }   else {
                System.out.println("登录失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }   finally {
            JdbcUtils.close(connection,statement,rs);
        }
    }
}
