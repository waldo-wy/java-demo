package org.waldo.common.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.waldo.common.annotation.WithRestResult;
import org.waldo.common.response.ResultWrapper;

/**
 * TODO 类的说明描述
 *
 * @author waldo.wy 2018/6/15
 */
@RestControllerAdvice(annotations = WithRestResult.class)
public class RestResultAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return (returnType.getMethod().isAnnotationPresent(WithRestResult.class) || returnType.getContainingClass().isAnnotationPresent(WithRestResult.class));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        WithRestResult withRestResult = returnType.getMethodAnnotation(WithRestResult.class);
        if (withRestResult == null) {
            withRestResult = returnType.getContainingClass().getAnnotation(WithRestResult.class);
        }
        if (withRestResult == null) {
            return body;
        }

        Class<? extends ResultWrapper> clazz = withRestResult.wrapper();
        try {
            ResultWrapper resultWrapper = clazz.newInstance();
            return resultWrapper.wrapResult(body);
        } catch (InstantiationException e) {
            // TODO write log
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO write log
            e.printStackTrace();
        }
        return body;
    }

    @ExceptionHandler
    public Object exceptionHandle(final Exception ex, final WebRequest req) {
        //
        return null;
    }
}
