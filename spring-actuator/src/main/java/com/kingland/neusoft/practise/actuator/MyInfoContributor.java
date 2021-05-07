package com.kingland.neusoft.practise.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

public class MyInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("testKey1","AAA");
        builder.withDetail("testKey2","BBB");
    }
}
