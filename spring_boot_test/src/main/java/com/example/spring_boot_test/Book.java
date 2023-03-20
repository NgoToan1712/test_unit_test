package com.example.spring_boot_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component("book")

public class Book implements Document{

    @Override
    public String content() {
        return "this is a book";
    }

}
