package com.kingland.neusoft.ioc;

import com.kingland.neusoft.common.service.Show;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The main method used for IoC test.
 *
 * @author Levin Zhang
 */
public class IoCTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.kingland.neusoft");
        Show show = applicationContext.getBean(Show.class);
        show.show();
        System.out.println("Test");
    }
}
