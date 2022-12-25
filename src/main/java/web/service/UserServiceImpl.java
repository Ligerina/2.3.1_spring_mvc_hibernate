package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListUser() {
        return userDao.getListUser();
    }

    @Override
    @Transactional
    public void addUser(String name, String surname, String department, String location) {
        userDao.addUser(name, surname, department, location);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
