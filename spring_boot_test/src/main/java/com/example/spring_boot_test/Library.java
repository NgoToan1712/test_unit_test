package com.example.spring_boot_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    //    @Autowired
//    @Qualifier("magazine")
    private Document document;

    private String name;

//    @Autowired
//    public Library(Document document) {
//        this.document = document;
//    }

    @Autowired
    public void setDocument(Document document) {
        this.document = document;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("--------------Đối tượng khởi tạo sẽ vào hàm này");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("--------------Đối tượng trước khi bị destroy thì sẽ chạy hàm này");
    }
}
