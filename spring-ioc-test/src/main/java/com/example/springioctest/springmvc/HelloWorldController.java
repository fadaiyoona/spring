package com.example.springioctest.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        System.out.println("hello world...");
        return "hello world";
    }

}
