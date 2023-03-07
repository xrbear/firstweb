package com.study.demo.hj;

import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/4 4:52 下午
 */
public class 放苹果Hj61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(precess(a,b));
        }
    }

    // 当盘子数<=苹果数，有两种情况：
    // 1.至少有一个盘子可以不放，因此count(m, n-1)
    // 2.至少每个盘子都有一个苹果，摆放后苹果数为(m-n)，因此coutn(m-n, n)
    private static int precess(int m, int n) {
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        return precess(m,n-1)+precess(m-n,n);
    }
}
