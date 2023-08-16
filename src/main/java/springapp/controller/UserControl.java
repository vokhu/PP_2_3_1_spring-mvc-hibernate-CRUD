package springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springapp.entity.User;
import springapp.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserControl {


    private final UserService userService;
    @Autowired
    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allusr", allUsers);
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("usr", userService.getUserById(id));
        return "oneUser";
    }
}


