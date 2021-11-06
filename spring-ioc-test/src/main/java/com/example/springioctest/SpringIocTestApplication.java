package com.example.springioctest;

import com.example.springioctest.aop.AopBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
//@EnableAsync // 开启Async模块，为了创建BeanA组件时，是代理后的BeanA，产生循环依赖
//@ComponentScan("com.example.springioctest.BeanCurrentlyInCreation")
//@ComponentScan("com.example.springioctest.FactoryBean")
@ComponentScan("com.example.springioctest.aop")
@SpringBootApplication
public class SpringIocTestApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext beanFactory = SpringApplication.run(SpringIocTestApplication.class, args);
        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory.getBeanFactory();

//        // Case --- BeanCurrentlyInCreation
//        BeanA beanA = beanFactory.getBean(BeanA.class);
//        beanA.sayHello();
//        BeanB beanB = beanFactory.getBean(BeanB.class);
//        beanB.sayHello();

//        // Case --- FactoryBean
//        Car car1 = (Car) beanFactory.getBean("car");
//        Car car2 = (Car) beanFactory.getBean("car");
//        CarFactoryBean carFactoryBean = (CarFactoryBean) beanFactory.getBean("&car");
//        Car car3 = carFactoryBean.getObject();
//        System.out.println(car1 == car2);
//        System.out.println(car1 == car3);

        // Case --- aop
        AopBean aopBean = listableBeanFactory.getBean(AopBean.class);
        aopBean.sayHello();
    }

}
