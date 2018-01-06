package org.waldo.demo.foundation.thread;

import java.util.concurrent.*;

/**
 * 类ThreadPool的实现描述：TODO 类实现描述
 *
 * @author waldo.wangy 2017/12/4 下午10:38
 */
public class ThreadPool {

    public static void main(String[] args) {
        int nThreads = Runtime.getRuntime().availableProcessors() + 1;
        ExecutorService executorService = new ThreadPoolExecutor(nThreads, nThreads,
                                                                 0L, TimeUnit.MILLISECONDS,
                                                                 new LinkedBlockingQueue<Runnable>(512),
                                                                 new NamedThreadFactory("tester", false));
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ". run times=" + finalI);
            });
        }
        executorService.shutdown();
    }

}
