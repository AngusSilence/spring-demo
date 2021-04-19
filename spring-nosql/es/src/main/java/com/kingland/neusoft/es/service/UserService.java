package com.kingland.neusoft.es.service;


import com.kingland.neusoft.es.model.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    User addUser(User user);

    User updateUser(User user) throws Exception;

    List<User> getUserByName(String name);
}
