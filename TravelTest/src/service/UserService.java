package service;

import domain.User;

public interface UserService {
    boolean isUserNameExists(String name);
    void register(User user);
    boolean active(String code);
    boolean checkUser(String username,String password);
}
