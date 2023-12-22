package com.study.demo.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符点最长子串3 {
    public int lengthOfLongestSubstring(String s) {

/*        if(StringUtils.isEmpty(s)){
            return 0;
        }

        int rightIndex = 0;
        int max = 0;
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map= new HashMap<>();
        for (int leftIndex=0;leftIndex<charArray.length;leftIndex++){
            for (;rightIndex<charArray.length;rightIndex++){
                if (map.get(charArray[leftIndex]) != null){
                    leftIndex=map.get(charArray[leftIndex]);
                    continue;
                }
                map.put(charArray[leftIndex],leftIndex);
                max = Math.max(max,rightIndex-leftIndex+1);
            }

        }
        return max;*/

        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk =-1, ans =0;
        for (int i=0;i<n;i++){
            if (i!=0){
                occ.remove(s.charAt(i-1));
            }
            while(rk+1<n && !occ.contains(s.charAt(rk+1))){
                rk++;
                occ.add(s.charAt(rk+1));
            }
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
