package com.example.demotest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Test1 {
    @Spy
    List<String> list=new ArrayList<>();

    @Test
    void test(){
        list.add("one");
        list.add("two");

        System.out.println(list);
        Mockito.verify(list).add("one");
        Mockito.verify(list).add("two");
        Assertions.assertEquals(2,list.size());

//        Mockito.when(list.size()).thenReturn(100);
//        Assertions.assertEquals(100,list.size());
    }
}
