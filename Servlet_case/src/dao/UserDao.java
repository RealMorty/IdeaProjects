package dao;

import domin.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class UserDao {
    /**
     * 操作数据库中User表的类
     */
    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return 包含用户全部数据
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginUser){
        try {
            String TABLE_NAME = "user";
            String Element1 = "username";
            String Element2 = "password";
            String sql = "select * from "+TABLE_NAME+" where "+Element1+" = ? and "+Element2+" = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
