package com.study.demo.morethread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author ：xurong02
 * @date ：2023/1/13 2:18 下午
 */
public class ThreadPoolStudy {

    static ThreadFactory factory = new ThreadFactoryBuilder().build();
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,5,TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),factory,new ThreadPoolExecutor.CallerRunsPolicy());

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 固定数量的线程池，队列长度2的31次方-1,队列会阻塞大量请求导致oom
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        /***
         * 一个线程，执行定时任务,队列长度2的31次方-1,可以有序
         */
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        /**
         * 核心线程数0 ，最大线程数2的31-1.，保持60s。创建大量的线程，从而导致OOM
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        /**
         * 支持执行延迟任务或者周期性执行任务的线程池,，最大线程数2的31-1
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(() -> {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName()+"---->"+thread.getId());
            });
        }
        CompletableFuture<?> submit = (CompletableFuture<?>) executorService.submit(() -> System.out.println("submit"));
        Object o = submit.get();

        Future<String> future = executorService.submit(() -> "callable");

        String s = future.get();
        System.out.println(s);

        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate");
            }
        },5000,3000,TimeUnit.SECONDS);

    }


}
