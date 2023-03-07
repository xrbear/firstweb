package com.study.demo.designmodel;

/**
 * @author ：xurong02
 * @date ：2023/3/1 8:00 下午
 */
public class Singleton {
    /**
     * 加volatile，可以防止指令重排。是因为一个线程在执行了1，3步之后，另一个线程来获取，获取到一个未初始化到对象
     * 1、为 uniqueInstance 分配内存空间
     * 2、初始化
     * 3、uniqueInstance指向内存地址
     */
    private volatile static Singleton uniqueInstance = null;
    ThreadLocal n;

    public Singleton getSingleton() {

        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                    return uniqueInstance;
                }
            }

        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        Singleton s = new Singleton();
        System.out.println(s.n);
    }
}
