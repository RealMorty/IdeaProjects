package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询所有用户
     */
    public List<User> findAll();

    void addUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user, Integer id);

    User queryUserById(Integer id);

    void delSelectedUsers(String[] checkBoxIds);

    PageBean<User> currentPageBean(Integer currentPage, Integer rows, Map<String,String[]> condition);
}
