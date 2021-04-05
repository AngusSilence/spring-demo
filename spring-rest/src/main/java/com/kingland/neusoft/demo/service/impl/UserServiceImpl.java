package com.kingland.neusoft.demo.service.impl;


import com.kingland.neusoft.demo.model.User;
import com.kingland.neusoft.demo.repository.UserRepository;
import com.kingland.neusoft.demo.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }
}
