package com.study.demo.leetcode;

public class 接雨水42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {

        int sum=0;
        int maxHeight = getMax(height);
        for (int i=1;i<=maxHeight;i++){
            int tmp=0;
            boolean start =false;
            for (int j=0;j<height.length;j++){
                if (start && height[j] < i){
                    tmp ++;
                }
                if (height[j] >= i){
                    sum += tmp;
                    tmp =0;
                    start =true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max =0;
        for (int i=0;i<height.length;i++){
            max = Math.max(max, height[i]);
        }
        return max;
    }

    public int trap2(int[] height) {
        int sum =0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i=1;i<height.length-1;i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for (int i=height.length-2;i>0;i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for (int i = 1;i<height.length-1;i++){
            int len = Math.min(maxLeft[i],maxRight[i]);
            if (len - height[i] >0){
                sum += len-height[i];
            }
        }
        return sum;
    }
}
