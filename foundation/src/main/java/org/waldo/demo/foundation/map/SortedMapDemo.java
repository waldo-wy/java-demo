package org.waldo.demo.foundation.map;

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
    }

}
