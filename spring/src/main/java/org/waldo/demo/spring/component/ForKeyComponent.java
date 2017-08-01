/**
 * @author waldo.wy
 * @date 2017/7/13
 */
package org.waldo.demo.spring.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类ForKeyComponent描述：
 *
 * @author waldo.wangy 2017/7/13 02:17
 */
@Component
public class ForKeyComponent {
    private String key;

    public ForKeyComponent(@Value("${demo.encrypter.key2:95271}") String key) {
        this.key = key;
    }

    public void encrypt() {
        System.out.println("encrypt data use key=" + key);
    }
}
