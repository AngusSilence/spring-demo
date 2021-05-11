package com.kingland.neusoft.config.demo.controller.impl;

import com.kingland.neusoft.config.demo.config.UserConfiguration;
import com.kingland.neusoft.config.demo.controller.UserController;
import com.kingland.neusoft.config.demo.model.User;
import com.kingland.neusoft.config.demo.service.UserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class UserControllerImpl implements UserController {
    @Value("${user.maxCount}")
    int maxCount;

    public UserControllerImpl(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

//    public UserControllerImpl(List<UserProvider> userProviders) {
//        this.userProviders = userProviders;
//    }

    private UserProvider userProvider;

    private List<UserProvider> userProviders;

    @Autowired
    private UserConfiguration userConfiguration;

    @Override
    public List<User> getAllUser() {
        return userProvider.getUsers();


//        System.out.println(userConfiguration.getMaxCount());
//        List<User> result = new ArrayList<>();
//        if(!CollectionUtils.isEmpty(userProviders)){
//            userProviders.stream()
//                    .forEach(userProvider1->result.addAll(userProvider1.getUsers()));
//        }
//        if(result.size()>maxCount){
//          return result.subList(0,maxCount);
//        }else{
//            return result;
//        }

    }
}
