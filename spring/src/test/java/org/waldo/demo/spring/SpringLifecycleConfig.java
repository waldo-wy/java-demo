package org.waldo.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.waldo.demo.spring.enhancer.CustomBeanFactoryPostProcessor;
import org.waldo.demo.spring.enhancer.CustomBeanPostProcessor;
import org.waldo.demo.spring.enhancer.CustomInstantiationAwareBeanPostProcessor;
import org.waldo.demo.spring.model.ModelForLifecycle;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/8
 */
@Configuration
public class SpringLifecycleConfig {

    @Bean
    @Scope("prototype")
    ModelForLifecycle modelForLifecycle() {
        return new ModelForLifecycle();
    }

    @Bean
    CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean
    CustomInstantiationAwareBeanPostProcessor customInstantiationAwareBeanPostProcessor() {
        return new CustomInstantiationAwareBeanPostProcessor();
    }

    @Bean
    CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

}
