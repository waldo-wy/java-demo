package org.waldo.demo.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.waldo.demo.spring.component.DemoComponent;
import org.waldo.demo.spring.service.DemoService;

/**
 * thread-scope测试类
 *
 * @author waldo.wy 2018/2/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ThreadScopeConfig.class})
public class ThreadScopeTest {

    @Autowired
    private DemoComponent demoComponent;

    @Autowired
    private DemoService demoService;

    @Test
    public void testDataCacheClean() {
        demoComponent.shoutSlogans();
        demoService.shoutSlogans();
    }

}
