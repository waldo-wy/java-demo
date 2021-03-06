/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring.aspect;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author waldo.wy 2017/3/7 21:38
 */
@Component
// 一定要加proxyMode = ScopedProxyMode.TARGET_CLASS才会有效果
@Scope(scopeName = "thread", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SloganHandler implements DataCache<String, String> {

    private String slogan;

    public String getSlogan() {
        if (StringUtils.isBlank(slogan)) {
            slogan = RandomStringUtils.random(8, true, false);
        }
        return slogan;
    }

    @Override
    public String get() {
        return getSlogan();
    }

    @Override
    public String getByKey(String key) {
        return getSlogan();
    }

    @Override
    public void clear() {
        System.out.println("inner clean: " + slogan);
        slogan = null;
    }
}
