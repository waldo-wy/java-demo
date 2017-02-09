package org.waldo.demo.foundation.basic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author waldo.wangy 2017/2/8 11:18
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
        System.out.println(vars.getRemainingMoney());
    }
}
