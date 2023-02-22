package com.study.demo.leetcode;

import org.springframework.util.StringUtils;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * @author ：xurong02
 * @date ：2023/2/2 11:52 下午
 */

/**
 * 从中心点向两边拓展
 * public int countSubstrings(String s) {
 *         int n = s.length(), ans = 0;
 *         for (int i = 0; i < 2 * n - 1; ++i) {
 *             int l = i / 2, r = i / 2 + i % 2;
 *             while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
 *                 --l;
 *                 ++r;
 *                 ++ans;
 *             }
 *         }
 *         return ans;
 *     }
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/palindromic-substrings/solutions/379987/hui-wen-zi-chuan-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 回文子串647 {
    public int countSubstrings(String s) {
        if (StringUtils.isEmpty(s)){
            return 0;
        }
        int length = s.length();
        char[] charArray = s.toCharArray();
        int count =0;

        if (length == 1){
            return 1;
        }
        int[][] dp = new int[length][length];
        for (int i =0; i<length;i++){
            dp[i][i] = 1;
            if(i+1<length){
                dp[i][i+1]= charArray[i] == charArray[i+1]?1:0;
            }
        }
        for (int i = length-2; i >=0 ; i--) {
            for (int j = length-1; j >i+1 ; j--) {
                dp[i][j] = dp[i + 1][j - 1] == 1 ?( charArray[i] == charArray[j] ? 1 : 0 ): 0;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j=i;j<length;j++){
                if (dp[i][j]==1){
                    count++;
                }
            }
        }
return count;
    }
}
