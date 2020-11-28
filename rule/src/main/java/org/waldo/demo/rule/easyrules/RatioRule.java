package org.waldo.demo.rule.easyrules;

import org.waldo.demo.rule.model.OfferData;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-07
 */
public interface RatioRule<M> {

    /**
     * 获取业务类型
     */
    String getBizType();

    /**
     * 获取元数据
     *
     * @return 元数据
     */
    M getMetadata();

    /**
     * 优先级，
     *
     * @return 规则优先级
     */
    int getPriority();

    /**
     * 计算比率
     *
     */
    void calculateRatio(String bizType, OfferData offerData);

    /**
     * 是否匹配规则
     *
     * @return
     */
    boolean isMatch(String bizType, OfferData offerData);

}
