/**
 * @author waldo.wy
 * @date 2017/4/27
 */
package org.waldo.demo.foundation.map;

import java.util.HashMap;

/**
 * 类HashMapDemo描述：
 *
 * @author waldo.wy 2017/4/27 17:56
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> mapper = new HashMap<>();
        mapper.put("waldo.wy", "A君");
        mapper.put("frank.liu", "B君");
        System.out.println(mapper);
    }

}
