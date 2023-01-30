package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/1/29 10:58 下午
 */
public class 最大子数组和53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
public int maxSubArrays(int[] nums){
        int pre = 0;
        int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
        pre = Math.max(pre+nums[i],nums[i]);
        max = Math.max(max,pre);
    }
    return max;
}
}
