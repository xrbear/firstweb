package com.study.demo.leetcode;

public class 轮转数组189 {

    /**
     * 先将数组反转，再分成0-k，k+1-n进行反转
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);

    }
}
