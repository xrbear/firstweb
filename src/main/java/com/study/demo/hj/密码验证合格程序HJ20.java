package com.study.demo.hj;

/**
 * @author ：xurong02
 * @date ：2023/3/4 3:54 下午
 */

import java.util.Scanner;

/**
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 */
public class 密码验证合格程序HJ20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            if (s.length() <8){
                System.out.println("NG");
                continue;
            }
            if (getMatch(s)){
                System.out.println("NG");
                continue;
            }
            if (getString(s,0,3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean getString(String s, int l, int r) {
        for (int i = 0; i < s.length()-3; i++) {
            if (s.substring(i+3).contains(s.substring(i,i+3))){
                return true;
            }
        }
        return false;
    }

    private static boolean getMatch(String s) {
        int count =0;
        if(s.matches("[0-9]")){
            count++;
        }
        if (s.matches("[a-z]")){
            count++;
        }
        if (s.matches("[A-Z]")){
            count++;
        }
        if (s.matches("[^a-zA-Z0-9]")){
            count++;
        }
        return count>=3;

    }
}
