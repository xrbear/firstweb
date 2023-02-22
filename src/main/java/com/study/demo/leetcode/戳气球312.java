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
public class 戳气球312 {
    int[][] rec ;
    int[] val;
    public int maxCoins(int[] nums) {
        int length = nums.length;
        val = new int[length+2];
        for (int i = 0; i < length+1; i++) {
            if (i==0 || i == length){
                val[i] = 1;
            }else{
                val[i] = nums[i-1];
            }
        }
        return 0;

    }
}
