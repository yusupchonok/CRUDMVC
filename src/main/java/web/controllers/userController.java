package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
public class userController {
    private UserService userService;
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping( "/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam(required = false) String id, Model model) {
        int userId = Integer.parseInt(id);
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam(required = false) String id) {
        int userId = Integer.parseInt(id);
        User user = userService.getUser(userId);
        userService.deleteUser(user);
        return "redirect:/";
    }

}