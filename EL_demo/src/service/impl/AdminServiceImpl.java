package service.impl;

import dao.AdminDao;
import dao.UserDao;
import dao.impl.AdminDaoImpl;
import dao.impl.UserDaoImpl;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();
    @Override
    public Boolean checkAdmin(String username, String password) {
        return dao.checkAdmin(username,password);
    }
}
