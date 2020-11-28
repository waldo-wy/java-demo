package org.waldo.demo.rule.easyrules.rules;

import org.waldo.demo.rule.easyrules.RatioRule;

/**
 * @author waldo.wy 2019-03-07
 */
public abstract class AbstractRatioRule<M> implements RatioRule<M> {

    private String bizType;

    private M metadata;

    public AbstractRatioRule(String bizType, M metadata) {
        this.bizType = bizType;
        this.metadata = metadata;
    }

    @Override
    public String getBizType() {
        return bizType;
    }

    @Override
    public M getMetadata() {
        return metadata;
    }
}
