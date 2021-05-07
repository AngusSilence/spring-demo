package com.kingland.neusoft.cloud.servicediscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceDiscoveryServerApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }

}
