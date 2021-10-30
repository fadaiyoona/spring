package com.example.springioctest.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("car")
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setMaxSpeed(2);
        car.setBrand("brand");
        car.setPrice(2.0);
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    /**
     * 是否单例，如果是单例，则不会重复执行getObject，再次获取走的是ioc的缓存，通过↓支持
     * @see org.springframework.beans.factory.support.FactoryBeanRegistrySupport#factoryBeanObjectCache
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
