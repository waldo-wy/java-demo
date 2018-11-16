package org.waldo.demo.foundation.thread;

import com.google.common.base.Stopwatch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;

/**
 * 结果是：
 * 1. 当创建CompletableFuture的时候，即开始做执行了
 * 2. https://stackoverflow.com/questions/49110537/parallel-stream-doesnt-set-thread-contextclassloader-after-tomcat-upgrade
 *
 * http://blog.dyngr.com/blog/2016/09/15/java-forkjoinpool-internals/
 * http://gee.cs.oswego.edu/dl/papers/fj.pdf
 *
 * @author waldo.wy 2018/11/13
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture2 = CompletableFuture.completedFuture(1000L)
                                                                        .thenAcceptAsync((time) -> {
                                                                            System.out.println("immediately info...");
                                                                            try {
                                                                                Thread.sleep(time);
                                                                            } catch (InterruptedException e) {
                                                                                e.printStackTrace();
                                                                            }
                                                                            System.out.println("Task 2");
//                                                                            return "2000";
                                                                        });

//        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
//            System.out.println("immediately info...");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Task 2");
//        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start stopwatch...");
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task 1");
            }), completableFuture2, CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ex 3");
                throw new CompletionException(new RuntimeException("test fast failover!"));
            })).whenComplete((v, ex) -> {
                System.out.println("exception: " + ex);
            }).join();

            System.out.println("all done!" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
        } catch (Exception e) {
            System.out.println("fast failover: " + e.getLocalizedMessage() + " elapsed " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms.");
        } finally {
            stopwatch.stop();
        }

    }
}
