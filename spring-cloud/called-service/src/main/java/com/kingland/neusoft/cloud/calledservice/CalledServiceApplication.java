package com.kingland.neusoft.cloud.calledservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CalledServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalledServiceApplication.class, args);
    }

}
