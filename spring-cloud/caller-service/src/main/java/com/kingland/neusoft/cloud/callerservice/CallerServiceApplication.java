package com.kingland.neusoft.cloud.callerservice;

import com.kingland.neusoft.cloud.callerservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class CallerServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CallerServiceApplication.class, args);
    }


}
