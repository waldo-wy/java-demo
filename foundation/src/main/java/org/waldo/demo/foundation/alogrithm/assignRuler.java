package org.waldo.demo.foundation.alogrithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 * 因为涉及到分配这个词，所以便搜索了一把分配相近的词：
 * assign - 按照某种原则进行的硬性分配，不一定公平
 * distribute - 以整体或者定量分为若干份为分配
 * divide - 普通用户，侧重于将某物分成若干份，分配给他人
 * sample:
 * He [assigned] the students a few books to read.
 * The relief agency [distributed] food among the poor.
 * He [divided] the food into four equal shares.
 * They could not agree on the [distribution] of the profits.
 * </pre>
 *
 * @author waldo.wangy 2017/10/10 上午10:38
 */
public class assignRuler {

    /**
     * 随机分配
     */
    public Map<String, List<String>> allotOfRandom(List<String> users, List<String> tasks) {
        //保存分配的信息
        Map<String, List<String>> allot = new ConcurrentHashMap<>();
        if (users != null && users.size() > 0 && tasks != null && tasks.size() > 0) {
            for (String task : tasks) {
                int randomIndex = new Random().nextInt(users.size());
                if (allot.containsKey(users.get(randomIndex))) {
                    List<String> list = allot.get(users.get(randomIndex));
                    list.add(task);
                    allot.put(users.get(randomIndex), list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(task);
                    allot.put(users.get(randomIndex), list);
                }
            }
        }
        return allot;
    }

    /*
     * 平均分配
     */
    public Map<String, List<String>> allotOfAverage(List<String> users, List<String> tasks) {
        Map<String, List<String>> allot = new ConcurrentHashMap<String, List<String>>(); //保存分配的信息
        if (users != null && users.size() > 0 && tasks != null && tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                int j = i % users.size();
                if (allot.containsKey(users.get(j))) {
                    List<String> list = allot.get(users.get(j));
                    list.add(tasks.get(i));
                    allot.put(users.get(j), list);
                } else {
                    List<String> list = new ArrayList<String>();
                    list.add(tasks.get(i));
                    allot.put(users.get(j), list);
                }
            }
        }
        return allot;
    }

    /*
     * 权重分配
     */
    public Map<String, List<String>> allotOfProportion(Map<String, String> users, List<String> tasks) {
        Map<String, List<String>> allot = new ConcurrentHashMap<String, List<String>>(); //保存分配的信息
        if (users != null && users.size() > 0 && tasks != null && tasks.size() > 0) {
            int a = 0;//总权重
            for (Map.Entry<String, String> entry : users.entrySet()) {
                a += Integer.parseInt(entry.getValue());
            }
            int start = 0, end = 0;//起始下标 ,结束下标
            if (a > 0) {
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    List<String> allotTask = new ArrayList<>();
                    end += Integer.parseInt(entry.getValue());//权重累计
                    for (; start < tasks.size() * end / a; start++) {
                        allotTask.add(tasks.get(start));
                    }
                    allot.put(entry.getKey(), allotTask);
                }
            }
        }
        return allot;
    }

}
