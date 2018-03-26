package org.waldo.demo.foundation.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/27
 */
public class ParallelismTester {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        IntStream s = IntStream.range(0, 20);
        System.out.println(System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        s.parallel().forEach(i -> printCost(start));

        System.out.println("\n-----");

        long start2 = System.currentTimeMillis();
        List<Long> arrays = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        arrays.parallelStream().forEach(i -> printCost(start2));
    }

    private static void printCost(long start) {
        try {
            Thread.sleep(100);
        } catch (Exception ignore) {
        }
        System.out.print((System.currentTimeMillis() - start) + " ");
    }

}
