package com.kingland.neusoft.redis.repository.impl;

import com.kingland.neusoft.redis.model.User;
import com.kingland.neusoft.redis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static List<User> users = new ArrayList<>();

    static {
        User user1 = new User(1, 25L, "Levin", "levin@126.com", "36984445771");
        User user2 = new User(2, 20L, "Gavin", "gavin@126.com", "558847711");
        users.add(user1);
        users.add(user2);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optionalUser =
                users.stream().filter(user -> Objects.equals(id, user.getId())).findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) throws Exception {
        int id = user.getId();
        Optional<User> originalUserOptional =
                users.stream().filter(oriUser->Objects.equals(id,oriUser.getId())).findFirst();
        if(originalUserOptional.isPresent()){
            User originalUser = originalUserOptional.get();
            originalUser.setAge(user.getAge());
            originalUser.setName(user.getName());
            originalUser.setEmailAddress(user.getEmailAddress());
            originalUser.setIdNo(user.getIdNo());
            return originalUser;
        }else{
            throw new Exception("The user doesn't exist.");
        }
    }
}
