package com.study.demo.morethread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xurong02
 * @date ：2023/1/12 3:10 下午
 */
public class LockStudy {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().build();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10),threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    public synchronized void syncMethod(Integer i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        LockStudy lockStudy = new LockStudy();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(() ->{
                lockStudy.syncMethod(finalI);
            });
        }

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try{

        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }

    }

}
