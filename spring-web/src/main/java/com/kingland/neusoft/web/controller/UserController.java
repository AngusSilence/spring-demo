package com.kingland.neusoft.web.controller;

import com.kingland.neusoft.web.model.User;
import com.kingland.neusoft.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
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
