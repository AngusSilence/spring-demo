package com.kingland.neusoft.gradle;

import com.kingland.neusoft.gradle.impl.MyTestServiceImpl;

public class Test {
    public static void main(String[] args) {
        MyTestService myTestService = new MyTestServiceImpl();
        System.out.println(myTestService.sayHello("Levin"));
    }
}
