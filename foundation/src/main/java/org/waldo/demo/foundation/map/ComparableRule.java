package org.waldo.demo.foundation.map;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-04-05
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ComparableRule implements Comparable<ComparableRule> {

    private Long id;

    private String name;

    private Long priority;


    @Override
    public int compareTo(ComparableRule o) {
        if (getPriority() < o.getPriority()) {
            return -1;
        } else if (getPriority() > o.getPriority()) {
            return 1;
        } else {
            return getName().compareTo(o.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparableRule that = (ComparableRule) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priority);
    }
}
