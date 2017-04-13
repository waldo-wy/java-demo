/**
 * @author waldo.wy
 * @date 2017/4/13
 */
package org.waldo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.TestPropertySource;

/**
 * 类TestApplication描述：
 *
 * @author waldo.wangy 2017/4/13 13:33
 */
@SpringBootApplication
@TestPropertySource(properties = {"application-test.properties"})
public class TestApplication {
}
