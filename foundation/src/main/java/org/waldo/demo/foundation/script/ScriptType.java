package org.waldo.demo.foundation.script;

/**
 * 脚本类型
 * 
 * @author waldo.wy 2017/9/15
 */
public enum ScriptType {

    GROOVY("groovy"), JAVASCRIPT("javascript");

    private String name;

    ScriptType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
