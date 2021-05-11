package com.kingland.neusoft.config.demo.config;

import com.kingland.neusoft.config.demo.controller.UserController;
import com.kingland.neusoft.config.demo.controller.impl.UserControllerImpl;
import com.kingland.neusoft.config.demo.service.UserProvider;
import com.kingland.neusoft.config.demo.service.impl.UserProviderLocalImpl;
import com.kingland.neusoft.config.demo.service.impl.UserProviderRemoteImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class Config {
    @Bean
    UserController userController(UserProvider userProvider){
        return new UserControllerImpl(userProvider);
    }

//        @Bean
//    UserController userController(List<UserProvider> userProviders){
//        return new UserControllerImpl(userProviders);
//    }

    @Bean
    @Order(2)
    //@Profile("local")
   // @Primary
    UserProvider userProviderLocal(){
        return new UserProviderLocalImpl();
    }

    @Bean
    @Order(1)
   //@Profile("remote")
   @ConditionalOnMissingBean(UserProvider.class)
    UserProvider userProviderRemote(){
        return new UserProviderRemoteImpl();
    }

    @Bean
    UserConfiguration userConfiguration(){
            return new UserConfiguration();
    }
}
