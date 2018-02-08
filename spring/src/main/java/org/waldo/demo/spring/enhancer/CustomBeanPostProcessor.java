package org.waldo.demo.spring.enhancer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/8
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return bean;
    }
}
