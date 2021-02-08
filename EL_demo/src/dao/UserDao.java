package dao;

import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();
    void addUser(User user);
    void deleteUser(Integer id);
    void updateUser(User user, Integer id);
    User queryUserById(Integer id);
    Integer findTotalCount(Map<String, String[]> condition);
    List<User> findListByPage(int startPage, int rows, Map<String, String[]> condition);

}
