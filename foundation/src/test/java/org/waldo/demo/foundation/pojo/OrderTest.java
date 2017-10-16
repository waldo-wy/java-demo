package org.waldo.demo.foundation.pojo;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    public void equals() throws Exception {
        Order order1 = new Order(20171016L, "bob", "cate", new BigDecimal(20));
        Order order2 = new Order(20171016L, "waldo", "william", new BigDecimal(50));
        Assert.assertTrue(order1.equals(order2));
    }

    @Test
    public void testHashCode() throws Exception {
        Order order1 = new Order(20171016L, "bob", "cate", new BigDecimal(20));
        Order order2 = new Order(20171016L, "waldo", "william", new BigDecimal(50));
        Assert.assertEquals(order1.hashCode(), order2.hashCode());
    }

}
