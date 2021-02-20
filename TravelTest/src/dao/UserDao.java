package dao;

import domain.User;

public interface UserDao {
    boolean findUserByName(String name);
    User findUserByCode(String code);
    void updateStatus(User user);
    void addUser(User user);
    boolean checkUser(String username,String password);
}
