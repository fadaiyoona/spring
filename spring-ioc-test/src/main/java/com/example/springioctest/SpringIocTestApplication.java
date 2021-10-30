package com.example.springioctest;

import com.example.springioctest.BeanCurrentlyInCreation.BeanA;
import com.example.springioctest.BeanCurrentlyInCreation.BeanB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync // 开启Async模块，为了创建BeanA组件时，是代理后的BeanA，产生循环依赖
@SpringBootApplication
public class SpringIocTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext beanFactory = SpringApplication.run(SpringIocTestApplication.class, args);

        BeanA beanA = beanFactory.getBean(BeanA.class);
        beanA.sayHello();
        BeanB beanB = beanFactory.getBean(BeanB.class);
        beanB.sayHello();
    }

}
