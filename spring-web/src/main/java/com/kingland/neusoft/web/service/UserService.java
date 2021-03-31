package com.kingland.neusoft.web.service;

import com.kingland.neusoft.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);
}
