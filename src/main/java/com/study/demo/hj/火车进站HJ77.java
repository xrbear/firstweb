package com.study.demo.hj;

import java.util.*;

/**
 * @author ：xurong02
 * @date ：2023/3/3 11:37 下午
 */

public class 火车进站HJ77 {
    static List<String> l = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            l.clear(); //静态变量，每次先清空
            int nums = in.nextInt();
            int[] id = new int[nums];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums; i++) {
                id[i] = in.nextInt();
            }
            process(id,0,stack,"",0);
        }
    }

    //n表示已经出站的，i表示已经进站的
    private static void process(int[] id, int i, Stack<Integer> stack, String str, int n) {
        if (n == id.length){
            l.add(str);
        }
        if (!stack.isEmpty()){
            Integer temp = stack.pop();
            process(id,i,stack,str+temp+" ",n+1);
            stack.push(temp);
        }
        if (i < id.length) {
            stack.push(id[i]);
            process(id, i + 1, stack, str, n);
            stack.pop(); //恢复现场

        }
    }
}
