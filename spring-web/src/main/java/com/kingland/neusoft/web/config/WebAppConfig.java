package com.kingland.neusoft.web.config;

import com.kingland.neusoft.web.repository.UserRepository;
import com.kingland.neusoft.web.repository.impl.UserRepositoryImpl;
import com.kingland.neusoft.web.service.UserService;
import com.kingland.neusoft.web.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
}
