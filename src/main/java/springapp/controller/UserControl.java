package springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springapp.entity.User;
import springapp.service.UserService;

import java.util.List;

@Controller
//@RequestMapping ("/")
public class UserControl {

    private final UserService userService;

    @Autowired
    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allusrs", allUsers);
        return "all-users";
    }

    @GetMapping("/create-user")
    public String userForm(@ModelAttribute("user") User user) {
        return "create-user";
    }

    @PostMapping("/create-user")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update-user/{id}")
    public String fillUserForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }

    @PostMapping("/update-user")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}


