package dao;

import domain.User;

import java.util.List;

public interface AdminDao {
    public boolean checkAdmin(String username,String password);
}
