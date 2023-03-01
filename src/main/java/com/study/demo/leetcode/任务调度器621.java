package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/23 5:36 下午
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 */
public class 任务调度器621 {
    /**
     * 排列一个矩阵
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int maxExec =0;
        Map<Character,Integer> freq = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int num = freq.getOrDefault(tasks[i],0)+1;
            freq.put(tasks[i],num);
            maxExec = Math.max(num,maxExec);
        }

        int maxCount =0;
        Set<Map.Entry<Character, Integer>> entries = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == maxExec){
                ++maxCount;
            }
        }

        return Math.max((maxExec-1) * (n+1) + maxCount, tasks.length);
    }
}
