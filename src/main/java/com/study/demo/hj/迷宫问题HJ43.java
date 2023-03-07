package com.study.demo.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：xurong02
 * @date ：2023/3/4 5:09 下午
 */
public class 迷宫问题HJ43 {

    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y =y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            List<Node> result = new ArrayList<>();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] nums = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            process(nums,0,0,result);
            for (Node p : result) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }

    private static boolean process(int[][] nums, int rIndex, int cIndex, List<Node> result) {
        result.add(new Node(rIndex,cIndex));
        nums[rIndex][cIndex] = 1;
        if (rIndex == nums.length-1 && cIndex == nums[0].length-1){
            return true;
        }
        if (rIndex+1 < nums.length && nums[rIndex+1][cIndex] == 0){
            if (process(nums,rIndex+1,cIndex,result)){
                return true;
            }
        }
        if (rIndex-1 >=0 && nums[rIndex-1][cIndex] == 0){
            if (process(nums,rIndex-1,cIndex,result)){
                return true;
            }
        }
        if (cIndex+1 < nums[0].length && nums[rIndex][cIndex+1] == 0){
            if (process(nums,rIndex,cIndex+1,result)){
                return true;
            }
        }
        if (cIndex-1 >=0 && cIndex-1 < nums[0].length && nums[rIndex][cIndex-1] == 0){
            if (process(nums,rIndex,cIndex-1,result)){
                return true;
            }
        }
        result.remove(result.size()-1);
        nums[rIndex][cIndex] = 0;
        return false;
    }
}
