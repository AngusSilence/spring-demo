package com.kingland.neusoft.demo.controller;

import com.kingland.neusoft.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public interface UserController {

    @GetMapping("/user/all")
    List<User> getAllUserList();

    @PostMapping("/user")
    ResponseEntity<User> addUser(@RequestBody @Valid User user, BindingResult result);

    @GetMapping("/user/{userId}")
    ResponseEntity<User> getUserById(@PathVariable int userId);
}
