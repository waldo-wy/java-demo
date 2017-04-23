/**
 * @author waldo.wy
 * @date 2017/4/17
 */
package org.waldo.demo.spring.listener.order;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 类OrderStatusListener描述：
 *
 * @author waldo.wangy 2017/4/17 13:48
 */
@WithStateMachine
public class OrderStatusListener {

//    private static final Logger

    @OnTransitionStart(target = "UNPAID")
    public void createOrder() {
        System.out.println("这里可以用于判断订单是否可以正常进行，比如验证等等");
    }

    @OnTransition(target = "UNPAID")
    public void enableOrder() {
        System.out.println("开启订单正常进行...");
    }

    @OnTransitionStart(source = "UNPAID", target = "WAITING_FOR_SEND")
    public void verifyPaid() {
        System.out.println("校验订单是否已真实支付！");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_SEND")
    public void payDone() {
        System.out.println("用户支付完成，处理支付完成...");
    }

    @OnTransition(source = "WAITING_FOR_SEND", target = "WAITING_FOR_RECEIVE")
    public void send() {
        System.out.println("卖家发货完成，处理相关事宜...");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        System.out.println("用户确认收货，交易成功，订单完结。");
    }
}
