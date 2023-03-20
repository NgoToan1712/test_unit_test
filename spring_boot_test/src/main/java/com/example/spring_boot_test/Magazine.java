package com.example.spring_boot_test;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("magazine")
public class Magazine implements Document{
    @Override
    public String content() {
        return "This is a fashion magazine";
    }
}
