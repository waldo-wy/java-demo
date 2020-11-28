package org.waldo.demo.rule.easyrules.rules;

import org.waldo.demo.rule.model.BaseRatioCfgDO;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-07
 */
public abstract class SpecialRatioRule extends AbstractRatioRule {

    public SpecialRatioRule(String bizType, BaseRatioCfgDO ratioConfigDO) {
        super(bizType, ratioConfigDO);
    }

    @Override
    public int getPriority() {
        return 500;
    }

}
