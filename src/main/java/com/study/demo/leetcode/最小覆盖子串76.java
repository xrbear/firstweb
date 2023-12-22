package com.study.demo.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 最小覆盖子串76 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * @param s
     * @param t
     * @return
     */
    //首先定义两个map放元素
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen =t.length();
        if (sLen<tLen){
            return "";
        }
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i),0)+1);
        }
        int r=0, l=0, ans = Integer.MAX_VALUE,ansL=-1,ansR=-1;
        while (r<sLen){
            if (ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while(check() && l<=r){
                if (r-l+1 < ans){
                    ans = r-l+1;
                    ansL = l;
                    ansR =r;
                }
                if (ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
            r++;
        }
        return ansL ==-1?"":s.substring(ansL,ansR);
    }

    private boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            Integer orDefault = cnt.getOrDefault(key, 0);
            if (orDefault != val){
                return false;
            }
        }
        return true;
    }
}
