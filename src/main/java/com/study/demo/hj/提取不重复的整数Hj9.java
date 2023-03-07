package com.study.demo.hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ：xurong02
 * @date ：2023/3/4 4:09 下午
 */
public class 提取不重复的整数Hj9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            int parseInt = Integer.parseInt(s);
            long result = 0;
            Set<Integer> set = new HashSet<>();
            while(parseInt >0){
                if (!set.contains(parseInt%10)){
                    result = parseInt%10 + result* 10;
                    set.add(parseInt % 10);
                }
                parseInt /= 10;
            }
            System.out.println(result);
        }
    }
}
