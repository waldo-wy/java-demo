package org.waldo.demo.foundation.pojo;

import java.util.List;

/**
 * 类Department的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2017/10/16 下午5:41
 */
public class Department implements IdType {

    private Long id;

    private String name;

    private List<User> staffs;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<User> staffs) {
        this.staffs = staffs;
    }
}
