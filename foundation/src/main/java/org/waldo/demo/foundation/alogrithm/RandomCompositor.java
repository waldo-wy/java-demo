package org.waldo.demo.foundation.alogrithm;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 随机抽取逻辑（可以用于排班及抽签）
 *
 * @author waldo.wy 2019-01-25
 */
public class RandomCompositor {

    public static void main(String[] args) {
        List<Integer> arrays = IntStream.range(0, 11)
                                        .mapToObj(i -> i + 2)
                                        .collect(Collectors.toList());

        List<Integer> newOrder = IntStream.range(0, 11)
                                          .mapToObj(t -> arrays.remove(RandomUtils.nextInt(0, arrays.size() - 1)))
                                          .collect(Collectors.toList());

        System.out.println(newOrder);

        int sum = IntStream.range(0, 10).parallel()
                           .map(t -> 1)
                           .reduce(Integer::sum).orElse(0);
        System.out.println(sum);
    }

}
