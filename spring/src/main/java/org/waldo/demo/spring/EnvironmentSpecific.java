package org.waldo.demo.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author waldo.wy
 */
@Configuration
@Profile({"dev", "daily", "project", "test"})
//@Import(AppConfig.class)
@PropertySource(value = {"classpath:custom-${spring.profiles.active}.properties"},
    ignoreResourceNotFound = true)
public class EnvironmentSpecific {
//
//    @Configuration
//
//    static class HsfDefaultConfig {}

}
