package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/21 10:44 下午
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
 *
 * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
 *
 * 第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
 * 转换规则如下：
 * 对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
 * 如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
 * 如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
 * 如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
 * 根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
 */
public class 字符串合并Hj30 {
    public static void process(String str1, String str2){

        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('0', '0');
            put('1', '8');
            put('2', '4');
            put('3', 'C');
            put('4', '2');
            put('5', 'A');
            put('6', '6');
            put('7', 'E');
            put('8', '1');
            put('9', '9');
            put('a', '5');
            put('b', 'D');
            put('c', '3');
            put('d', 'B');
            put('e', '7');
            put('f', 'F');
            put('A', '5');
            put('B', 'D');
            put('C', '3');
            put('D', 'B');
            put('E', '7');
            put('F', 'F');
        }};

        String str = str1+str2;
        int length = str.length();
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i%2 == 0){
                stringBuilder1.append(str.charAt(i));
            }else {
                stringBuilder2.append(str.charAt(i));
            }
        }

        char[] chars1 = stringBuilder1.toString().toCharArray();
        char[] chars2 = stringBuilder2.toString().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars1.length; i++) {
            sb.append(map.get(chars1[i]));
            if (chars2.length > i){
                sb.append(map.get(chars2[i]));
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            process(s1,s2);
        } }
}
