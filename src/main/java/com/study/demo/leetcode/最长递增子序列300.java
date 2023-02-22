package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/8 10:05 上午
 */
public class 最长递增子序列300 {
    public int lengthOfLIS(int[] nums) {
        if (0==nums.length){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] =1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] =1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxans = Math.max(dp[i],maxans);
        }
        return maxans;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
