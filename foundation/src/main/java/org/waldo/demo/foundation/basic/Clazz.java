package org.waldo.demo.foundation.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类中主要是验证一些class相关的问题与细节点
 *
 * @author waldo.wy 2018/3/21
 */
public class Clazz {

    public static void main(String[] args) {
        List<Long> longList = new ArrayList<>();

        System.out.println(longList.getClass().isAssignableFrom(List.class));
        System.out.println(longList.getClass().isAssignableFrom(ArrayList.class));
        System.out.println(List.class.isAssignableFrom(longList.getClass()));
        System.out.println(ArrayList.class.isAssignableFrom(longList.getClass()));
        System.out.println(List.class.isInstance(longList));
        System.out.println(ArrayList.class.isInstance(longList));
    }

}
