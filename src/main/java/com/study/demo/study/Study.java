package com.study.demo.study;

/**
 * @author ：xurong02
 * @date ：2023/2/28 3:26 下午
 */



import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 17进制，29进制，写算法转换
 */
public class Study {

    Map<Integer, Character> numMap = new HashMap<>();
    {
        numMap.put(0,'0');
        numMap.put(1,'1');
        numMap.put(2,'2');
        numMap.put(3,'3');
        numMap.put(4,'4');
        numMap.put(5,'5');
        numMap.put(6,'6');
        numMap.put(7,'7');
        numMap.put(8,'8');
        numMap.put(9,'9');
        numMap.put(10,'a');
        numMap.put(11,'b');
        numMap.put(12,'c');
        numMap.put(13,'d');
        numMap.put(14,'f');
        numMap.put(15,'g');
        numMap.put(16,'h');
        numMap.put(17,'i');
        numMap.put(18,'j');
        numMap.put(19,'k');
        numMap.put(20,'l');
        numMap.put(21,'m');
        numMap.put(22,'n');
        numMap.put(23,'o');
        numMap.put(24,'p');
        numMap.put(25,'q');
        numMap.put(26,'l');
        numMap.put(27,'s');
        numMap.put(28,'t');
    }

    public String transform(String numa, int source, int to){
        if (StringUtils.isBlank(numa)){
            return "0";
        }
        String aStr = numa;
        int length = aStr.length();
        long num = 0;
        for (int i = 0; i < length; i++) {
            double powA = Math.pow(source, length - 1 - i);
            int numI = aStr.charAt(i) - '0';
            num += numI * powA;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (num % to > 0){
            Integer l = Math.toIntExact(num % to);
            num = num /to;
            stringBuilder.append(numMap.get(l));
        }
        String s = stringBuilder.toString();
        return StringUtils.reverse(s);
    }

    public static void main(String[] args) {

        Study study = new Study();
        System.out.println(study.transform("27",29,17));
    }
}
