package org.waldo.demo.foundation.streams;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-17
 */
public class CollectionStreamTester {

    public static void main(String[] args) {
        Map<Long, String> initData = new HashMap<>();
        initData.put(1L, "1");
        initData.put(2L, "2");
        initData.put(3L, "3");
        initData.put(4L, "4");
        initData.put(5L, "5");
        initData.put(7L, "7");

        initData.forEach((k, v) -> {
            if (k % 2 == 0) {
                System.out.println(initData.remove(k));
            }
        });
    }

}
