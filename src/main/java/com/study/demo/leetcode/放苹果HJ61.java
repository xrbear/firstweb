package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/2 11:18 上午
 */

import java.util.Scanner;

/**
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 */
public class 放苹果HJ61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int appleNum = in.nextInt();
            int panNum = in.nextInt();
            System.out.println(count(appleNum,panNum));
        }
    }

    public static int count(int m,int n)
    {
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        //有空盘，无空盘
        return count(m,n-1)+count(m-n,n);
    }

    private static int process(int appleNum, int panNum,int begin) {
        if (appleNum == 0 && panNum >=0){
            return 1;
        }
        int num = 0;
        for (int i = begin; i <= appleNum; i++) {
            num +=process(appleNum-i,panNum-1,i);
        }
        return num;
    }
}
