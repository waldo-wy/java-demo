package org.waldo.common.response;

/**
 * @author waldo.wy 2018/6/15
 */
public interface ResultWrapper<T> {

    T wrapResult(Object result);

    T wrapException(Exception ex);

}
