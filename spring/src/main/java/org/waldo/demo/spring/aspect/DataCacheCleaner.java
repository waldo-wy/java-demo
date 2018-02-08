package org.waldo.demo.spring.aspect;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/7
 */
@Component
public class DataCacheCleaner implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(beanName -> {
            System.out.println(beanName);
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            System.out.println(bd);
        });
    }
}
