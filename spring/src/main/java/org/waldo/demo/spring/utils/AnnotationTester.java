package org.waldo.demo.spring.utils;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 验证记录：
 * getAnnotation只会找当前类上写的注解
 * findAnnotation会向上找到所有的注解
 *
 * @author waldo.wy 2018/6/3
 */
@Order(1)
public class AnnotationTester implements Annotationed {

    @Order(2)
    public void sayHi() {
        System.out.println("nothing!");
    }

    @Validated
    public void sayHi2() {
        System.out.printf("sayHi2!");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationTester tester = new AnnotationTester();
        Method[] methods = tester.getClass().getDeclaredMethods();
        System.out.println(AnnotationUtils.getAnnotation(tester.getClass(), Order.class));
        System.out.println(AnnotationUtils.getAnnotation(tester.getClass(), Resource.class));
        System.out.println(AnnotationUtils.getAnnotation(tester.getClass(), Validated.class));
        System.out.println(AnnotationUtils.findAnnotation(tester.getClass(), Order.class));
        System.out.println(AnnotationUtils.findAnnotation(tester.getClass(), Resource.class));
        System.out.println(AnnotationUtils.findAnnotation(tester.getClass(), Validated.class));
        Arrays.stream(methods)
              .forEach(method -> {
                  System.out.println(AnnotationUtils.findAnnotation(method, Order.class));
                  System.out.println(AnnotationUtils.getAnnotation(method, Validated.class));
              });
    }
}
