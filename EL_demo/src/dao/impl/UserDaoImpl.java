package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.N;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from el_jstl.user";
        List<User> users = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));

        return users;
    }



    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO el_jstl.user (name, gender, age, address, qq, email)\n" +
                "    VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM el_jstl.user WHERE id = ?;";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateUser(User user,Integer id) {
        String sql = "UPDATE el_jstl.user SET name=?,gender=?,age=?,address=?,qq=?,email=? WHERE id=?";
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),id);
    }

    @Override
    public User queryUser(Integer id) {
        String sql = "SELECT * FROM el_jstl.user WHERE id="+id+";";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
        return user;
    }
}
