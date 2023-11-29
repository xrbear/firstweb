package com.study.demo.util;

/**
 * @author ：xurong02
 * @date ：2023/2/15 10:27 上午
 */
public class HeadUtil {
   public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

   public static  void setThreadLocal(String value){
        threadLocal.set(value);
    }
    public static String getThreadLocal(){
       return threadLocal.get();
    }
}
