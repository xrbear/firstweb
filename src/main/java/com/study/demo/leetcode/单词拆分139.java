package com.study.demo.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @author ：xurong02
 * @date ：2023/1/31 11:18 下午
 */
public class 单词拆分139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] =true;
                    break;
                }
            }
        }
return dp[s.length()];
    }

}
