package org.waldo.demo.foundation.pojo;

import java.util.List;

/**
 * 类Organization的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2017/10/16 下午5:35
 */
public class Organization implements IdType {

    private Long id;

    private String name;

    private List<Department> departments;

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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
