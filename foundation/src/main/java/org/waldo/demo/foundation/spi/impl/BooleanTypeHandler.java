package org.waldo.demo.foundation.spi.impl;

import org.apache.commons.lang3.BooleanUtils;
import org.waldo.demo.foundation.spi.api.DataTypeHandler;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/11/20
 */
public class BooleanTypeHandler implements DataTypeHandler<Boolean> {

    public BooleanTypeHandler() {
        System.out.println("constructed BooleanTypeHandler!");
    }

    @Override
    public Boolean handle(String rawValue) {
        return BooleanUtils.toBooleanObject(rawValue);
    }
}
