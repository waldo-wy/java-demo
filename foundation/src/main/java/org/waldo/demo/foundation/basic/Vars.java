package org.waldo.demo.foundation.basic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.Objects;

/**
 * 这个方法中主要是验证变量相关的问题
 *
 * @author waldo.wy 2017/2/8 11:18
 */
public class Vars {

    private Integer totalMoney = 0;

    private Integer costMoney = 0;

    private Integer remainingMoney = totalMoney - costMoney;

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Integer costMoney) {
        this.costMoney = costMoney;
    }

    public Integer getRemainingMoney() {
        return remainingMoney;
    }

    public void setRemainingMoney(Integer remainingMoney) {
        this.remainingMoney = remainingMoney;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static void main(String[] args) {
        Vars vars = new Vars();
        System.out.println(vars);
        vars.setTotalMoney(100);
        vars.setCostMoney(20);
        System.out.println(vars);
        // 不会因为设置了total和cost而使用remaining发生变化，这里需要对于类的初始化有清晰的了解
        System.out.println(vars.getRemainingMoney());

        System.out.println(Integer.valueOf(101).equals(null));  // false
        System.out.println(null instanceof String); // false
        System.out.println(null instanceof Object); // false

        MutablePair<Integer, Integer> integerPair = MutablePair.of(1, 9);
        MutablePair<Long, Long> longPair = MutablePair.of(0L, 0L);
        vars.testAddress(integerPair, longPair);
        System.out.println(integerPair);
        System.out.println(longPair);
    }

    private void testAddress(MutablePair<Integer, Integer> integerPair, MutablePair<Long, Long> longPair) {
        Objects.requireNonNull(integerPair);
        Objects.requireNonNull(longPair);
        integerPair = MutablePair.of(3, 6);
        longPair.setLeft(5L);
        longPair.setRight(6L);
    }
}
