package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/24 11:35 上午
 */

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class 全排列46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        int length = nums.length;
        if (length ==0){
            return ans;
        }
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        process(length,output,ans,0);
        return ans;
    }

    private void process(int length, List<Integer> output, List<List<Integer>> ans, int first) {
        if (first == length){
            ans.add(new ArrayList<>(output));
        }
        for (int i = first; i < length; i++) {
            Collections.swap(output,first,i);
            process(length,output,ans,first+1);
            Collections.swap(output,first,i);
        }

    }


}
