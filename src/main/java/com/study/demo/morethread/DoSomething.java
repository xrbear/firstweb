package com.study.demo.morethread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xurong02
 * @date ：2023/1/13 10:37 上午
 */
public class DoSomething extends Thread implements Runnable, Callable<Long> {
    /**
     * 顺须打印1到100
     */

    static int n=6;
    static  int cnt = 0;

    private int id;  // 线程编号
    public DoSomething(int id) {
        this.id = id;
    }

    /*@Override
    public void run(){
        while (cnt <=100){
            if (cnt % n == id){
                synchronized (DoSomething.class){
                    cnt ++;
                    if (cnt >100){
                        break;
                    }
                    System.out.println(cnt);
                }
            }

        }
    }*/

    @Override
    public void run(){
        while (cnt <= 100) {
            synchronized (DoSomething.class) {
                if (cnt % n == id){
                    cnt++;
                    if(cnt > 100){
                        DoSomething.class.notify();
                        break;
                    }
                    System.out.println("thread_" + id + " cnt:" + cnt);
                    DoSomething.class.notify();
                    try {
                        DoSomething.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

     public static void main(String[] args) throws Exception {
        //创建 interrupt-1 线程
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "线程正在执行...");
                if (Thread.currentThread().isInterrupted())
                {
                    System.out.println("线程1 接收到中断信息，中断线程...中断标记：" + Thread.currentThread().isInterrupted());

                    interrupted();
                    System.out.println("经过 Thread.interrupted() 复位后，中断标记：" + Thread.currentThread().isInterrupted());
                    break;
                }
            }
        }, "interrupt-1");
        //启动线程 1
        thread.start();


        //创建 interrupt-2 线程，用于设置线程1的中断状态
        new Thread(() -> {
            try {
               // TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("设置线程中断...." );
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"interrupt-2").start();



    }

    @Override
    public Long call() throws Exception {
        return 1L;
    }
}
