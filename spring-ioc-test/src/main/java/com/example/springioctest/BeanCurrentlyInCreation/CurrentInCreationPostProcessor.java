//package com.example.springioctest.BeanCurrentlyInCreation;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Order // 保证再最后的BeanPostProcessor执行
//@Component
//public class CurrentInCreationPostProcessor implements BeanPostProcessor, BeanFactoryAware {
//    private BeanFactory beanFactory;
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (beanName.equals("beanA")) {
//            BeanB beanB = beanFactory.getBean(BeanB.class);
//            ((BeanA) bean).setBeanB(beanB);
//            beanB.setBeanA((BeanA) bean);
//        }
//        return bean;
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }
//}
