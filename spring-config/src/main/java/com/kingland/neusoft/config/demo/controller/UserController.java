package com.kingland.neusoft.config.demo.controller;

import com.kingland.neusoft.config.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserController {
    @GetMapping("/user/all")
    List<User> getAllUser();
}