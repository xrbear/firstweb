package com.study.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xurong02
 * @date ：2023/3/9 10:49 下午
 */
public class 两数之和1 {
    /**
     * 暴力，哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null !=hashMap.get(target-nums[i])){
                result[0] = i;
                result[1] = hashMap.get(target-nums[i]);
                break;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }
}
