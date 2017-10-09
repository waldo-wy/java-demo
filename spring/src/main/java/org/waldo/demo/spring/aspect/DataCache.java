/**
 * @author waldo.wy
 * @date 2017/3/8
 */
package org.waldo.demo.spring.aspect;

/**
 * @author waldo.wy 2017/3/8 09:17
 */
public interface DataCache<K, D> {
    // 获取数据
    D get();
    // 获取
    D getByKey(K key);

    void clear();

}
