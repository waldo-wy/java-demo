package org.waldo.demo.foundation.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 类FastjsonDemo的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2018/1/24
 */
public class FastjsonDemo {

    public static void main(String[] args) {
        System.out.println(JSON.parseObject(JsonConstants.JSON_RAW_TEXT, JsonDemoObject.class));
        // SerializeConfig：是对序列化过程中一些序列化过程的特殊配置
        SerializeConfig commonConfig = new SerializeConfig();
        commonConfig.put(Boolean.TYPE, new BooleanSerializer());
        commonConfig.put(Boolean.class, new BooleanSerializer());
        System.out.println(JSON.toJSONString(JsonConstants.jsonDemoObject, commonConfig));
    }

    public static class BooleanSerializer implements ObjectSerializer {

        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
//            SerializeWriter out = serializer.out;

            Boolean value = (Boolean) object;
            if (value == null) {
                serializer.writeNull();
//                out.writeNull(SerializerFeature.WriteNullBooleanAsFalse);
                return;
            }

            if (value.booleanValue()) {
                serializer.write("Y");
            } else {
                serializer.write("N");
            }
        }
    }

}
