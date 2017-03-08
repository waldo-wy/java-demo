/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.waldo.demo.spring.component.DemoComponent;
import org.waldo.demo.spring.service.DemoService;
import org.waldo.demo.spring.service.OtherService;
import org.waldo.demo.spring.service.impl.DemoServiceImpl;
import org.waldo.demo.spring.service.impl.OtherServiceImpl;

/**
 * @author waldo.wangy 2017/3/7 17:10
 */
@Configuration
@ComponentScans({
        @ComponentScan("org.waldo.demo.spring.component"),
        @ComponentScan("org.waldo.demo.spring.aspect")
})
public class BizConfig {

    @Bean
    public DemoComponent demoComponent() {
        return new DemoComponent();
    }

    // 这里很有意思，按照代码常规理解，使用了方法createDemoComponent()传入类，会是new出的一个新对象，但事实上执行可见都是同一个类，原因是spring
    // 对于这些标识了@Bean @Configuration的类做了CGLIB代理，会按照Scope设置（spring默认是singleton）进行返回。
    @Bean(name = "demoService")
    public DemoService createDemoService() {
        DemoServiceImpl demoService = new DemoServiceImpl();
        demoService.setDemoComponent(demoComponent());
        return demoService;
    }

    @Bean
    public DemoService demoServiceNoName() {
        DemoServiceImpl demoService = new DemoServiceImpl();
        demoService.setDemoComponent(demoComponent());
        return demoService;
    }

    @Bean
    public OtherService createOtherService(DemoComponent demoComponent) {
        OtherServiceImpl otherService = new OtherServiceImpl();
        otherService.setDemoComponent(demoComponent);
        // otherService.setDemoComponent(createDemoComponent());
        return otherService;
    }

}
