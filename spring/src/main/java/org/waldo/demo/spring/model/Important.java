/**
 * @author waldo.wy
 * @date 2017/7/28
 */
package org.waldo.demo.spring.model;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 类Important描述：
 *
 * @author waldo.wy 2017/7/28 02:21
 */
@Order(10)
@Component
public class Important implements Prioritied {
    @Override
    public int getPriority() {
        return 10;
    }
}
