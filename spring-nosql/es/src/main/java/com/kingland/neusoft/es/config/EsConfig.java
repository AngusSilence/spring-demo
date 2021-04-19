package com.kingland.neusoft.es.config;


import com.kingland.neusoft.es.controller.UserController;
import com.kingland.neusoft.es.controller.impl.UserControllerImpl;
import com.kingland.neusoft.es.service.UserService;
import com.kingland.neusoft.es.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories
public class EsConfig {

    @Bean
    UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    UserController userController() {
        return new UserControllerImpl(userService());
    }

}
