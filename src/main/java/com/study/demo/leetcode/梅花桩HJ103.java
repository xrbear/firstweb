package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/2 10:47 上午
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * 数据共2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 */
public class 梅花桩HJ103 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            int len = Integer.parseInt(a);
            int[] nums = new int[len];
            String s = in.nextLine();
            String[] split = s.split(" ");
            for(int i = 0;i < len;++i){
                nums[i] = Integer.parseInt(split[i]);
            }

            System.out.println(count(nums));
        }
    }

    private static int count(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
