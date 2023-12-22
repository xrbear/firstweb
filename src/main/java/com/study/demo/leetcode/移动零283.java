package com.study.demo.leetcode;

public class 移动零283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        //双指针
        if (nums == null){
            return ;
        }
        int zeroIndex=0;
        for (int i =0; i < nums.length;i++){
            if (nums[i] !=0){
                int tmp = nums[i];
                nums[i] = 0;
                nums[zeroIndex] = tmp;
            }
        }
    }
}
