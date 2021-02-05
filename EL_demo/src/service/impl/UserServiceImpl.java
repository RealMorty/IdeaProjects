package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

import java.util.List;

public class UserServiceImpl implements service.UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }

    @Override
    public void updateUser(User user, Integer id) {
        dao.updateUser(user, id);
    }

    @Override
    public User queryUser(Integer id) {
        return dao.queryUser(id);
    }
}
