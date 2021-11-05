package com.example.springioctest.populateBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanA")) {
            // 这个要注意了。一定要提供setter方法才行。。
            // 不是很理解为什么@Autowired这种方式注入可以不用提供setter，而这个非要要求。。
            MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
            mpvs.add("a", 1);
        }
        return pvs;
    }
}
