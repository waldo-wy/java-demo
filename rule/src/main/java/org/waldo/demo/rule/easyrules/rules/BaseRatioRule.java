package org.waldo.demo.rule.easyrules.rules;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeasy.rules.annotation.*;
import org.waldo.demo.rule.constants.RatioFacts;
import org.waldo.demo.rule.model.OfferData;
import org.waldo.demo.rule.model.BaseRatioCfgDO;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-07
 */
@Rule(name = "基准拍档分佣规则", description = "拍档类型 + 类目 + 仓库类型")
public class BaseRatioRule extends AbstractRatioRule<BaseRatioCfgDO> {

    private Long ruleId;

    private Long categoryId;

    private String categoryFullPath;

    public BaseRatioRule(String bizType, BaseRatioCfgDO baseRatioCfg) {
        super(bizType, baseRatioCfg);
    }

    @Priority
    @Override
    public int getPriority() {
        return 999;
    }

    @Action
    @Override
    public void calculateRatio(@Fact(RatioFacts.BIZ_TYPE) String bizType, @Fact(RatioFacts.OFFER_DATA) OfferData offerData) {
        System.out.println("base-ratio-rule...");
    }

    @Condition
    @Override
    public boolean isMatch(@Fact(RatioFacts.BIZ_TYPE) String bizType, @Fact(RatioFacts.OFFER_DATA) OfferData offerData) {
        if (!StringUtils.equalsAnyIgnoreCase(bizType, getBizType())) {
            return false;
        }
        return RandomUtils.nextBoolean();
    }
}
