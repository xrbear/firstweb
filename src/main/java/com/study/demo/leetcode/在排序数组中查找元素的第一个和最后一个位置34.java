package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/22 11:24 下午
 */

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class 在排序数组中查找元素的第一个和最后一个位置34 {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int mid = length/2;
        int leftIdx = search(nums,target,true);
        int rightIdx = search(nums,target,false)-1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int search(int[] nums, int target, boolean b) {
        int l=0 , r = nums.length-1, ans = nums.length;
        while(l<=r){
            int mid = (l+r)/2;
            if (nums[mid]>target || (b && nums[mid] >=target)){
                r = mid-1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
