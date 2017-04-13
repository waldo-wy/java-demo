package org.waldo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.waldo.TestApplication;

/**
 * @author waldo.wy
 * @date 2017/4/12
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(properties = "application-test.properties")   // 这里这样写，仍然会加载默认的配置，而且是后加载，所以会覆盖这里的配置
//@SpringBootTest // 在application.properties中增加了spring.profiles.active=test，但仍不理想，我不能通过每次跑单元测试的时候来修改profiles
@SpringBootTest(classes = {TestApplication.class})
//@SpringBootTest(properties = {"test.properties"}, classes = {TestApplication.class})
//@TestPropertySource(locations = {"classpath:application-test.properties"})
public class AuthorReadServiceTest {

    @Autowired
    private AuthorReadService authorReadService;

    @Test
    public void findAuthor() throws Exception {
        authorReadService.findAuthor(1L, false);
    }

}