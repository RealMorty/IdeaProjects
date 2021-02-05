package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     */
    public List<User> findAll();

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(User user, Integer id);

    public User queryUser(Integer id);
}
