/**
 * @author waldo.wy
 * @date 2017/3/7
 */
package org.waldo.demo.spring.component;

/**
 * @author waldo.wangy 2017/3/7 17:27
 */
//@Component
public class DemoComponent {

    public void doSomething() {
        System.out.println(String.format("I[%1$s] am work.", this));
    }

}
