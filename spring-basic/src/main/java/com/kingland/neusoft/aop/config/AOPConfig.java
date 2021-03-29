package com.kingland.neusoft.aop.config;

import com.kingland.neusoft.aop.aspect.ShowAspect;
import com.kingland.neusoft.common.Artist;
import com.kingland.neusoft.common.service.Player;
import com.kingland.neusoft.common.service.Show;
import com.kingland.neusoft.common.service.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {
    @Bean
    public Artist singer(){
        return new Singer();
    }

    @Bean
    public Artist player(){
        return new Player();
    }

    @Bean
    public Show show(List<Artist> artistList){
        return new Show(artistList);
    }

    @Bean
    public ShowAspect aspect(){
        return new ShowAspect();
    }
}
