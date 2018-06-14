package org.waldo;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author waldo.wy 2016/11/4 19:54
 */
@SpringBootApplication
@EnableScheduling
public class WebApplication {

    @Bean
    public StartRunner schedulerRunner() {
        return new StartRunner();
    }

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public WebMvcRegistrationsAdapter webMvcRegistrationsAdapter() {
        return new WebMvcRegistrationsAdapter() {

            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {
                    @Override
                    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
                        return super.getMappingForMethod(method, handlerType);
                    }
                };
            }

            @Override
            public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
                return new RequestMappingHandlerAdapter() {

                };
            }

            @Override
            public ExceptionHandlerExceptionResolver getExceptionHandlerExceptionResolver() {
                return super.getExceptionHandlerExceptionResolver();
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
