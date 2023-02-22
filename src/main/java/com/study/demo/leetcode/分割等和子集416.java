package com.study.demo.leetcode;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @author ：xurong02
 * @date ：2023/2/12 2:56 下午
 */

/**
 * dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j。初始时，dp 中的全部元素都是 false。
 *
 */
public class 分割等和子集416 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum =0,maxNum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 != 0){
            return false;
        }

        int halfValue = sum / 2;
        if (maxNum > halfValue) {
            return false;
        }
        boolean[][] dp = new boolean[length][halfValue+1];
        for (int i = 0; i < length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= halfValue; j++) {
                if (j > nums[i]){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }else{
                    dp[i][j] =dp[i - 1][j];
                }
            }
        }

        return dp[length][halfValue];
    }

    private boolean findSum(int[] nums, int halfValue, int index) {
        if (halfValue <0){
            return false;
        }
        if (index == nums.length){
            return false;
        }
        if (halfValue == 0){
            return true;
        }
        return findSum(nums,halfValue, index+1) || findSum(nums,halfValue-nums[index],index+1);
    }
}
