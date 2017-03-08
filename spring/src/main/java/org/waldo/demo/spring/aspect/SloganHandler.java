/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring.aspect;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author waldo.wangy 2017/3/7 21:38
 */
@Component
// 一定要加proxyMode = ScopedProxyMode.TARGET_CLASS才会有效果
@Scope(scopeName = "thread", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SloganHandler implements DataCache<String, String> {

    private String slogan;

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
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
        slogan = null;
    }
}
