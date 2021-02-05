package dao;

import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();
    public void addUser(User user);
    public void deleteUser(Integer id);
    public void updateUser(User user, Integer id);
    public User queryUser(Integer id);
}
