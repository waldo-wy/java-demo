package org.waldo.demo.foundation.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 类JacksonDemo的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2018/1/24
 */
public class JacksonDemo {

    public static void main(String[] args) throws IOException {

        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.setCodec(new ObjectMapper());
//        JsonParser jsonParser = jsonFactory.createParser(JsonConstants.JSON_RAW_TEXT);
//        System.out.println(jsonParser.readValuesAs(JsonDemoObject.class).next());


        JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out);
        jsonGenerator.writeObject(JsonConstants.jsonDemoObject);

        // 和FastJson最大的不同就是写法上的不同，  FastJson写起来要简单多了
        JsonConstants.jsonDemoObject.setNothing("1234\"");
        System.out.println(new ObjectMapper().writeValueAsString(JsonConstants.jsonDemoObject));

//        System.out.println(new ObjectMapper().writeValueAsString()
    }
}
