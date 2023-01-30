package com.study.demo.leetcode;

import org.springframework.util.StringUtils;

/**
 * 最长回文子串
 * @author ：xurong02
 * @date ：2023/1/29 5:10 下午
 */
public class Five {
    public String longestPalindrome(String s) {
        if ( s.length() ==1 || StringUtils.isEmpty(s)){
            return s;
        }
        return "" ;
    }
}
