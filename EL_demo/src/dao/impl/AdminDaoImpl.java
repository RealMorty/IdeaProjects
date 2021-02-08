package dao.impl;

import dao.AdminDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public boolean checkAdmin(String username, String password) {
        try {
            String sql = "SELECT * FROM el_jstl.admin WHERE username=? AND password=?;";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
//        jdbcTemplate
    }
}
