package org.waldo.demo.foundation.script.impl;

import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.waldo.demo.foundation.script.ScriptRuleDef;
import org.waldo.demo.foundation.script.ScriptRuleEngine;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 脚本引擎实现类，目前可以支持groovy脚本与javascript脚本（原生）
 *
 * @author waldo.wy 2017/9/15
 */
public class ScriptRuleEngineImpl implements ScriptRuleEngine {

    private static final Logger logger = LoggerFactory.getLogger(ScriptRuleEngineImpl.class);

    // private CompiledScript compiledScript; 如果需要增加性能，可以考虑通过版本号对脚本进行编译，只有在版本发生变化的时候，才会重新编译。
    private LoadingCache<String, CompiledScript> compiledScriptCache;

    @Override
    public Map<String, Object> execute(ScriptRuleDef scriptRuleDef, Map<String, Object> context) {
        ScriptEngineManager manager = new ScriptEngineManager();
        // 这里可以通过manager进行全局工具类注入，比如:
        manager.put("log", logger);

        ScriptEngine engine = manager.getEngineByName(scriptRuleDef.getType().getName());

        Bindings bindings = engine.createBindings();
        bindings.putAll(context);
        // check bindings
        // 需要检查有cfg/model，以及必须的

        Object scriptResult = null;
        try {
            scriptResult = engine.eval(scriptRuleDef.getScriptContent(), bindings);
        } catch (Exception e) {
            logger.error("Occurs error while run script[{}], ex={}", scriptRuleDef, e);
        }
        Object tempVar = bindings.get("c");
        logger.info("tempVar = " + tempVar);
        Map<String, Object> result = new HashMap<>();
        result.put("model", bindings.get("model"));
        result.put("result", scriptResult);
        return result;
    }
}
