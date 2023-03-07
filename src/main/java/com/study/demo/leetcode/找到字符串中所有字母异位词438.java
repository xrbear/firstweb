package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/6 11:06 上午
 */

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class 找到字符串中所有字母异位词438 {

    /**
     * 滑动窗口法，加一个字符，再减一个开头划过的
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int length = p.length();
        Map<Character, Integer> countMap = new HashMap<>();
        if (StringUtils.isBlank(s) || s.length() <length){
            return result;
        }

        for (int i = 0; i < length; i++) {
            countMap.put(p.charAt(i),countMap.getOrDefault(p.charAt(i),0)+1);
        }

        for (int i = 0; i <= s.length()-length; i++) {
            if (process(s.substring(i,i+length),countMap)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean process(String substring, Map<Character, Integer> p) {

        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            Integer integer = p.get(c);
            if (null == integer){
                return false;
            }
            integer -= 1;
            p.put(c,integer);
            if (integer <0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "cbaebabacd";
        String p = "abc";
        找到字符串中所有字母异位词438 l = new 找到字符串中所有字母异位词438();
        List<Integer> anagrams = l.findAnagrams(a, p);
        System.out.println(anagrams);
    }
}
