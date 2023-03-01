package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/27 3:04 下午
 */

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class 字符串解码394 {
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (null == s || s.length() == 0){
            return "";
        }
        int length = s.length();
        int index = 0;
        while (index < length){
            char c = s.charAt(index);
            if(c > '0' && c<='9'){
                index +=2;
                StringBuilder sb = new StringBuilder();
                while (s.charAt(index) != ']'){
                    sb.append(s.charAt(index));
                    index +=1;
                }
                for (int i = 0; i < c - '0'; i++) {
                    stringBuilder.append(sb);
                }
                if (s.charAt(index) == ']'){
                    index++;
                }
            }else {
                stringBuilder.append(c);
                index++;
            }
        }
        return stringBuilder.toString();
    }
}
