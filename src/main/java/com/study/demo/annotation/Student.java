package com.study.demo.annotation;

import com.study.demo.annotation.hello;

/**
 * @author ：xurong02
 * @date ：2022/11/8 4:53 下午
 */
public class Student {
    @hello(name = "cherry-peng", age = 23, score = {99, 66, 77})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study, Day Day Up!");

        }
    }


    public static void main(String[] args) {
        String s = "t";
        int i = s.hashCode();
        System.out.println(i);
        boolean t = s.equals("t");
        System.out.println(t);
    }
}
