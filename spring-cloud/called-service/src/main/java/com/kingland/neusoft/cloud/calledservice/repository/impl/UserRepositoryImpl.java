package com.kingland.neusoft.cloud.calledservice.repository.impl;



import com.kingland.neusoft.cloud.calledservice.model.User;
import com.kingland.neusoft.cloud.calledservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static List<User> users = new ArrayList<>();

    static {
        User user1 = new User(1, 25, "Levin", "levin@126.com", "36984445771");
        User user2 = new User(2, 20, "Gavin", "gavin@126.com", "558847711");
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
}
