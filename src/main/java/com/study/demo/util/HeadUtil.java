package com.study.demo.util;

/**
 * @author ：xurong02
 * @date ：2023/2/15 10:27 上午
 */
public class HeadUtil {
   public static ThreadLocal<Object> threadLocal = new InheritableThreadLocal<>();

   public static  void setThreadLocal(Object value){
        threadLocal.set(value);
    }
    public static Object getThreadLocal(){
       return threadLocal.get();
    }
}
