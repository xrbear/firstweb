package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/25 10:38 下午
 */

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class 单词搜索79 {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char[][] temp = board;
                if (process(temp,r,i,c,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean process(char[][] board, int r,int rIndex, int c,int cIndex, String word,int index){
        if (rIndex<0 || rIndex>=r || cIndex<0 || cIndex >=c || board[rIndex][cIndex] != word.charAt(index)){
            return false;
        }
        if (index == word.length()-1){
            return true;
        }
        board[rIndex][cIndex] = 0;
        char[][] temp1 = board;
        char[][] temp2 = board;
        char[][] temp3 = board;
        char[][] temp4 = board;
        return process(temp1, r, rIndex, c, cIndex+1, word, index+1)
                || process(temp2, r, rIndex, c, cIndex-1, word, index+1)
                || process(temp3, r, rIndex+1, c, cIndex, word, index+1)
                || process(temp4, r, rIndex-1, c, cIndex, word, index+1);
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        单词搜索79 d =  new 单词搜索79();
        d.exist(board,"AAB");
    }

}
