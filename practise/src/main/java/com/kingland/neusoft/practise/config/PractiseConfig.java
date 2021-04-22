package com.kingland.neusoft.practise.config;

import com.kingland.neusoft.practise.controller.UserController;
import com.kingland.neusoft.practise.controller.impl.UserControllerImpl;
import com.kingland.neusoft.practise.mapper.UserDao;
import com.kingland.neusoft.practise.service.UserService;
import com.kingland.neusoft.practise.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kingland.neusoft.practise.mapper")
public class PractiseConfig {

    @Bean
    UserService userService(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    @Bean
    UserController userController(UserService userService) {
        return new UserControllerImpl(userService);
    }
}
