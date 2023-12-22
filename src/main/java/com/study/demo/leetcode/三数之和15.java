package com.study.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums){
            return new ArrayList<>();
        }
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int first=0;first<length;first++){
            if (nums[first] >0){
                break;
            }
            if (first >0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = length-1;
            int target = -nums[first];
            for (int second = first+1;second<third;second++){
                if (second > first+1 && nums[second] == nums[second-1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    third -- ;
                }
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> list =new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
