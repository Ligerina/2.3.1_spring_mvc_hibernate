package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {
    List<User> getListUser();
    void addUser(String name, String surname, String department, String location);
    User getUser(Long id);
    void updateUser(User user);
    void deleteUser(User user);
}
