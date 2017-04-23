/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.statemachine.StateMachine;
import org.waldo.demo.spring.component.DemoComponent;
import org.waldo.demo.spring.constants.OrderEvent;
import org.waldo.demo.spring.constants.OrderStatus;
import org.waldo.demo.spring.service.DemoService;
import org.waldo.demo.spring.service.OtherService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author waldo.wangy 2017/3/7 17:04
 */
public class Application {

    public static void main(String[] args) {
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class, OtherConfig.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        Environment environment = ctx.getEnvironment();
        //        System.out.println(environment.getProperty("spring.profiles.active") + "-----");
        ctx.register(AppConfig.class);
//        ctx.register(AppConfig.class, BizConfig.class);
        ctx.refresh();

        DemoService demoService = ctx.getBean("demoService", DemoService.class);
        demoService.sayHi();

        OtherService otherService = ctx.getBean(OtherService.class);
        otherService.doWork();

        DemoComponent demoComponent = ctx.getBean(DemoComponent.class);
        demoComponent.doSomething();

        DemoComponent demoComponent2 = new DemoComponent();
        demoComponent2.doSomething();

        //        System.out.println(ctx.getBean("demoComponent"));
        System.out.println(environment.getProperty("spring.profiles.active"));

        MessageSource messageResource = ctx.getBean(MessageSource.class);
        System.out.println(messageResource.getMessage("message.save.success", null, null));

        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(demoService::shoutSlogans);
        es.submit(demoService::shoutSlogans);
        es.submit(demoService::shoutSlogans);

        es.shutdown();

        @SuppressWarnings("unchecked")
        StateMachine<OrderStatus, OrderEvent> orderStateMachine = ctx.getBean(StateMachine.class);
        orderStateMachine.start();
        orderStateMachine.sendEvent(OrderEvent.PAY);
        orderStateMachine.sendEvent(OrderEvent.SEND);
        orderStateMachine.sendEvent(OrderEvent.RECEIVE);
    }

}
