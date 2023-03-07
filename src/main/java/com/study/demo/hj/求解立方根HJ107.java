package com.study.demo.hj;

/**
 * @author ：xurong02
 * @date ：2023/3/4 4:20 下午
 */

import java.util.Scanner;

/**
 * 牛顿公式：Fx = x^3 + y; Xk+1 = Xk-f(Xk)/求导
 */
public class 求解立方根HJ107 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()){
            double num = input.nextDouble();
            double x = 1.0;
            for (; Math.abs(Math.pow(x,3)-num)>1e-3; x=x-((Math.pow(x,3)-num)/(3*Math.pow(x,2))));
            System.out.println(String.format("%.1f", x));
        }
    }
}
