package dao.DaoImpl;

import com.alibaba.druid.util.JdbcUtils;
import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    String TABLE_NAME = "customerlist.tab_user";

    @Override
    public boolean findUserByName(String name) {
        try {
            String Element1 = "username";
            String sql = "select * from " + TABLE_NAME + " where " + Element1 + " = ? ;";
            List<User> query = template.query(sql, new BeanPropertyRowMapper<>(User.class), name);
//            System.out.println(query.toString());
            if (query.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findUserByCode(String code) {
        User user = null;
        try {
            String Element1 = "code";
            String sql = "select * from " + TABLE_NAME + " where " + Element1 + " = ? ;";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql = " update " + TABLE_NAME + " set status = 'Y' where uid=?";
        template.update(sql, user.getUid());
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO " + TABLE_NAME + " (username, password, name, birthday, sex, telephone, email, status, code)\n" +
                "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        template.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(),
                user.getSex(), user.getTelephone(), user.getEmail(), user.getStatus(), user.getCode());
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            String Element1 = "username";
            String Element2 = "password";
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + Element1 + "=? AND " + Element2 + "=?;";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }


}
