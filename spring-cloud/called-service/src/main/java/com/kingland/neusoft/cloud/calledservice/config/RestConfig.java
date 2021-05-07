package com.kingland.neusoft.cloud.calledservice.config;

import com.kingland.neusoft.cloud.calledservice.controller.UserController;
import com.kingland.neusoft.cloud.calledservice.controller.impl.UserControllerImpl;
import com.kingland.neusoft.cloud.calledservice.repository.UserRepository;
import com.kingland.neusoft.cloud.calledservice.repository.impl.UserRepositoryImpl;
import com.kingland.neusoft.cloud.calledservice.service.UserService;
import com.kingland.neusoft.cloud.calledservice.service.impl.UserServiceImpl;
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
