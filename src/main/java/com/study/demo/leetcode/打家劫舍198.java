package com.study.demo.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 * @author ：xurong02
 * @date ：2023/2/6 10:48 下午
 */
public class 打家劫舍198 {
    public int rob(int[] nums) {

        int result =0;
       // result = precess(result,nums,0);
       int [] dp= new int[nums.length+1];
       dp[0] = 0;
       dp[1] =nums[0];
       for (int i=2;i<= nums.length;i++){
           dp[i] = Math.max(dp[i-1], nums[i-1]+dp[i-2]);
       }
        return result;
    }

    private int precess(int result, int[] nums, int i) {
        if (i>=nums.length){
            return 0;
        }

        result += Math.max(nums[i]+precess(result,nums,i+2),precess(result,nums,i+1));
        return result;
    }
}
