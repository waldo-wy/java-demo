package org.waldo.demo.rule;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.waldo.demo.foundation.pojo.Product;

public class DroolsTest {

    @Test
    public void testRules() {
        long start = System.currentTimeMillis();
        // 构建KieServices
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        // 获取kmodule.xml中配置中名称为ksession-rule的session，默认为有状态的。
        KieSession kSession = kieContainer.newKieSession("ksession-rule");

        Product product = new Product();
        product.setType(Product.GOLD);
        FactHandle handle = kSession.insert(product);
        int count = kSession.fireAllRules();
//        kSession.dispose();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" + product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
//        kSession = kieContainer.newKieSession("ksession-rule");
        Product product2 = new Product();
        product2.setType(Product.DIAMOND);
        kSession.insert(product2);
//        kSession.update(handle, product2);
        count = kSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" + product2.getType() + "的商品折扣为" + product2.getDiscount() + "%。");
        System.out.println(System.currentTimeMillis() - start);
//        kSession.delete(handle);
    }

}