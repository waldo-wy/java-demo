package org.waldo.demo.foundation.script.impl;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.waldo.demo.foundation.script.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ScriptRuleEngineImplTest {

    private ScriptRuleDef scriptRuleDef;

    @Before
    public void initMock() {
        scriptRuleDef = Mockito.mock(ScriptRuleDef.class);
        Mockito.when(scriptRuleDef.getType()).thenReturn(ScriptType.GROOVY);
        try {
            InputStream scriptInput = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.groovy");
            Mockito.when(scriptRuleDef.getScriptContent()).thenReturn(IOUtils.toString(scriptInput, "UTF-8"));
        } catch (IOException e) {
            // TODO write log
            e.printStackTrace();
        }
    }

    @Test
    public void execute() {
        ScriptRuleEngine scriptRuleEngine = new ScriptRuleEngineImpl();
        // order = dao.getOrder(orderId);
        //

        // String branchCode = xxxx;
        // branchCfg = dao.getBranchCfg(branchCode);
        // ruleDef = dao.getScriptRuleDef(branchCfg.getCode(), 'assign')
        // result = engine.execute(ruleDef, branchCfg, order, resultType.class)

        // 确定报人员， String assignee = engine.execute(ruleDef, branchCfg, order, resultType.class);

        //
        String branchCode = "HB_TB";
        BranchConfiguration cfg = getConfiguration(branchCode);

        Map<String, Object> context = new HashMap<>();
        context.put("cfg", cfg);

        Order inquirySheet = new Order();
        inquirySheet.setType("inquiry");
        inquirySheet.setAmount(200000L);
        context.put("model", inquirySheet);

        scriptRuleEngine.execute(scriptRuleDef, context);
    }

    private BranchConfiguration getConfiguration(String branchCode) {
        BranchConfiguration cfg = new BranchConfiguration();
        cfg.setOrderAmount(400000L);
        return cfg;
    }

}
