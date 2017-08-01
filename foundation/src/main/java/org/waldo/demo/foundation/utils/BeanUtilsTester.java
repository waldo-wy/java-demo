/**
 * @author waldo.wy
 * @date 2017/7/18
 */
package org.waldo.demo.foundation.utils;

import org.waldo.demo.foundation.pojo.Order;

import java.math.BigDecimal;

/**
 * 类BeanUtilsTester描述：
 *
 * @author waldo.wangy 2017/7/18 10:12
 */
public class BeanUtilsTester {

    public static void main(String[] args) {
        Order order = new Order();
        Order newOrder = new Order();

        order.setBuyer("");
        order.setAmount(new BigDecimal(10.0));

//        BeanUtils.copyProperties();
    }

}
