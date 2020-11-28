package org.waldo.demo.rule.easyrules.rules;

import org.jeasy.rules.annotation.*;
import org.waldo.demo.rule.constants.RatioFacts;
import org.waldo.demo.rule.model.OfferData;
import org.waldo.demo.rule.model.BaseRatioCfgDO;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-07
 */
@Rule(name = "兜底拍档分佣规则", description = "可以用来做预警、日志或者是设置兜底值")
public class RevealRatioRule extends AbstractRatioRule {

    public RevealRatioRule(String bizType, BaseRatioCfgDO ratioConfigDO) {
        super(bizType, ratioConfigDO);
    }

    @Priority
    @Override
    public int getPriority() {
        return 1000;
    }

    @Action
    @Override
    public void calculateRatio(@Fact(RatioFacts.BIZ_TYPE) String bizType, @Fact(RatioFacts.OFFER_DATA) OfferData offerData) {
        System.out.println("reveal-ratio-rule====");
    }

    @Condition
    @Override
    public boolean isMatch(@Fact(RatioFacts.BIZ_TYPE) String bizType, @Fact(RatioFacts.OFFER_DATA) OfferData offerData) {
        return true;
    }
}
