package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/24 10:30 上午
 */

import com.rabbitmq.tools.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class 组合总和39 {

    /**
     * 回溯，需要考虑重复的问题，添加begin参数解决
     */
    List<List<Integer>> result =new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> numList = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target){
            return result;
        }
        process(candidates,0,target,numList);
        return result;
    }

    private void process(int[] candidates, int begin,int target, List<Integer> numList) {
        if (target == 0){
            result.add(numList);
            return;
        }
        if (0> target ){
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            ArrayList<Integer> tempList= new ArrayList<>(numList);
            tempList.add(candidates[i]);
            process(candidates,i,target-candidates[i],tempList);
        }
    }

    public static void main(String[] args) {
        组合总和39 m = new 组合总和39();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = m.combinationSum(candidates, 7);
        System.out.println(lists);
    }
}
