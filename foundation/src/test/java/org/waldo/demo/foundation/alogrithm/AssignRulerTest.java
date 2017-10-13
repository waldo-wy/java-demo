package org.waldo.demo.foundation.alogrithm;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssignRulerTest {

    private AssignRuler assignRuler;

    private List<String> users;

    private List<String> tasks;

    @Before
    public void init() {
        assignRuler = new AssignRuler();

        users = new ArrayList<>();
        users.add("waldo");
        users.add("william");
        users.add("bob");
        users.add("kate");
        users.add("hebe");

        tasks = new ArrayList<>();
        tasks.add("task-1");
        tasks.add("task-2");
        tasks.add("task-3");
        tasks.add("task-4");
        tasks.add("task-5");
        tasks.add("task-6");
        tasks.add("task-7");
    }

    @Test
    public void allotOfRandom() throws Exception {
        Map<String, List<String>> result = assignRuler.allotOfRandom(users, tasks);
        System.out.println(result);
    }

    @Test
    public void allotOfAverage() throws Exception {
        Map<String, List<String>> result = assignRuler.allotOfAverage(users, tasks);
        System.out.println(result);
    }

    @Test
    public void allotOfProportion() throws Exception {
        Map<String, String> pUsers = users.stream().collect(Collectors.toMap(Object::toString, user -> {
            int proportion = 1;
            switch (user) {
                case "bob":
                    proportion = 5;
                    break;
                case "kate":
                    proportion = 3;
                    break;
                default:
                    // nothing
            }
            return String.valueOf(proportion);
        }));
        Map<String, List<String>> result = assignRuler.allotOfProportion(pUsers, tasks);
        System.out.println(result);
    }

}