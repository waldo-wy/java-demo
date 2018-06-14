package org.waldo.common.response;

/**
 * TODO 类的说明描述
 *
 * @author waldo.wy 2018/6/15
 */
public class DefaultResultWrapper implements ResultWrapper<RestResult> {


    @Override
    public RestResult wrapResult(Object result) {
        RestResult restResult = new RestResult();
        restResult.setSuccess(Boolean.TRUE);
        restResult.setData(result);
        return restResult;
    }

    @Override
    public RestResult wrapException(Exception ex) {
        return null;
    }
}
