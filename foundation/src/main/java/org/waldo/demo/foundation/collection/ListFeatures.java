package org.waldo.demo.foundation.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author waldo.wangy 2017/2/27 13:18
 */
public class ListFeatures {

    private static final int EACH_SIZE = 10;

    private List<Integer> arrayList;

    private static final ThreadLocal<List<List<Integer>>> batchedList = new ThreadLocal<>();

    public ListFeatures() {
        arrayList = new ArrayList<>();
        for (int i = 1; i <= 1823; i++) {
            arrayList.add(i);
        }
    }

    public List<List<Integer>> splitList(int maxGroupSize) {
        if (maxGroupSize == 0) {
            maxGroupSize = 200;
        }
        List<List<Integer>> batchList = batchedList.get();
        if (batchList == null) {
            if (arrayList.size() < maxGroupSize) {
                batchList = Collections.singletonList(arrayList);
            } else {
                batchList = new ArrayList<>();
                for (int i = 0; i <= arrayList.size() / (maxGroupSize + 1); i++) {
                    batchList.add(arrayList.subList(i * maxGroupSize, Math.min((i + 1) * maxGroupSize, arrayList.size())));
                }
            }
            batchedList.set(batchList);
        }
        return batchList;
    }

    public static void main(String[] args) {
        ListFeatures listFeatures = new ListFeatures();
        List<List<Integer>> groupedList = listFeatures.splitList(300);
        System.out.println("groupedList size: " + groupedList.size());
        System.out.println("group(0) size: " + groupedList.get(0).size());
        System.out.println("group(last) size: " + groupedList.get(groupedList.size() - 1).size());
        groupedList.forEach(System.out::println);
    }

}
