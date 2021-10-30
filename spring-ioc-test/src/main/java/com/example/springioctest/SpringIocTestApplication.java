package com.example.springioctest;

import com.example.springioctest.BeanCurrentlyInCreation.BeanA;
import com.example.springioctest.BeanCurrentlyInCreation.BeanB;
import com.example.springioctest.FactoryBean.Car;
import com.example.springioctest.FactoryBean.CarFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableAsync // 开启Async模块，为了创建BeanA组件时，是代理后的BeanA，产生循环依赖
@SpringBootApplication
public class SpringIocTestApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext beanFactory = SpringApplication.run(SpringIocTestApplication.class, args);

        // Case --- BeanCurrentlyInCreation
        BeanA beanA = beanFactory.getBean(BeanA.class);
        beanA.sayHello();
        BeanB beanB = beanFactory.getBean(BeanB.class);
        beanB.sayHello();

        // Case --- FactoryBean
        Car car1 = (Car) beanFactory.getBean("car");
        Car car2 = (Car) beanFactory.getBean("car");
        CarFactoryBean carFactoryBean = (CarFactoryBean) beanFactory.getBean("&car");
        Car car3 = carFactoryBean.getObject();
        System.out.println(car1 == car2);
        System.out.println(car1 == car3);
    }

}
