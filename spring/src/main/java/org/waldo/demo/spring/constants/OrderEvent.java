package org.waldo.demo.spring.constants;

/**
 * 类OrderEvent描述：
 *
 * @author waldo.wy 2017/4/17 13:30
 */
public enum OrderEvent {

    PAY, // 买家支付
    BUYER_CANCEL, // 买家取消
    SELLER_CANCEL,  // 卖家取消
    SEND, // 发货
    RECEIVE // 确认收货
}
