package JDBC_Learning.src.com.hust.cqb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test06 {
    public static void main(String[] args) throws SQLException {
//        insert();
//        update();
        delete();
    }

    private static void delete() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String TABLE_NAME = "student";
        String FIELD_NAME = "id";
        String sql = "delete from "+TABLE_NAME+" where "+FIELD_NAME+"=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,5);
        int row = preparedStatement.executeUpdate();
        System.out.println("更新了"+row+"条数据。");
        JdbcUtils.close(connection,preparedStatement);
    }

    private static void update() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String TABLE_NAME = "student";
        String FIELD_NAME1 = "name";
        String FIELD_NAME2 = "birthday";
        String FIELD_NAME3 = "id";

        String sql = "update "+TABLE_NAME+" set "+FIELD_NAME1+"=?,"+FIELD_NAME2+"=? where "+FIELD_NAME3+"=?;";
        System.out.println(sql);
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"黑熊怪");
        preparedStatement.setDate(2, Date.valueOf("1998-05-21"));
        preparedStatement.setInt(3,5);
        int row= preparedStatement.executeUpdate();
        System.out.println("更新"+row+"条记录");
        JdbcUtils.close(connection,preparedStatement);
    }

    private static void insert() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String TABLE_NAME = "student";
        String sql = "insert into "+TABLE_NAME+" values (null,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"小白龙");
        preparedStatement.setBoolean(2,true);
        preparedStatement.setDate(3, Date.valueOf("1999-11-11"));
        int row = preparedStatement.executeUpdate();
        System.out.println("插入了"+row+"条记录。");
        JdbcUtils.close(connection,preparedStatement);
    }
}
