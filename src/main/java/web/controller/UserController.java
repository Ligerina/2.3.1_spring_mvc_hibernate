package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<User> userList = userService.getListUser();

        model.addAttribute("UserList", userList);
        return "Users";
    }

    @RequestMapping("/addUser")
    public String addNewUser(ModelMap model){

        User user = new User();
        model.addAttribute("user1",user);

        return "AddUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("User") User user){

        userService.addUser(user.getName(),user.getSurname(),user.getDepartment(),user.getLocation());

        return "/";
    }

}
