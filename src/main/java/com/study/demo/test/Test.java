package com.study.demo.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static int count = 0;
    private final static int MAX_TREAD=10;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        /*CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。
        使用一个计数器进行实现。计数器初始值为线程的数量。当每一个线程完成自己任务后，计数器的值就会减一。
        当计数器的值为0时，表示所有的线程都已经完成一些任务，然后在CountDownLatch上等待的线程就可以恢复执行接下来的任务。*/
        CountDownLatch latch = new CountDownLatch(MAX_TREAD);
        atomicInteger.getAndIncrement();
        //匿名内部类
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                count++;
                atomicInteger.getAndIncrement();
            }
            latch.countDown(); // 当前线程调用此方法，则计数减一
        };
        //同时启动多个线程
        for (int i = 0; i < MAX_TREAD; i++) {
            new Thread(runnable).start();
        }
        latch.await(); // 阻塞当前线程，直到计数器的值为0
        System.out.println("理论结果：" + 1000 * MAX_TREAD);
        System.out.println("static count: " + count);
        System.out.println("AtomicInteger: " + atomicInteger.intValue());
    }
}
