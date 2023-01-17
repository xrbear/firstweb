package com.study.demo.service;

import com.study.demo.biz.CallableBiz;
import com.study.demo.biz.ThreadBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.*;
import java.util.regex.Pattern;

/**
 * @author ：xurong02
 * @date ：2022/11/3 2:14 下午
 */
@Service
public class ThreadServiceImpl implements ThreadService {


    @Autowired
    private ThreadBizImpl threadBiz;

    @Autowired
    private CallableBiz callableBiz;

    ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            System.out.println("threadFactory run");
            return null;
        }
    };
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    private ExecutorService executor = Executors.newCachedThreadPool(threadFactory);

    @Override
    public void createThread() {
        threadPoolExecutor.execute(() -> System.out.println("createThread run"));


    }

    @Override
    public void createRunnable() {
        System.out.println("createRunnable start");
        for (int i = 1; i < 101; i++) {
            ThreadBizImpl threadBiz1 = new ThreadBizImpl();
            Thread thread = new Thread(threadBiz1, "thread" + i);
            thread.start();
            System.out.println("" + thread.getName() + ", " + ThreadBizImpl.ticket);
            thread.getState();
        }
        System.out.println("createRunnable end");
    }

    @Override
    public void createCallable() {

        System.out.println("createCallable start" + new Date());
        FutureTask futureTask = new FutureTask(callableBiz);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Object o = futureTask.get();
            System.out.println("createCallable:{}" + o + new Date());
        } catch (Exception e) {

        }
        System.out.println("createCallable end" + new Date());
    }
}
