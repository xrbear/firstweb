package com.study.demo.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @author rong.xu
 */
public class 数组减半2208 {
    public int halveArray(int[] nums) {
        int cishu = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2-o1>0?1:-1;
            }
        });
        double sum =0;
        for (Integer num:nums) {
            sum+=num;
            queue.offer(num.doubleValue());
        }
        double yiban = sum /2;
        while(sum > yiban){
            Double peek = queue.poll();
            sum -= peek /2.0;
            queue.offer(peek /2.0);
            cishu ++;
        }

        return cishu;
    }

    public static void main(String[] args) {
        int nums[] = {6,58,10,84,35,8,22,64,1,78,86,71,77};
        数组减半2208 s = new 数组减半2208();
        s.halveArray(nums);
    }
}
