/**
 * @author waldo.wy
 * @date 2017/7/28
 */
package org.waldo.demo.spring.model;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 类Urgency描述：
 *
 * @author waldo.wangy 2017/7/28 02:23
 */
@Order(110)
@Component
public class Urgency implements Prioritied {
    @Override
    public int getPriority() {
        return 0;
    }
}
