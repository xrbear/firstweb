package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/8 11:21 上午
 */

/**
 * hard
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 */
public class 滑动窗口最大值239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length-k+1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        result[0] = max;
        for (int i = 1; i < length+1-k; i++) {
            result[i] = Math.max(result[i-1], nums[i+k-1]);
        }
        return result;
    }
}
