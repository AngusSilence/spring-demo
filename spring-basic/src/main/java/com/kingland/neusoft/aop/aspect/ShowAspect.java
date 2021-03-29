package com.kingland.neusoft.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class ShowAspect {
    @Pointcut("execution( * com.kingland.neusoft.common.Artist.*(..))")
    private void playerPoint(){}

    @Before("playerPoint()")
    public void welcome(){
        System.out.println("Welcome~");
    }

    @After("playerPoint()")
    public void clap(){
        System.out.println("Hand clap~");
    }

    @AfterThrowing("playerPoint()")
    public void boo(){
        System.out.println("boo~");
    }

}
