/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring.service.impl;

import org.springframework.stereotype.Service;
import org.waldo.demo.spring.component.DemoComponent;
import org.waldo.demo.spring.aspect.SloganHandler;
import org.waldo.demo.spring.service.DemoService;

import javax.annotation.Resource;

/**
 * @author waldo.wangy 2017/3/7 17:15
 */
@Service
public class DemoServiceImpl implements DemoService {

    private DemoComponent demoComponent;

    @Resource
    private SloganHandler sloganHandler;

    @Override
    public void sayHi() {
        System.out.println("Hello spring!!!");
        demoComponent.doSomething();
    }

    @Override
    public void shoutSlogans() {
        System.out.println(sloganHandler.get());
    }

    public void setDemoComponent(DemoComponent demoComponent) {
        this.demoComponent = demoComponent;
    }
}
