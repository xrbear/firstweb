package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/9 10:37 下午
 */

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class 最长有效括号32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = (i>2?dp[i-2]:0) +2;
                }else if (i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] +2 + (i-dp[i-1] >=2?dp[i-dp[i-1]-2]:0);
                }
            max = Math.max(dp[i],max);
            }
        }
        return max;
    }
}
