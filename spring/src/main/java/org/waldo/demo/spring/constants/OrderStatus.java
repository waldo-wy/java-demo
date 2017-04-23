/**
 * @author waldo.wy
 * @date 2017/4/17
 */
package org.waldo.demo.spring.constants;

/**
 * 类OrderStatus描述：
 *
 * @author waldo.wangy 2017/4/17 13:28
 */
public enum OrderStatus {
    UNPAID, // 待支付
    WAITING_FOR_SEND, // 待发货
    WAITING_FOR_RECEIVE, // 待收货
    DONE,   // 交易成功
    CANCEL // 交易结束
}
