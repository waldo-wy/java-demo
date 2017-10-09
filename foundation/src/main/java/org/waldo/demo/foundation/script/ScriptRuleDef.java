package org.waldo.demo.foundation.script;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 脚本规则定义
 * 
 * @author waldo.wy 2017/9/15
 */
public class ScriptRuleDef {

    private Long       id;

    private String     code;

    private String     name;

    private ScriptType type;

    private String     bizType;

    private String     scriptContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ScriptType getType() {
        return type;
    }

    public void setType(ScriptType type) {
        this.type = type;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getScriptContent() {
        return scriptContent;
    }

    public void setScriptContent(String scriptContent) {
        this.scriptContent = scriptContent;
    }

    @Override
    public String toString() {
        //@formatter:off
        return new ToStringBuilder(this)
                .append("id", id)
                .append("code", code)
                .append("name", name)
                .append("type", type)
                .append("bizType", bizType)
                .toString();
        //@formatter:on
    }
}
