package com.kingland.neusoft.cloud.calledservice.repository;



import com.kingland.neusoft.cloud.calledservice.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);
}
