package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/24 4:51 下午
 */

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class 旋转图像48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <= (n%2==0 ?n/2:(n/2+1)) ; i++) {
            for (int j = i; j <n-1-i; j++) {
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
