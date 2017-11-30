package org.waldo.demo.foundation.pojo;

/**
 * 类Product的实现描述：TODO 类实现描述
 *
 * @author waldo.wangy 2017/10/17 下午5:34
 */
public class Product {

    /**
     * 钻石
     */
    public static final String DIAMOND = "0";

    /**
     * 黄金
     */
    public static final String GOLD = "1";

    private String type;

    private int discount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
