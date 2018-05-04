package org.waldo.demo.foundation.utils;

import com.alibaba.fastjson.JSON;
import org.waldo.demo.foundation.pojo.Order;

import java.math.BigDecimal;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/3/30
 */
public class NumberUtilsDemo {

    public static void main(String[] args) {
//        System.out.println(NumberUtils.createInteger(""));

        Order order = new Order(1L, "waldobuyer", "waldoseller", BigDecimal.valueOf(1000L));
        System.out.println(JSON.toJSON(order));
    }

}
