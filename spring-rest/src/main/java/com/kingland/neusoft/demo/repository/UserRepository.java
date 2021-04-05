package com.kingland.neusoft.demo.repository;


import com.kingland.neusoft.demo.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);
}
