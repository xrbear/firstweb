package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/24 5:27 下午
 */

import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 *给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class 字母异位词分组49 {
    /**
     * 对每个字符串排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> stringList = map.getOrDefault(s, new ArrayList<>());
            stringList.add(str);
            map.put(s,stringList);
        }

        return new ArrayList<>(map.values());
    }

}
