package com.example.springioctest.BeanCurrentlyInCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {
    @Autowired
    private BeanA beanA;

//    private BeanA beanA;
//
//    public void setBeanA(BeanA beanA) {
//        this.beanA = beanA;
//    }

    public void sayHello() {
        System.out.println(getClass().getSimpleName() + " hello world...");
    }
}
