package com.study.demo.hj;

/**
 * @author ：xurong02
 * @date ：2023/3/3 11:41 上午
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 */
public class 字符个数统计HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            char[] charArray = a.toCharArray();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i]>=0 && charArray[i] <= 127){
                    set.add(charArray[i]);
                }
            }
            System.out.println(set.size());

        }
    }
}
