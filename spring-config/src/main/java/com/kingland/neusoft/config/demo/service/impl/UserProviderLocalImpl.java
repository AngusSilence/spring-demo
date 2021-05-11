package com.kingland.neusoft.config.demo.service.impl;

import com.kingland.neusoft.config.demo.model.User;
import com.kingland.neusoft.config.demo.service.UserProvider;

import java.util.ArrayList;
import java.util.List;

public class UserProviderLocalImpl implements UserProvider {
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Focus",20));
        users.add(new User("Ida",21));
        users.add(new User("Alan",22));
        users.add(new User("Austin",23));
        return users;
    }
}
