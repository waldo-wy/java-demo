/**
 * @author waldo.wy
 * @date 2017/4/1
 */
package waldo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * 类StartRunner描述： 这个方法会在应用程序启动后首先被调用。
 *
 * @author waldo.wangy 2017/4/1 16:41
 */
@Order(100)
public class StartRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("start done. Say hello!");
    }
}
