package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();
}
