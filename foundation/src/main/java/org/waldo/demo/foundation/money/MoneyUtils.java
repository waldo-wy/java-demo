package org.waldo.demo.foundation.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 类MoneyUtils的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2017/10/13 下午1:11
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

        double da = 0.02;
        double db = 0.03;
        double dc = db - da;
        System.out.println(dc);

        BigDecimal bda = new BigDecimal("0.02");
        BigDecimal bdb = new BigDecimal("0.03");
        BigDecimal bdc = bdb.subtract(bda);
        System.out.println(bdc);

        BigDecimal gmd = BigDecimal.valueOf(55533L);
        System.out.println("gmd=" + gmd.toPlainString());
        BigDecimal ratio = BigDecimal.valueOf(350L).divide(BigDecimal.valueOf(100L), BigDecimal.ROUND_HALF_EVEN);
        System.out.println("ratio=" + ratio.toPlainString());
        System.out.println((gmd.multiply(ratio)).longValue());

        System.out.println(BigDecimal.valueOf(6.5).setScale(0, RoundingMode.HALF_EVEN));
        System.out.println(BigDecimal.valueOf(7.5).setScale(0, RoundingMode.HALF_EVEN));

    }

}
