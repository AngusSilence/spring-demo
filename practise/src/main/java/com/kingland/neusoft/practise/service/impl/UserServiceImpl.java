package com.kingland.neusoft.practise.service.impl;



import com.kingland.neusoft.practise.mapper.UserDao;
import com.kingland.neusoft.practise.model.User;
import com.kingland.neusoft.practise.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userRepository;

    public UserServiceImpl(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.selectAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public User addUser(User user) {
         userRepository.insert(user);
         return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) throws Exception {
        if(user.getId()==null||user.getId()<=0){
            throw new Exception("The user id is invalid");
        }
        User originalUser = userRepository.selectByPrimaryKey(user.getId());
        if(originalUser==null){
            throw new Exception("We cannot find user by the input parameter.");
        }
        userRepository.updateByPrimaryKey(user);
        return user;
    }


}
