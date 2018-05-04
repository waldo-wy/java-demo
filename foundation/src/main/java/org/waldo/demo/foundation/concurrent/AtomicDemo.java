package org.waldo.demo.foundation.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/3/28
 */
public class AtomicDemo {

    public static void main(String[] args) {
        AtomicLong sum = new AtomicLong(0L);
        for (int i = 0; i < 5; i++) {
            sum.addAndGet(i * 100L);
        }
        System.out.println(sum);
    }

}
