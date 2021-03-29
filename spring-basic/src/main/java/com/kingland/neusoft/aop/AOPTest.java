package com.kingland.neusoft.aop;

import com.kingland.neusoft.aop.config.AOPConfig;
import com.kingland.neusoft.common.service.Show;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AOPConfig.class);
        Show show = applicationContext.getBean(Show.class);
        show.show();
    }
}
