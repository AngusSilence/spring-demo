package com.kingland.neusoft.redis.controller;

import com.kingland.neusoft.redis.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UserController {

    @GetMapping("/user/all")
    List<User> getAllUserList();

    @PostMapping("/user")
    ResponseEntity<User> addUser(@RequestBody User user, BindingResult result);

    @GetMapping("/user/{userId}")
    ResponseEntity<User> getUserById(@PathVariable int userId);

    @PutMapping("/user")
    ResponseEntity<User> updateUser(@RequestBody User user, BindingResult result) throws Exception;
}
