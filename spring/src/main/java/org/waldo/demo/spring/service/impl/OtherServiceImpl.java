/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring.service.impl;

import org.waldo.demo.spring.component.DemoComponent;
import org.waldo.demo.spring.service.OtherService;

/**
 * @author waldo.wangy 2017/3/7 17:31
 */
public class OtherServiceImpl implements OtherService {

    private DemoComponent demoComponent;

    @Override
    public void doWork() {
        System.out.println("I am other service, i am work!");
        demoComponent.doSomething();
    }

    public void setDemoComponent(DemoComponent demoComponent) {
        this.demoComponent = demoComponent;
    }
}
