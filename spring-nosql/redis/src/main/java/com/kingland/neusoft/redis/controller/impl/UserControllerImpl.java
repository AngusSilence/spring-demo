package com.kingland.neusoft.redis.controller.impl;

import com.kingland.neusoft.redis.controller.UserController;
import com.kingland.neusoft.redis.model.User;
import com.kingland.neusoft.redis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public class UserControllerImpl implements UserController {

    private UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAllUserList() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity<User> addUser(User user, BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalArgumentException("There is invalid parameter.");
        }
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> getUserById(int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(User user, BindingResult result) throws Exception {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }


}
