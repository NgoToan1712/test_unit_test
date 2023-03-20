package com.example.spring_boot_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        System.out.println("---------------Trước khi Ioc Container được khởi tạo");

        ApplicationContext context=SpringApplication.run(SpringBootTestApplication.class, args);


        System.out.println("---------------Sau khi Ioc Container được khởi tạo");


        Library library=context.getBean(Library.class);

        library.setName("ha noi");
        System.out.println("Name: "+library.getName());
        Library library1=context.getBean(Library.class);
        System.out.println("Name: "+library1.getName());
//        System.out.println(library1);
//        System.out.println(library);


        System.out.println(library.getDocument().content());

        System.out.println("---------------Trước khi IoC destroy library");
        ((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(library);
        System.out.println("--------------Sau khi Ioc destroy Company");

    }

}
