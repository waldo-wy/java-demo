package org.waldo.demo.spring.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 测试Spring生命周期专用Pojo类
 *
 * @author waldo.wy 2018/2/8
 */
public class ModelForLifecycle implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    @Value("${slc.test.name:十云}")
    private String name;
    @Value("${slc.test.address:网商路}")
    private String address;
    @Value("${slc.test.phone:8136}")
    private int phone;

    private BeanFactory beanFactory;

    private String beanName;

    public ModelForLifecycle() {
        System.out.println("【构造器】调用ModelForLifecycle的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory(), args=" + beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName(), args=" + name);
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    @PostConstruct
    public void customInit() {
        System.out.println("【init-method|PostConstruct】调用<bean>的init-method属性指定的初始化方法");
    }

    @PreDestroy
    public void customDestroy() {
        System.out.println("【destroy-method|PreDestroy】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
