package org.waldo.demo.foundation.map;

import java.util.TreeSet;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/6/30
 */
public class SortedMapDemo {

    public static void main(String[] args) {
//        SortedMap<Order, Long> sortedMap = new TreeMap<>((k1, k2) -> {
//            return k1.getId()
//        });
        int iPositive = 1;
        int iNegative = (~(iPositive - 1));

        System.out.println(iNegative);

        iPositive = ~(iNegative - 1);
        System.out.println(iPositive);

        iNegative = 0;
        iPositive = ~(iNegative - 1);
        System.out.println(iPositive);

        TreeSet<ComparableRule> rules = new TreeSet<>();
        rules.add(ComparableRule.of(1234L, "basic", 200L));
        rules.add(ComparableRule.of(1235L, "basic", 200L));
        rules.add(ComparableRule.of(1236L, "basic", 300L));
        rules.add(ComparableRule.of(1237L, "special", 100L));
        System.out.println(rules);
    }

}
