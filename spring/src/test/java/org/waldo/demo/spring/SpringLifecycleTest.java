package org.waldo.demo.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.waldo.demo.spring.model.ModelForLifecycle;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringLifecycleConfig.class})
public class SpringLifecycleTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        System.out.println("into test-method, 说明容器初始化完成！");
        ModelForLifecycle modelForLifecycle = applicationContext.getBean("modelForLifecycle", ModelForLifecycle.class);
        System.out.println("test-method: " + modelForLifecycle);
        System.out.println("test-method: " + applicationContext.getBean("modelForLifecycle", ModelForLifecycle.class));
    }
}
