package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/23 4:27 下午
 */

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class 最短无序连续子数组581 {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        int left =0, right = length-1;
        for (int i = 0; i < length; i++) {
            left = i;
            if (temp[i] != nums[i]){
                break;
            }
        }
        for (int i = length-1; i >=left; i--) {
            right = i;
            if (temp[i] != nums[i]){
                break;
            }
        }
        if (left == right){
            return 0;
        }
        return right-left+1;
    }

    public int findUnsortedSubarray2(int[] nums){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, left =-1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]){
                right = i;
            }else{
                max = nums[i];
            }
            if (min < nums[nums.length-1-i]){
                left = nums.length-1-i;
            }else{
                min =nums[nums.length-1-i];
            }
        }
        return right ==-1?0:right-left+1;
    }
}
