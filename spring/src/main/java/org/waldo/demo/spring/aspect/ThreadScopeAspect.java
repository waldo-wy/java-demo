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
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author waldo.wy 2017/3/8 10:31
 */
@Aspect
// 注意这里一定要增加Spring注释，要告诉Spring,它才能知道这是一个Aspect
@Component
public class ThreadScopeAspect {

    @Resource
    private DataCache sloganHandler;

    @Before("anyServiceOperation()")
    //    @After("execution(* org.waldo.demo.spring.service..*.*(..))")
    public void logging(JoinPoint jp) {
        System.out.println("~~~~~Before method invoke~~~~~ with args:" + Arrays.toString(jp.getArgs()));
    }

    @After("anyServiceOperation()")
//    @After("execution(* org.waldo.demo.spring.service.*.*(..))")
    public void cleanAllThreadData() {
        sloganHandler.clear();
    }

    @Pointcut("execution(* org.waldo.demo.spring.service..*.*(..))")
    private void anyServiceOperation() {
    }
}
