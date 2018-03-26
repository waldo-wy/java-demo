/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.waldo.demo.spring.aspect.SloganHandler;
import org.waldo.demo.spring.aspect.WithDataCache;
import org.waldo.demo.spring.model.Prioritied;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author waldo.wy 2017/3/7 17:27
 */
@Component
public class DemoComponent {

    @Autowired
    private List<Prioritied> somethings;

    @Resource
    private SloganHandler sloganHandler;

    public void doSomething() {
        System.out.println(String.format("I[%1$s] am work.", this));
    }

    public void pringSomething() {
        for (Prioritied one : somethings) {
            System.out.println("one::" + one.getPriority());
        }
    }

    @WithDataCache
    public void shoutSlogans() {
        System.out.println(sloganHandler.getSlogan());
    }
}
