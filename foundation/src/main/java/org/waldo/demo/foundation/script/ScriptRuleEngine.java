package org.waldo.demo.foundation.script;

import java.util.Map;

/**
 * 脚本规则引擎接口说明
 * 
 * @author waldo.wy 2017/9/15 13:51
 */
public interface ScriptRuleEngine {

    /**
     * 要不要兜底呢？
     * @param orgCode
     * @param bizType
     * @param context
     * @return
     */
    Map<String, Object> execute(String orgCode, String bizType, Map<String, Object> context);

    Map<String, Object> execute(ScriptRuleDef ruleDef, Map<String, Object> context);

}
