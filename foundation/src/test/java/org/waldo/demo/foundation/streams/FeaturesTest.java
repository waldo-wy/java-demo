package org.waldo.demo.foundation.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.waldo.demo.foundation.pojo.Order;

public class FeaturesTest {

    private List<Order> orders;

    @Before
    public void initOrders() {
        orders = new ArrayList<>();
        orders.add(new Order(1L, "waldobuyer", "waldoseller", BigDecimal.valueOf(200.00)));
        orders.add(new Order(2L, "waldobuyer", "waldoseller", BigDecimal.valueOf(188.00)));
        orders.add(new Order(3L, "waldobuyer", "waldoseller", BigDecimal.valueOf(301.11)));
    }

    @Test
    public void testListToMap() throws Exception {
        Features features = new Features();
        Map<Long, Order> map = features.listToMap(orders);
        System.out.println(map);
        Assert.assertTrue(map.containsKey(2L)
                          && map.containsValue(new Order(3L, "waldobuyer", "waldoseller", BigDecimal.valueOf(301.11))));
    }

    @Test
    public void testError() {
        Integer[] test = new Integer[] { 1, 2, 3, 1 };
        System.out.println(Arrays.stream(test).collect(Collectors.toMap(x -> x, x -> 1)));
    }
}
