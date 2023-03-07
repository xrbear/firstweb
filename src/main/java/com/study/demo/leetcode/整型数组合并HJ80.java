package com.study.demo.leetcode;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：xurong02
 * @date ：2023/3/2 1:11 下午
 */

/**
 * 用Treeset
 */
public class 整型数组合并HJ80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            Set<Long> set = new TreeSet<>();
            int a = in.nextInt();
            for (int i=0;i<a;i++){
            set.add(in.nextLong());
            }
            //接收第一个整形数组大小
            int size2 = in.nextInt();
            for (int i = 0; i < size2; i++) {
                set.add(in.nextLong());
            }
            //遍历输出
            for (long n : set) {
                System.out.print(n);
            }
        }
    }
}
