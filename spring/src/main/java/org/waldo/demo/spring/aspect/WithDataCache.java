package org.waldo.demo.spring.aspect;

import java.lang.annotation.*;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface WithDataCache {
}
