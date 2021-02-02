package dao;

import domian.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
