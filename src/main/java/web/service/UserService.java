package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public interface UserService {

    List<User> getListUser();
    void addUser(String name, String surname, String department, String location);
    User getUser(int id);

}
