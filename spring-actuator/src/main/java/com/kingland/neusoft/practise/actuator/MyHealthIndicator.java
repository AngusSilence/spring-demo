package com.kingland.neusoft.practise.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
       return Health.outOfService().up()
               .withDetail("MyTest","Health").build();
    }
}
