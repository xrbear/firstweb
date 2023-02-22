package com.study.demo.biz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xurong02
 * @date ：2022/11/6 6:34 下午
 */
public class Run {

    public static ThreadLocal tl = new ThreadLocal();

    public static void main(String[] args) {
        if (tl.get() == null){
            System.out.println("从未放过值");
            tl.set("王大治");
        }
        System.out.println(tl.get());
        System.out.println(tl.get());

        List<String> list = new ArrayList<>();
        list.add("1");
    }
}
