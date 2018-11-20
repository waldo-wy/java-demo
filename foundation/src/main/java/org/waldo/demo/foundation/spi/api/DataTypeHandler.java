package org.waldo.demo.foundation.spi.api;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/11/20
 */
public interface DataTypeHandler<T> {

    T handle(String rawValue);

}
