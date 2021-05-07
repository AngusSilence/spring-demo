package com.kingland.neusoft.cloud.callerservice.controller;

import com.kingland.neusoft.cloud.callerservice.UserClients;
import com.kingland.neusoft.cloud.callerservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    UserClients userClients;

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable int userId){
        return userClients.getUserById(userId);
    }
}
