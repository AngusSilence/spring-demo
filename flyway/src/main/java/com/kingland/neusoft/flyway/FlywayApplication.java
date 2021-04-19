package com.kingland.neusoft.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class FlywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class, args);
    }

    @Bean
    CommandLineRunner flyway(DataSource dataSource){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Flyway flyway = Flyway.configure()
                        .schemas("flyway_test")
                        .dataSource(dataSource).load();
                flyway.migrate();
            }
        };
    }
}
