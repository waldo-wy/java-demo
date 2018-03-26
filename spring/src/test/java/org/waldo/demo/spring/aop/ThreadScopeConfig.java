package org.waldo.demo.spring.aop;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

/**
 * thread-scope测试配置类
 *
 * @author waldo.wy 2018/2/8
 */
@Configuration
@ComponentScans({
        @ComponentScan("org.waldo.demo.spring"),
        @ComponentScan("org.waldo.demo.spring.model"),
        @ComponentScan("org.waldo.demo.spring.aspect"),
        @ComponentScan("org.waldo.demo.spring.service"),
})
public class ThreadScopeConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("thread", new SimpleThreadScope());
        return customScopeConfigurer;
    }

}
