package com.kingland.neusoft.web.repository;

import com.kingland.neusoft.web.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);
}
