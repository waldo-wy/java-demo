package org.waldo.demo.rule.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.waldo.demo.rule.constants.RatioFacts;
import org.waldo.demo.rule.easyrules.rules.BaseRatioRule;
import org.waldo.demo.rule.easyrules.rules.RevealRatioRule;
import org.waldo.demo.rule.model.OfferData;
import org.waldo.demo.rule.model.BaseRatioCfgDO;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-07
 */
public class RatioRuleTester {

    public static void main(String[] args) {
        // create rules engine
        RulesEngineParameters parameters = new RulesEngineParameters()
                .skipOnFirstAppliedRule(Boolean.TRUE);
        RulesEngine ratioEngine = new DefaultRulesEngine(parameters);

        Rules ratioRules = new Rules();
        BaseRatioCfgDO ratioConfigDO = new BaseRatioCfgDO();
        ratioRules.register(new BaseRatioRule("partner", ratioConfigDO));
        ratioRules.register(new RevealRatioRule("partner", ratioConfigDO));

        // fire rules
        Facts facts = new Facts();
        facts.put(RatioFacts.BIZ_TYPE, "partner");
        facts.put(RatioFacts.OFFER_DATA, new OfferData());
        ratioEngine.fire(ratioRules, facts);
        System.out.println(facts.toString());
    }

}
