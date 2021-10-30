package com.example.springioctest.BeanCurrentlyInCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    /**
     * 这种方式注入，因为使用了@Async，导致BeanA是被代理过的，这样Spring处理循环依赖时，
     * 一开始实例化的BeanA，与注册完BeanB后拿到的BeanA不是相同的对象，就会报错
     *
     * 解决方案有几种，
     * 1、是使用setter方式注入
     * 2、通过BeanPostProcessor，判断如果是BeanA，手动进行组件的注入
     * @see CurrentInCreationPostProcessor
     */
    @Autowired
    private BeanB beanB;
//
//    private BeanB beanB;
//
//    public void setBeanB(@Autowired BeanB beanB) {
//        this.beanB = beanB;
//    }
//
//    private BeanB beanB;
//
//    public void setBeanB(BeanB beanB) {
//        this.beanB = beanB;
//    }

    @Async
    public void sayHello() {
        System.out.println(getClass().getSimpleName() + " hello world...");
    }
}
