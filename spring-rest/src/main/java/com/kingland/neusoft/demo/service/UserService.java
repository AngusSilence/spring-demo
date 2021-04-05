package com.kingland.neusoft.demo.service;


import com.kingland.neusoft.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);
}
