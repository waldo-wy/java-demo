package org.waldo.demo.foundation.streams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.waldo.demo.foundation.pojo.IdType;

/**
 * <pre>
 * JDK8中有很多新的特性, 语义修改非常大, SteamAPI就是其中之一.
 * 官方文档可以看http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
 *
 * </pre>
 *
 * @author waldo.wangy 2017/2/7 11:28
 */
public class Features {

    public <T extends IdType> Map<Long, T> listToMap(List<T> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            return list.stream().collect(Collectors.toMap(IdType::getId, e -> e));
        } else {
            return Collections.emptyMap();
        }
    }

}
