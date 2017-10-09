/**
 * @author waldo.wy
 * @date 2017/7/5
 */
package org.waldo.demo.foundation.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 类StringUtilsDemo描述：
 *
 * @author waldo.wy 2017/7/5 20:20
 */
public class StringUtilsDemo {

    public static void main(String[] args) {
        System.out.println(StringUtils.removePattern("新疆维吾尔自治区", "省|市"));
        System.out.println(StringUtils.removePattern("上海市", "省|市"));
        System.out.println(StringUtils.removePattern("浙江省", "省|市"));
        System.out.println(StringUtils.removePattern("滨江", "市|区"));
    }

}
