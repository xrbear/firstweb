package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/23 8:56 下午
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class 最长连续序列128 {
    /**
     * 放到set里，对set进行遍历，假如遍历到数num，如果set中包含num-1，则跳过，因为num-1对应对答案肯定比num对应的大；不包含num-1，则循环去num+1;
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int longest =0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }
        for (int num: numSet){
            if (!numSet.contains(num-1)){
                int current =1;
                while(numSet.contains(num +1)){
                    current++;
                }
                longest = Math.max(longest,current);
            }
        }

        return longest;
    }
}
