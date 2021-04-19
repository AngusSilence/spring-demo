package com.kingland.neusoft.es.service.impl;

import com.kingland.neusoft.es.model.User;
import com.kingland.neusoft.es.repository.UserRepository;
import com.kingland.neusoft.es.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUserById(int id) {
        logger.info("We will get User here.");
       Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
            return null;
        }
    }

    @Override
    public User addUser(User user) {
        return (User)userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        logger.info("We will update a User here.");
        return (User)userRepository.save(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.findUserByName(name);
    }


}
