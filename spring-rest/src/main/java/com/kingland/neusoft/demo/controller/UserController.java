package com.kingland.neusoft.demo.controller;

import com.kingland.neusoft.demo.model.User;
import com.kingland.neusoft.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> userList(Model model) {
       return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "add-user";
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping("/userDetail")
    public String userDetail(Model model,
                             @RequestParam int userId) {
        model.addAttribute("user", userService.getUserById(userId));
        return "user-detail";
    }
}
