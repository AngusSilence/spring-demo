package com.kingland.neusoft.cloud.calledservice.service;

import com.kingland.neusoft.cloud.calledservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);
}
