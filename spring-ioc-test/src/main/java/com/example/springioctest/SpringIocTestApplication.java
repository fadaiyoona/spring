package com.example.springioctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIocTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocTestApplication.class, args);
        System.out.println("hello world...");
    }

}
