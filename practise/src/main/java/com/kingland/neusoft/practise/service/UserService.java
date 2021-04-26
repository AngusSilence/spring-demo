package com.kingland.neusoft.practise.service;



import com.kingland.neusoft.practise.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    User addUser(User user);

    User updateUser(User user) throws Exception;
}
