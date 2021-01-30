package JDBC_Learning.src.com.hust.cqb;
//import com.mysql.jdbc.Driver;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
////
//public class test01 {
//
//    static {
//        try {
//            DriverManager.registerDriver(new Driver());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
////        MyDriver myDriver = new MyDriver();
//        //Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day02","root","root");
//        Statement statement = connection.createStatement();
//        String sql = "";
//        ResultSet resultSet = statement.executeQuery(sql);
//
//
//    }
//}


import java.sql.*;
import java.util.Properties;

/** * 得到连接对象 */

public class test01 {
    private static Connection connection = null;
    private static Statement statement = null;
    private static String url = "jdbc:mysql://localhost:3306/day02";
    private static String username = "root";
    private static String password = "root";
    public static void main(String[] args) throws SQLException {
        t07();
    }

    private static void t07() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        int counter = 0;
        counter+=statement.executeUpdate("insert into user " +
                "values (null,'root','root')," +
                "       (null,'user1','user1');");
        System.out.println("插入了"+counter+"条记录");
        statement.close();
        connection.close();
    }

    private static void t06() throws SQLException {
        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();

            statement.executeUpdate("create table user (" +
                    "id int PRIMARY key auto_increment," +
                    "name varchar(20) not null, " +
                    "password varchar(20) not null" +
                    ");");
            System.out.println("创建表成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    private static void t05() throws SQLException {
        connection = DriverManager.getConnection(url,username,password);
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from student;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean gender = rs.getBoolean("gender");
            Date birthday = rs.getDate("birthday");
            System.out.println("编号："+id+
                               "，姓名："+name+
                               "，性别："+gender+
                               "，生日："+birthday);
        }
        rs.close();
        statement.close();
        connection.close();
    }

    private static void t04() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        int counter = 0;
        counter+=statement.executeUpdate("insert into student " +
                "values (null,'孙悟空',1,'1993-02-18')," +
                "       (null,'白骨精',0,'1995-03-22')," +
                "       (null,'猪八戒',1,'1903-03-24')," +
                "       (null,'嫦娥',0,'1993-05-14')");
        System.out.println("插入了"+counter+"条记录");
        statement.close();
        connection.close();
    }

    private static void t03() throws SQLException {
        /**
         * 创建一张学生表
         */
        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();

            statement.executeUpdate("create table student1 (" +
                                        "id int PRIMARY key auto_increment," +
                                        "name varchar(20) not null, " +
                                        "gender boolean, " +
                                        "birthday date" +
                                        ");");
            System.out.println("创建表成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    private static void t02() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
    }

    private static void t01() throws SQLException {
        Connection getConnection = DriverManager.getConnection(url, "root", "root");
        System.out.println(getConnection);
        Statement statement = (Statement) getConnection.createStatement();
        String sql = "select * from account";
        Object result = statement.executeQuery(sql);
        System.out.println(result.toString());
    }

}
