package com.kingland.neusoft.gradle.impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalTime;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MyTestServiceImplTest extends TestCase {


    @Test
    public void testSayHello(){
        LocalTime localDateTime = LocalTime.of (9,12);
        MyTestServiceImpl myTestService = Mockito.mock(MyTestServiceImpl.class);
        Mockito.doCallRealMethod().when(myTestService).sayHello(anyString());
        when(myTestService.getTime()).thenReturn(localDateTime);
        assertEquals("Hey, Levin, you should go to move bricks~",
                myTestService.sayHello("Levin"));
    }
}