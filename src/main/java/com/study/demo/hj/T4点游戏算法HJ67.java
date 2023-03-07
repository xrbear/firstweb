package com.study.demo.hj;

import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/4 2:02 下午
 */
public class T4点游戏算法HJ67 {

    private static int[] nums = new int[4];
    private static boolean[] usedNums = new boolean[4];
    private static int flag =0;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String num = in.nextLine();
            String[] split = num.split(" ");
            for (int i = 0; i < 4; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            process(0,0);
            System.out.println(flag == 1);
        }
    }

    //u代表使用了多少个数字
    private static boolean process(int u, float temp) {
        if (temp == 24 && u == 4){
            flag = 1;
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (!usedNums[i]){
                usedNums[i] = true;
                if (process(u+1,temp+nums[i]) || process(u+1,temp-nums[i])
                        || process(u+1,temp*nums[i]) || process(u+1,temp/nums[i])){
                    return true;
                }
                usedNums[i] = false;
            }
        }
        return false;
    }


}
