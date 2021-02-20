package service;

import domain.User;

public interface UserService {
    boolean isUserNameExists(String name);

    void register(User user);

    boolean active(String code);

    User login(String username, String password);
}
