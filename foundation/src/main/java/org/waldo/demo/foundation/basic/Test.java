package org.waldo.demo.foundation.basic;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2020/8/24
 */
public class Test {

    public static List subArray(String[] s) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                result.add(s[i]);
                if (i + 1 < s.length) {
                    result.add(s[i] + s[i + 1]);
                }
                if (i + 1 == s.length) {
                    result.add(Arrays.stream(s).collect(Collectors.joining()));
                }
            }
            return result;
        }

      public static List subArrays(String[] s) {
            int start = 0, end;
            String s1 = "";
            List<String> result = new ArrayList<>();
            for (; start < s.length - 1; start++) {
                for (end = start + 1; end < s.length; end++) {
                    for (int i = start; i <= end; i++) {
                        s1 += s[i];
                        result.add(s1);
                    }
                }
            }
            return result;
        }

        public static void main(String[] args) {
            String[] s = {"a","b","c"};
            List subArray = subArray(s);
            List subArrays = subArrays(s);

            System.out.println(JSON.toJSONString(subArray));
            System.out.println(JSON.toJSONString(subArrays));
        }


}
