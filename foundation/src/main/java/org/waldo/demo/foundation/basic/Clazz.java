package org.waldo.demo.foundation.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 该类中主要是验证一些class相关的问题与细节点
 *
 * @author waldo.wy 2018/3/21
 */
public class Clazz {

    public static void main(String[] args) {
        List<Long> longList = new ArrayList<>();

        System.out.println(longList.getClass().isAssignableFrom(List.class));  // false
        System.out.println(longList.getClass().isAssignableFrom(ArrayList.class)); // true
        System.out.println(List.class.isAssignableFrom(longList.getClass()));  // true
        System.out.println(ArrayList.class.isAssignableFrom(longList.getClass()));  // true
        System.out.println(List.class.isInstance(longList));   // true
        System.out.println(ArrayList.class.isInstance(longList));  // true

        System.out.println(Objects.hash(new String("waldo.wangy"), "60924")); // 1470012685
        System.out.println(Objects.hash("waldo.wangy", new String("60924"))); // 1470012685
        System.out.println(Objects.hash("hanmeimei", "60924"));  // 1240489069
        System.out.println(Objects.hash("waldo.wangy", "60925")); // 1470012686
    }

}
