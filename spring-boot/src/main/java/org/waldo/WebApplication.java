package org.waldo;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author waldo.wangy 2016/11/4 19:54
 */
// @RestController
@SpringBootApplication
public class WebApplication {

    // @RequestMapping("/")
    // public String home() {
    // return "Hello World!222";
    // }

    @Bean
    public StartRunner schedulerRunner() {
        return new StartRunner();
    }

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
