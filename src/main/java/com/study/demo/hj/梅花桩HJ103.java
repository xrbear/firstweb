package com.study.demo.hj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/4 4:38 下午
 */
public class 梅花桩HJ103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String next = scanner.nextLine();
            int len = Integer.parseInt(next);
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            System.out.println(count(nums));
        }
    }

    private static int count(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        int max =1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
                max= Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
