package org.waldo.demo.foundation.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类NamedThreadFactory的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2017/12/4 下午10:47
 */
public class NamedThreadFactory implements ThreadFactory {

    static final AtomicInteger poolNumber = new AtomicInteger(1);

    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final boolean isDaemon;

    public NamedThreadFactory() {
        this("pool");
    }

    public NamedThreadFactory(String name) {
        this(name, true);
    }

    public NamedThreadFactory(String preffix, boolean daemon) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread()
                                                         .getThreadGroup();
        namePrefix = preffix + "-" + poolNumber.getAndIncrement() + "-thread-";
        isDaemon = daemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix
                + threadNumber.getAndIncrement(), 0);
        t.setDaemon(isDaemon);
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
