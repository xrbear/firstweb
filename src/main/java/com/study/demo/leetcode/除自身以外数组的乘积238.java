package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/7 8:41 下午
 */

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class 除自身以外数组的乘积238 {

    /**
     * 两个数组，分别存放左乘积和右乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] R = new int[length];
        int[] L = new int[length];
        for (int i = 0; i < length; i++) {
            if (i ==0){
                L[i] = 1;
            }else {
                L[i] = L[i-1] * nums[i-1];
            }
        }

        for (int i = length-1; i >=0; i--) {
            if (i ==length-1){
                R[i] = 1;
            }else {
                R[i] = R[i+1] * nums[i+1];
            }
        }
        for (int i = 0; i < length; i++) {
            if (i==0){
                result[i] = R[i];
            }else if (i == length-1){
                result[i] = L[i];
            }else {
                result[i] = L[i] * R[i];
            }
        }
        return result;
    }
}
