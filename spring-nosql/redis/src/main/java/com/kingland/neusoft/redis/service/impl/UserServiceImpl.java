package com.kingland.neusoft.redis.service.impl;



import com.kingland.neusoft.redis.model.User;
import com.kingland.neusoft.redis.repository.UserRepository;
import com.kingland.neusoft.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    @Cacheable(key="#id",value = "redisExpire1h")
    public User getUserById(int id) {
        logger.info("We will get User here.");
        return userRepository.getUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    @CacheEvict(key = "#user.id",value = "redisExpire1h")
    public User updateUser(User user) throws Exception {
        logger.info("We will update a User here.");
        return userRepository.updateUser(user);
    }


}
