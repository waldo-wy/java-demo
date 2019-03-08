package org.waldo.demo.foundation.reflection;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-08
 */
public class SubClazz extends Parent<String> {

    @Ignore
    @Override
    public void process(String data) {
        System.out.println(data);
    }
}
