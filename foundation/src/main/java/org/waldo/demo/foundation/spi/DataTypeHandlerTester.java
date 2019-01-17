package org.waldo.demo.foundation.spi;

import org.waldo.demo.foundation.spi.api.DataTypeHandler;

import java.util.ServiceLoader;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/11/20
 */
public class DataTypeHandlerTester {

    public static void main(String[] args) {
        ServiceLoader<DataTypeHandler> dataTypeHandlerLoader = ServiceLoader.load(DataTypeHandler.class);
        dataTypeHandlerLoader.forEach(handler -> {
            System.out.println(handler.getClass().getCanonicalName());
            System.out.println(handler.handle("y"));
        });
        // 所以每次进行ServiceLoader构建，都会造成实例化
        ServiceLoader<DataTypeHandler> dataTypeHandlerLoader2 = ServiceLoader.load(DataTypeHandler.class);
        dataTypeHandlerLoader2.forEach(handler -> {
            System.out.println(handler.getClass().getCanonicalName());
            System.out.println(handler.handle("y"));
        });
    }

}
