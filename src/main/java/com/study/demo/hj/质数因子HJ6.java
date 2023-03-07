package com.study.demo.hj;

/**
 * @author ：xurong02
 * @date ：2023/3/4 4:26 下午
 */

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class 质数因子HJ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            double sqrt = Math.sqrt(x);
            for (int i = 2; i <= sqrt; i++) {
                while (x % i == 0) {
                    System.out.print(i + " ");
                    x /= i;
                }
            }
            System.out.println(x == 1 ? "" : x + " ");
        }
    }
}
