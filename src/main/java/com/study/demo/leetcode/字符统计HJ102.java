package com.study.demo.leetcode;


import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/2 11:57 上午
 */

/**
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 */
public class 字符统计HJ102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int[] chArray=new int[129];
            String a = in.next();
            char[] charArray = a.toCharArray();
            for (char c: charArray) {
                chArray[(int)c]++;
            }
            int max=0;
            //找出字符数量最多的ascll码值
            for(int i=0;i<chArray.length;i++)
                if(max<chArray[i])
                    max=chArray[i];
            StringBuilder sb=new StringBuilder();
            //按数量从大到小添加到可变字符序列sb
            while(max!=0)
            {
                for(int i=0;i<chArray.length;i++)
                    if(chArray[i]==max)
                        sb.append((char)i);
                max--;
            }
            System.out.println(sb.toString());
        }
    }
}
