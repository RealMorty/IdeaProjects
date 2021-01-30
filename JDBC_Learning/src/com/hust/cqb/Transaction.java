package JDBC_Learning.src.com.hust.cqb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    public static void main(String[] args) throws SQLException {
        Double VALUE = 500.0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String TABLE_NAME = "account";
            String FIELD_NAME1 = "balance";
            String FIELD_NAME2 = "name";
            String sql1 = "update "+TABLE_NAME+" set "+FIELD_NAME1+"="+FIELD_NAME1+"+? where "+FIELD_NAME2+"=?;";
            System.out.println(sql1);
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setDouble(1,VALUE);
            preparedStatement.setString(2,"张三");
            preparedStatement.executeUpdate();
            System.out.println(100/0);
            String sql2 = "update "+TABLE_NAME+" set "+FIELD_NAME1+"="+FIELD_NAME1+"-? where "+FIELD_NAME2+"=?;";
            System.out.println(sql2);
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setDouble(1,VALUE);
            preparedStatement.setString(2,"李四");
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("转账成功");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("转账失败");
        }
        finally {
            JdbcUtils.close(connection,preparedStatement);
        }
    }
}
