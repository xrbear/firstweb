package com.study.demo.hj;

/**
 * @author ：xurong02
 * @date ：2023/3/3 11:17 上午
 */

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现）
 * ，如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 * 数据范围：数据组数：
 * 1≤t≤18
 * 进阶：时间复杂度：O(n) ，空间复杂度：
 * O(n)
 */
public class 合法IPHJ90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String ip = in.next();
            String[] split = ip.split("\\.");
            String result= "YES";
            if (split.length ==4){
                for (int i = 0; i < split.length; i++) {
                    if (!match(split[i])){
                        result = "NO";
                        break;
                    }
                }
            }else {
                result = "NO";
            }
            System.out.println(result);
        }
    }

    private static boolean match(String s) {
        if (StringUtils.isBlank(s) || s.length()>3){
            return false;
        }
        if (!s.matches("[0-9]*")){
            return false;
        }
        if (Integer.parseInt(s) <0 || Integer.parseInt(s)>255){
            return false;
        }
        if (s.charAt(0) == '0' && s.length() !=1){
            return false;
        }
        return true;
    }
}
