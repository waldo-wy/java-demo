package org.waldo.demo.foundation.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * lombok测试类
 *  cool,不是吗？
 * @author waldo.wy 2018/5/27
 */
@Data
@Slf4j
public class Store {
    private Long id;
    private Long name;

    public static void main(String[] args) {
        Store store = new Store();
        store.setId(1234L);
    }
}
