package org.waldo.demo.spring.utils;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/6/3
 */
@Order(1)
public class AnnotationTester {

    @Order(2)
    public void sayHi() {
        System.out.println("nothing!");
    }

    public void sayHi2() {
        System.out.printf("sayHi2!");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnotationTester tester = new AnnotationTester();
        Method[] methods = tester.getClass().getDeclaredMethods();
        System.out.println(AnnotationUtils.findAnnotation(tester.getClass(), Order.class));
        Arrays.stream(methods)
              .forEach(method -> {
                  System.out.println(AnnotationUtils.findAnnotation(method, Order.class));
              });
    }
}
