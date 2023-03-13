package com.study.demo.leetcode;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 * @author ：xurong02
 * @date ：2023/2/12 7:36 下午
 */

import java.util.Arrays;

/**
 *
 */
public class 戳气球312 {
    int[][] rec ;
    int[] val;
    public int maxCoins(int[] nums) {
        int length = nums.length;
        val = new int[length+2];
        for (int i = 1; i <= length; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[length + 1] = 1;


        rec = new int[length+2][length+2];
        for (int i = 0; i <= length + 1; i++) {
            Arrays.fill(rec[i], -1);
        }

        /*for (int i = length-1; i >=0; i--) {
            for (int j = i+2; j <= length+1; j++) {
                for (int k = i+1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
            return rec[0][n + 1];
        }*/

        return solve(0,length+1);

    }

    private int solve(int left, int right) {
        if (left >= right-1){
            return 0;
        }
        if (rec[left][right] != -1){
            return rec[left][right];
        }
        for (int i = left+1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left,i) + solve(i,right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }
}
