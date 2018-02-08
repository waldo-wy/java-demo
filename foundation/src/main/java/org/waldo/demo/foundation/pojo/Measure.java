package org.waldo.demo.foundation.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 指标模型
 * @author waldo.wy 2018/1/30
 */
public class Measure {

    /**
     * 指标Code
     */
    private String code;

    /**
     * 指标名称
     */
    private String name;

    /**
     * 指标描述
     */
    private String desc;

    /**
     * 指标类型
     */
    private String type;

    /**
     * 关联的指标
     */
    private List<Measure> relatedMeasures;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Measure> getRelatedMeasures() {
        return relatedMeasures;
    }

    public void setRelatedMeasures(List<Measure> relatedMeasures) {
        this.relatedMeasures = relatedMeasures;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
