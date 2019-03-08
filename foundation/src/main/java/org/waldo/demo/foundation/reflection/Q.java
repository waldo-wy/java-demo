package org.waldo.demo.foundation.reflection;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-08
 */
public class Q {

    public static void main(String[] args) {
        Method[] methods = SubClazz.class.getMethods();
        long count = Arrays.stream(methods)
              .filter(method -> method.isAnnotationPresent(Ignore.class))
              .count();

        System.out.println("Found " + count + " method!");
    }

}
