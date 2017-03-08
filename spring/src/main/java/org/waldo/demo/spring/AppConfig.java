/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.SimpleThreadScope;

/**
 * Spring Java Config class
 *
 * @author waldo.wangy 2017/3/7 17:06
 */
@Configuration
//@ComponentScan("org.waldo.demo.spring.notexists")
//@ComponentScan("org.waldo.demo.spring")
//可以通过@Import的方式引入其它的Java-based配置类
@Import({BizConfig.class})
// @Configuration并不是可以100%的替换掉xml，所以有时候还是要结合xml一起使用，这个时候就可以使用@ImportResource来引入xml
//@Profile("dev")
@PropertySources({
        @PropertySource("classpath:application.properties")
})
@EnableAspectJAutoProxy
public class AppConfig {

    // 不指定name或者aliasName的情况下，默认使用的是methodName
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageResource = new ResourceBundleMessageSource();
//        messageResource.setDefaultEncoding("utf-8"); 如果在idea里设置了native-to-ascii，则这个就不能设置，默认会是iso-8859-1
        messageResource.addBasenames("message", "error");
        return messageResource;
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("thread", new SimpleThreadScope());
        return customScopeConfigurer;
    }

}
