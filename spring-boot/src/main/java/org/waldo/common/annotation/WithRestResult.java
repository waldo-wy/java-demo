package org.waldo.common.annotation;

import org.springframework.web.bind.annotation.RestController;
import org.waldo.common.response.DefaultResultWrapper;
import org.waldo.common.response.ResultWrapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
public @interface WithRestResult {

    Class<? extends ResultWrapper> wrapper() default DefaultResultWrapper.class;

}
