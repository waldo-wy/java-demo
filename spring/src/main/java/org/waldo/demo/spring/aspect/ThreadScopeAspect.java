/**
 * @author waldo.wy
 * @date 2017/3/8
 */
package org.waldo.demo.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * @author waldo.wy 2017/3/8 10:31
 */
@Aspect
// 注意这里一定要增加Spring注释，要告诉Spring,它才能知道这是一个Aspect
@Component
public class ThreadScopeAspect implements ApplicationContextAware {

//    @Resource
//    private DataCache sloganHandler;

    private ApplicationContext ctx;

    @Before("anyServiceOperation()")
    //    @After("execution(* org.waldo.demo.spring.service..*.*(..))")
    public void logging(JoinPoint jp) {
        System.out.println("~~~~~Before method invoke~~~~~ with args:" + Arrays.toString(jp.getArgs()));
    }

    @After("anyServiceOperation()")
//    @After("execution(* org.waldo.demo.spring.service.*.*(..))")
    public void cleanAllThreadData() {
//        System.out.println("clean: " + sloganHandler.get());
//        sloganHandler.clear();
        Map<String, DataCache> dataCacheMap = ctx.getBeansOfType(DataCache.class, false, false);
        if (dataCacheMap != null) {
            dataCacheMap.values().forEach(DataCache::clear);
        }
    }

    @Pointcut("execution(* org.waldo.demo.spring.service..*.*(..))")
    private void anyServiceOperation() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
