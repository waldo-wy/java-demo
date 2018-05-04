package org.waldo.demo.foundation.streams;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.waldo.demo.foundation.pojo.Order;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FeaturesTest {

    private List<Order> orders;

    @Before
    public void initOrders() {
        orders = new ArrayList<>();
        orders.add(new Order(1L, "waldobuyer", "waldoseller", BigDecimal.valueOf(200.00)));
        orders.add(new Order(2L, "waldobuyer", "waldoseller", BigDecimal.valueOf(188.00)));
        orders.add(new Order(3L, "waldobuyer", "waldoseller", BigDecimal.valueOf(301.11)));
        orders.add(new Order(4L, "waldobuyer", null, BigDecimal.valueOf(301.11)));
        orders.add(new Order(3L, "c-waldobuyer", "c-waldoseller", BigDecimal.valueOf(301.11)));
    }

    @Test
    public void testListToMap() throws Exception {
        Features features = new Features();
        Map<Long, Order> map = features.listToMap(orders);
        System.out.println(map);
        Assert.assertTrue(map.containsKey(2L)
                                  && map.containsValue(new Order(3L, "waldobuyer", "waldoseller", BigDecimal.valueOf(301.11))));
    }

    @Test(expected = IllegalStateException.class)
    public void testError() {
        Integer[] test = new Integer[]{1, 2, 3, 1};
        System.out.println(Arrays.stream(test)
                                 .collect(Collectors.toMap(x -> x, x -> 1)));
    }

    @Test
    public void testToMap() {
        // orders.stream().collect(Collectors.toMap(Order::getId, Order::getSeller));
        Map<Long, String> result = orders.stream()
                                         .collect(HashMap::new,
                                                  (map, order) -> map.put(order.getId(), order.getSeller()),
                                                  HashMap::putAll);
        System.out.println(result);

        Map<Long, String> result2 = new HashMap<>();
        orders.forEach(order -> {
            result2.put(order.getId(), order.getSeller());
        });
        System.out.println(result2);

        Map<Long, String> result3 = orders.stream()
                                          .filter(order -> order.getSeller() != null)
                                          .collect(Collectors.toMap(Order::getId,
                                                                    Order::getSeller,
                                                                    (existed, conflict) -> {
                                                                        System.out.println(existed.equals(conflict));
                                                                        return conflict;
                                                                    }));
        System.out.println(result3);
    }

    @Test
    public void testIfPresent() {
        orders.stream()
              .filter(order -> order.getId() == 2 || order.getId() == 1)
              .findFirst()
              .ifPresent(System.out::print);
    }

    @Test
    public void test_match_function() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(3L);
        ids.add(5L);
        ids.forEach(id -> {
            if (orders.stream().noneMatch(order -> Objects.equals(id, order.getId()))) {
                System.out.println(String.format("Not found [%1$s]", id));
            } else {
                System.out.println(String.format("Found [%1$s]", id));
            }
        });

        ids.forEach(id -> {
            if (orders.stream().anyMatch(order -> Objects.equals(id, order.getId()))) {
                System.out.println(String.format("Found [%1$s]", id));
            } else {
                System.out.println(String.format("Not found [%1$s]", id));
            }
        });
    }

    @Test
    public void test_filter() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        ids.add(null);
        ids.add(2);
        ids.add(4);

        List<Integer> evenList = ids.stream()
                                    .filter(Objects::nonNull)
                                    .filter(id -> id % 2L == 0)
                                    .peek(System.out::println)
                                    .collect(Collectors.toList());
        System.out.println(evenList);
    }

    @Test
    public void test_map_reduce() throws InterruptedException {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        ids.add(null);
        ids.add(2);
        ids.add(4);

        // accumulator一定不为空，首次进入的时候，会使用第一个值
        Character character = ids.parallelStream()
                                 .filter(Objects::nonNull)
                                 .map(i -> (char) (97 + i))
                                 .reduce((acc, elem) -> {
                                     if (acc < elem) {
                                         acc = elem;
                                     }
                                     return acc;
                                 })
                                 .get();
        System.out.println(character);

        // 这里可以看出输出是乱序的
        long count = ids.parallelStream().peek(System.out::println).count();
        System.out.println("-------------" + count + "------------------");
        // 这里可以看出输出是正序的
        ids.stream().filter(Objects::nonNull).forEach(System.out::println);

        // 再测试下是否可以把所有的结果都收集起来，使用reduce是不可以了

        List<Character> result = ids.parallelStream().filter(Objects::nonNull)
                                    .map(i -> (char) (97 + i))
                                    .collect(Collectors.toList());
        System.out.println(result);

        long noCount = ids.parallelStream().filter(id -> Boolean.FALSE).count();
        System.out.println(noCount);
    }

    @Test
    public void test_stream_count() {
        List<String> booleans = new ArrayList<>();
        booleans.add("N");
        booleans.add("Y");
        booleans.add("N");
        booleans.add(null);
        booleans.add("Y");
        booleans.add("Y");
        long count = booleans.stream()
                             .filter(BooleanUtils::toBoolean)
                             .count();
        Assert.assertEquals(3L, count);
    }
}
