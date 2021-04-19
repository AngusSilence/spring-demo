package com.kingland.neusoft.es.controller;

import com.kingland.neusoft.es.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UserController {


    @PostMapping("/user")
    ResponseEntity<User> addUser(@RequestBody User user, BindingResult result);

    @GetMapping("/user/{userId}")
    ResponseEntity<User> getUserById(@PathVariable int userId);

    @PutMapping("/user")
    ResponseEntity<User> updateUser(@RequestBody User user, BindingResult result) throws Exception;

    @GetMapping("/user/name/{userName}")
    ResponseEntity<List<User>> getUserByName(@PathVariable("userName") String userName);
}
