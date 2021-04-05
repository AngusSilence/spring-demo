package com.kingland.neusoft.demo.config;

import com.kingland.neusoft.demo.controller.UserController;
import com.kingland.neusoft.demo.controller.impl.UserControllerImpl;
import com.kingland.neusoft.demo.repository.UserRepository;
import com.kingland.neusoft.demo.repository.impl.UserRepositoryImpl;
import com.kingland.neusoft.demo.service.UserService;
import com.kingland.neusoft.demo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig {
    @Bean
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    UserController userController() {
        return new UserControllerImpl(userService());
    }
}
