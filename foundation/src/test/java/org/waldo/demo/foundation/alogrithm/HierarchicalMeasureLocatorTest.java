package org.waldo.demo.foundation.alogrithm;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.list.SetUniqueList;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.waldo.demo.foundation.pojo.Measure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 有层次结构的指标定位器
 *
 * @author waldo.wy 2018/1/30
 */
public class HierarchicalMeasureLocatorTest {

    private List<Measure> allMeasures;

    @Before
    public void init() {
        allMeasures = new ArrayList<>();

        Measure measure1 = new Measure();
        measure1.setCode("pay_goods_order_amount");
        measure1.setName("实物GMV");
        measure1.setType("base");
        allMeasures.add(measure1);

        Measure measure2 = new Measure();
        measure2.setCode("pay_virtual_order_amount");
        measure2.setName("虚拟GMV");
        measure2.setType("base");
        allMeasures.add(measure2);

        Measure measurex = new Measure();
        measurex.setCode("pay_order_sku_cnt");
        measurex.setName("采购SKU数");
        measurex.setType("base");
        allMeasures.add(measurex);

        Measure measure30 = new Measure();
        measure30.setCode("covert_pay_order_amount30");
        measure30.setName("折算GMV30");
        measure30.setType("complex");
        measure30.setRelatedMeasures(Arrays.asList(measure1, measure2));
        allMeasures.add(measure30);

        Measure measure3 = new Measure();
        measure3.setCode("covert_pay_order_amount");
        measure3.setName("折算GMV");
        measure3.setType("complex");
        measure3.setRelatedMeasures(Arrays.asList(measure1, measure2, measure30));
        allMeasures.add(measure3);

        Measure measure4 = new Measure();
        measure4.setCode("newbie_sales_std_store");
        measure4.setName("新人标动店");
        measure4.setType("complex");
        measure4.setRelatedMeasures(Arrays.asList(measure3, measure30, measurex));
        allMeasures.add(measure4);
    }

    @Test
    public void testHierarchicalMeasureLocator() {
        List<Measure> allComplexMeasures = allMeasures.parallelStream()
                                                      .filter(m -> StringUtils.equals(m.getType(), "complex"))
                                                      .collect(Collectors.toList());
        System.out.println(allComplexMeasures);
        Assert.assertEquals(allMeasures.size(), 5);
        Assert.assertEquals(allComplexMeasures.size(), 2);

        Set<Measure> relatedComplexMeasures = new HashSet<>();
        // 依赖深度找多少级是最为合理的？   使用递归可以解决无限找的问题，但效率不高
        allComplexMeasures.parallelStream()
                          .filter(cm -> CollectionUtils.isNotEmpty(cm.getRelatedMeasures()))
                          .forEach(cm -> {
                              relatedComplexMeasures.addAll(
                                      cm.getRelatedMeasures()
                                        .parallelStream()
                                        .filter(related -> StringUtils.equals(related.getType(), "complex"))
                                        .collect(Collectors.toSet()));
                          });

        System.out.println(relatedComplexMeasures);
        Assert.assertEquals(relatedComplexMeasures.size(), 1);

    }

    @Test
    public void test() {
        List<Long> testArrays = new ArrayList<>(Arrays.asList(58L, 17L, 8L, 8L, 28L, 17L, 58L));
        testArrays.add(0, testArrays.remove(testArrays.indexOf(17L)));
        System.out.println(testArrays);

        SetUniqueList<Long> list = SetUniqueList.setUniqueList(new ArrayList<>(Arrays.asList(58L, 17L, 8L, 8L, 28L, 17L, 58L)));
        list.add(0, list.remove(list.indexOf(17L)));
        System.out.println(list);
    }

    @Test
    public void test_complex_analyze() {
        LinkedList<String> prioritizedComplexMeasures = new LinkedList<>();
        Map<String, Measure> allComplexMaps = allMeasures.stream()
                                                         .filter(m -> StringUtils.equals(m.getType(), "complex"))
                                                         .peek(cm -> {
                                                             if (CollectionUtils.isNotEmpty(cm.getRelatedMeasures())) {
                                                                 analyzeRelatedComplexMeasures(cm.getRelatedMeasures(), prioritizedComplexMeasures);
                                                             }
                                                         }).collect(Collectors.toMap(Measure::getCode, cm -> cm));
        System.out.println(com.alibaba.fastjson.JSON.toJSONString(allComplexMaps));
        System.out.println(prioritizedComplexMeasures);
    }

    private void analyzeRelatedComplexMeasures(List<Measure> relatedMeasures, LinkedList<String> prioritizedComplexMeasures) {
        relatedMeasures.stream()
                       .filter(related -> StringUtils.equals(related.getType(), "complex"))
                       .forEach(related -> {
                           int hasIndex = prioritizedComplexMeasures.indexOf(related.getCode());
                           if (hasIndex >= 0) {
                               prioritizedComplexMeasures.addFirst(prioritizedComplexMeasures
                                                                           .remove(hasIndex));
                           } else {
                               prioritizedComplexMeasures.addLast(related.getCode());
                           }
                       });
    }

}
