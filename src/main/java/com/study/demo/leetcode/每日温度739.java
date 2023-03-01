package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/23 8:26 下午
 */

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 */
public class 每日温度739 {

    /**
     * z栈操作
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> temStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!temStack.isEmpty()){
                if (temperatures[temStack.peek()] < temperatures[i]){
                    int temp = temStack.pop();
                    ans[temp] = i-temp;
                }else{
                    break;
                }
            }
            temStack.push(i);
        }
        return ans;
    }
}


