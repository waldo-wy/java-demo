package org.waldo.demo.foundation.money;

import java.math.BigDecimal;

/**
 * 类MoneyUtils的实现描述：TODO 类实现描述
 *
 * @author waldo.wangy 2017/10/13 下午1:11
 */
public class MoneyUtils {

    public static void main(String[] args) {
        double dAmount = 39999d;
        double dDiscount = 0.63d;

        double a = 0.81d;
        double b = 0.24d;
        System.out.println(dAmount * dDiscount);
        System.out.println(a - b);

        double d = 29.0 * 0.01;
        System.out.println(d);
        System.out.println((int) (d * 100));

        BigDecimal bAmount = new BigDecimal("39999");
        BigDecimal bDiscount = new BigDecimal("0.63");

        BigDecimal ba = new BigDecimal("0.81");
        BigDecimal bb = new BigDecimal("0.24");
        System.out.println(bAmount.multiply(bDiscount));

        BigDecimal result = new BigDecimal("29.0").multiply(new BigDecimal("0.01"));
        System.out.println(result);
        System.out.println(result.multiply(new BigDecimal("100")));

//        System.out.println(ba.);
    }

}
