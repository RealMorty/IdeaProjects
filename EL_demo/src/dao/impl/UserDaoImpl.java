package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JdbcUtils;

import java.util.*;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from el_jstl.user;";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }


    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO el_jstl.user (name, gender, age, address, qq, email)\n" +
                "    VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM el_jstl.user WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateUser(User user, Integer id) {
        String sql = "UPDATE el_jstl.user SET name=?,gender=?,age=?,address=?,qq=?,email=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(), id);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "SELECT * FROM el_jstl.user WHERE id=?;";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Override
    public Integer findTotalCount(Map<String, String[]> condition) {
        String sqlTotalCount = "select count(*) from el_jstl.user";
        StringBuffer sqlBuffer = new StringBuffer(sqlTotalCount);
        Set<String> pageSet = condition.keySet();
        boolean isFirst = true;
        List<Object> pageInfo = new ArrayList<>();
        for (String s : pageSet) {
            if (s.equals("currentPage")) {
                continue;
            }
            String info = condition.get(s)[0];
            if (!info.equals("")) {
                pageInfo.add("%"+info+"%");
                if (isFirst) {
                    sqlBuffer.append(" where ").append(s).append(" like ?");
                    isFirst = false;
                    continue;
                }
                sqlBuffer.append(" and ").append(s).append(" like ?");
            }
        }
        sqlBuffer.append(";");
        Object[] objects = pageInfo.toArray();

//        System.out.println(stringBuilder.toString());
//        System.out.println(params);
        Integer totalCount = jdbcTemplate.queryForObject(sqlBuffer.toString(), Integer.class, objects);
//        System.out.println("totalCount:" + totalCount);
//        System.out.println(sqlBuffer.toString());
//        for (Object object : objects) {
//            System.out.println("Object:"+object.toString());
//        }

        return totalCount;
    }

    @Override
    public List<User> findListByPage(int startPage, int rows, Map<String, String[]> condition) {
        String sqlCurrentList = "select * from el_jstl.user";
        StringBuffer sqlBuffer = new StringBuffer(sqlCurrentList);
        Set<String> pageSet = condition.keySet();
        boolean isFirst = true;
        List<Object> pageInfo = new ArrayList<>();
        for (String s : pageSet) {
            if (s.equals("currentPage")) {
                continue;
            }
            String info = condition.get(s)[0];
            if (!info.equals("")) {
                pageInfo.add("%"+info+"%");
                if (isFirst) {
                    sqlBuffer.append(" where ").append(s).append(" like ?");
                    isFirst = false;
                    continue;
                }
                sqlBuffer.append(" and ").append(s).append(" like ?");
            }
        }
        sqlBuffer.append(" limit ?,?;");
        pageInfo.add((startPage < 1 ? 0 : (startPage - 1)) * rows);
        pageInfo.add(rows);
//        String[] objects = (String[]) pageInfo.toArray();
//        System.out.println("============Objects============");
//        pageInfo.forEach(System.out::println);
//        System.out.println("============findListByPage======");
//        System.out.println("findListByPage:" + sqlBuffer.toString());

        List<User> users;
        users = jdbcTemplate.query(sqlBuffer.toString(),
                new BeanPropertyRowMapper<>(User.class), pageInfo.toArray());
//        System.out.println("================Users===============");
//        users.forEach(System.out::println);
        return users;
    }
}
