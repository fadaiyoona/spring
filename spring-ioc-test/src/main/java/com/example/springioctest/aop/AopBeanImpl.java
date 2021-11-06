package com.example.springioctest.aop;

import org.springframework.stereotype.Component;

@Component("aopBean")
public class AopBeanImpl implements AopBean {
    @Override
    public void sayHello() {
        System.out.println("hello world...");
    }
}
