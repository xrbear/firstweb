package com.study.demo.datastrutrue;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：xurong02
 * @date ：2023/1/6 11:22 上午
 */
public class MapStudy {


    public void studyHashMap(){
        Map<String,Object> map = new ConcurrentHashMap<>();

        Object o = map.put("xurong", 1995);
        Object o1 = map.put("xurong", 1995);
        System.out.println(o);
        System.out.println(map.get("xurong"));
        System.out.println(map.keySet());
    }

    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        System.out.println("启动后对象布局：\n" + ClassLayout.parseInstance(obj).toPrintable());
        //JKD8延迟4S开启偏向锁
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //可偏向 101
        final Object monitor = new Object();
        System.out.println("延迟5秒后对象布局：\n" + ClassLayout.parseInstance(monitor).toPrintable());
        //偏向锁
        synchronized (monitor) {
            System.out.println("对象加锁后的布局：\n" + ClassLayout.parseInstance(monitor).toPrintable());
        }
        System.out.println("对象释放锁后的布局：\n" + ClassLayout.parseInstance(monitor).toPrintable());


        Object mapStudy = new Object();
        ClassLayout classLayout = ClassLayout.parseInstance(mapStudy);
        String printable = classLayout.toPrintable();
        System.out.println(printable);

        MapStudy mapStudy1 = new MapStudy();
        mapStudy1.studyHashMap();

     //   mapStudy.studyHashMap();
        /*int hashCode = mapStudy.hashCode();
        long l = VM.current().addressOf(mapStudy);
        System.out.println(mapStudy);
        System.out.println(l);
        System.out.println(Long.toString(l,16));
        System.out.println(hashCode);
        System.out.println(Long.toString(hashCode,16));*/

        ThreadLocal threadLocal = new ThreadLocal<Integer>();
        threadLocal.set(10);

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                super.run();
                System.out.println("我是子线程，我要获取其他线程的ThreadLocal的值 ==> " + threadLocal.get());
            }
        };
        thread1.start();
        Thread.sleep(10000);
    }

}
