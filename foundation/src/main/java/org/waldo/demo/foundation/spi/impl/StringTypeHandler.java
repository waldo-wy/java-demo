package org.waldo.demo.foundation.spi.impl;

import org.waldo.demo.foundation.spi.api.DataTypeHandler;

/**
 * 字符串
 *
 * @author waldo.wy 2018/11/21
 */
public class StringTypeHandler implements DataTypeHandler<String> {

    public StringTypeHandler() {
        System.out.println("constructed StringTypeHandler!");
    }

    @Override
    public String handle(String rawValue) {
        return rawValue;
    }
}
