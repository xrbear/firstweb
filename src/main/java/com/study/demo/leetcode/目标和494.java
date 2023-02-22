package com.study.demo.leetcode;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * @author ：xurong02
 * @date ：2023/2/12 3:47 下午
 */

/**
 * 定义二维数组 dp，其中 dp[i][j]表示在数组 nums 的前 i 个数中选取元素，使得这些元素之和等于 j的方案数。假设数组 nums的长度为 n，则最终答案为 dp[n][neg]。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/target-sum/solutions/816361/mu-biao-he-by-leetcode-solution-o0cp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 目标和494 {
    public int findTargetSumWays(int[] nums, int target) {
        if( nums == null){
            return 0;
        }
        int sum =0;
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int  neg = diff / 2;
        int length = nums.length;

        int[][] dp =new int[length+1][neg+1];
        dp[0][0] =1;

        for (int i = 1; i <= length; i++) {
            int num = nums[i];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] =dp[i - 1][j];
                if (j>num){
                    dp[i][j] += dp[i-1][j-num];
                }
            }

        }
        return dp[length][neg];
    }

    private int process(int[] nums, int target, int index) {
        int length = nums.length;

        if (target == 0 && index == length){
            return 1;
        }
        if (target != 0 && index == length){
            return 0;
        }
        return process(nums,target+nums[index], index++) + process(nums,target-nums[index], index++);
    }
}
