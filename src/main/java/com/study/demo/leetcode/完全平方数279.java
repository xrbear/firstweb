package com.study.demo.leetcode;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * @author ：xurong02
 * @date ：2023/2/10 11:07 下午
 */
public class 完全平方数279 {
    public int numSquares(int n) {
        if (n==0 || n ==1 ){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1]=1;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j *j <=i; j++) {
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i] = 1+min;
        }
        return dp[n];
    }

}
