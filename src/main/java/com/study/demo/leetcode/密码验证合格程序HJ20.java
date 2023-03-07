package com.study.demo.leetcode;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author ：xurong02
 * @date ：2023/3/1 11:14 下午
 */

/**
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 正则
 */
public class 密码验证合格程序HJ20 {
    public static void main(String[] args) {
        String b = "1234";
        System.out.println(b.substring(1));;
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            if (a.length() <=8 ){
                System.out.println("NG");
                continue;
            }
            if (getMatch(a)){
                System.out.println("NG");
                continue;
            }
            if (getString(a,0,3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("ok" );
        }
    }
    // 校验是否有重复子串
    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str,l+1,r+1);
        }
    }
    private static boolean getMatch(String a) {
        int count = 0;
        Pattern  pattern = Pattern.compile("[A-Z]");
        Pattern  pattern2 = Pattern.compile("[a-z]");
        Pattern  pattern3 = Pattern.compile("[0-9]");
        Pattern  pattern4 = Pattern.compile("[^a-zA-Z0-9]");
        if(pattern.matcher(a).find()){
            count++;
        }
        if(pattern2.matcher(a).find()){
            count++;
        }
        if(pattern3.matcher(a).find()){
            count++;
        }
        if(pattern4.matcher(a).find()){
            count++;
        }
        return count<3;
    }

}
