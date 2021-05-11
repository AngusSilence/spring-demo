package com.kingland.neusoft.config.demo.service.impl;

import com.kingland.neusoft.config.demo.model.User;
import com.kingland.neusoft.config.demo.service.UserProvider;

import java.util.ArrayList;
import java.util.List;

public class UserProviderRemoteImpl implements UserProvider {
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Anthony",20));
        users.add(new User("Joey",21));
        users.add(new User("Gavin",22));
        users.add(new User("Levin",23));
        users.add(new User("Jack",24));
        users.add(new User("Felix",25));
        return users;
    }
}
