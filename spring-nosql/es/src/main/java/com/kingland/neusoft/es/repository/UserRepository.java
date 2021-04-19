package com.kingland.neusoft.es.repository;


import com.kingland.neusoft.es.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findUserByName(String name);
}
