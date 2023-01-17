package com.study.demo.datastrutrue;

import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

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
        for (int i=0;i<12;i++){
            map.put(String.valueOf(i),i);
        }
        Object o = map.put("xurong", 1995);
        System.out.println(o);
        System.out.println(map.get("xurong"));
        System.out.println(map.keySet());
    }

    public static void main(String[] args) throws InterruptedException {
        Object mapStudy = new Object();
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
