package com.study.demo.leetcode;

import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/2 10:18 上午
 */

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class 质数因子HJ6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            long k = (long)Math.sqrt(num);
            for (int i = 2; i <= k; i++) {
                while (num % i ==0){
                    System.out.print(i+" ");
                    num = num /i;
                }
            }
            System.out.println(num == 1 ? "": num+" ");
        }
    }
}
