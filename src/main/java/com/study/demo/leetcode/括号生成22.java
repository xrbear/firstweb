package com.study.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xurong02
 * @date ：2023/1/30 9:57 下午
 */
public class 括号生成22 {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        int leftNum = n, rightNUm = n;
        process(result,"",leftNum,rightNUm);
        return result;
    }

    private void process(List<String> result, String s, int leftNum, int rightNUm) {
        if (leftNum == 0 && rightNUm ==0){
            result.add(s);
            return;
        }
        if (leftNum == rightNUm){
            process(result,s+"(",leftNum-1,rightNUm);
        }else if(leftNum < rightNUm){
            if (leftNum >0){
                process(result,s+"(",leftNum-1,rightNUm);
            }
            process(result,s+")",leftNum,rightNUm-1);
        }
    }
}
