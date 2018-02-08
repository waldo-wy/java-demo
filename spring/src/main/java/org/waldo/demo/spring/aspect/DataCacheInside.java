package org.waldo.demo.spring.aspect;

import java.lang.annotation.*;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/2/7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataCacheInside {
}
