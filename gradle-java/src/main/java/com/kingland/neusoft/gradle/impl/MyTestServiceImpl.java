package com.kingland.neusoft.gradle.impl;

import com.kingland.neusoft.gradle.MyTestService;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class MyTestServiceImpl implements MyTestService {
    @Override
    public String sayHello(String name) {
        String greeting;
        int hours = getTime().getHour();
        if(hours>=22||hours<=6){
            greeting = "go to sleep~~";
        }else{
            greeting = "go to move bricks~";
        }
        return "Hey, "+ name+", you should "+greeting;
    }

    public LocalTime getTime(){
        return LocalTime.now();
    }
}
