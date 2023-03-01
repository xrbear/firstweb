package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/22 10:05 上午
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 * 数据范围：字符串长度：
 *
 * 3≤s≤10
 */
public class 扑克牌大小HJ88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] arr = s.split("-");
            System.out.println(process(arr[0], arr[1]));
            //System.out.println(isBoom(arr[1]));
        }
    }

    public static String process(String s1,String s2){
        HashMap<String, Integer> map = new HashMap<String, Integer>(){
            {
                put("A", 14);
                put("2", 15);
                put("3", 3);
                put("4", 4);
                put("5", 5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("J", 11);
                put("Q", 12);
                put("K", 13);
                put("joker", 16);
                put("JOKER", 17);
            }
        };
        if (s1.equals("joker JOKER") || s1.equals("JOKER joker")){
            return s1;
        }else if (s2.equals("joker JOKER") || s2.equals("JOKER joker")){
            return s2;
        }
        String[] arr1 = s1.split(" ");
        int n1 = map.get(arr1[0]);
        String[] arr2 = s2.split(" ");
        int n2 = map.get(arr2[0]);
        if (isBoom(s2) && isBoom(s1)){
            return n1 > n2 ? s1 : s2;
        }else if (isBoom(s2)) {
            return s2;
        }else if (isBoom(s1)) {
            return s1;
        }else if (arr1.length == arr2.length){
            return n1 > n2 ? s1 : s2;
        }else{
            return "ERROR";
        }
    }

    private static boolean isBoom(String s1){
        String[] temp = s1.split(" ");
        if (temp.length != 4) {
            return false;
        }
        String cur = temp[0];
        for (int i = 1; i < 4; i++){
            if (!cur.equals(temp[i])) {
                return false;
            }
        }
        return true;
    }

}
