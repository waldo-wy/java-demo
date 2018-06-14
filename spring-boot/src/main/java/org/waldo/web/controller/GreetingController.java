/**
 * @author waldo.wy
 * @date 2017/4/5
 */
package org.waldo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.waldo.common.annotation.WithRestResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类GreetingController描述：
 *
 * @author waldo.wy 2017/4/5 13:49
 */
@Controller
public class GreetingController {

    @WithRestResult
    @RequestMapping("/greet")
    String sayHello(@RequestParam("name") String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The 'name' parameter must not be null or empty");
        }
        return String.format("Hello %s!", name);
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class}) // 只能在本类方法中起作用，要想在全局启作用怎么办？答曰：新建一个类，用注解@ControllerAdvice修饰
    void handleIllegalArgumentException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
