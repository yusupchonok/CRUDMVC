package web.service;

import web.model.User;

import java.util.List;



public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(User user);
}