package org.waldo.demo.spring.enhancer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/8
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition bd = beanFactory.getBeanDefinition("modelForLifecycle");
        bd.getPropertyValues().addPropertyValue("phone", "110");
    }
}
