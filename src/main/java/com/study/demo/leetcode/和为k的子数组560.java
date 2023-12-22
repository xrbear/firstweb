package com.study.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数
     */
    public int subarraySum(int[] nums, int k) {
        int pre =0;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++){
            pre += nums[i];
            if (map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
