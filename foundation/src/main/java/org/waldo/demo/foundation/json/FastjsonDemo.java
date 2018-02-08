package org.waldo.demo.foundation.json;

import com.alibaba.fastjson.JSON;

/**
 * 类FastjsonDemo的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2018/1/24
 */
public class FastjsonDemo {

    public static void main(String[] args) {
        System.out.println(JSON.parseObject(JsonConstants.JSON_RAW_TEXT, JsonDemoObject.class));
        System.out.println(JSON.toJSONString(JsonConstants.jsonDemoObject));
    }

}
