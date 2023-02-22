package com.study.demo.test;

import java.util.Comparator;

/**
 * @author ：xurong02
 * @date ：2023/1/7 2:27 下午
 */
public class DongTaiGuiHua {

    /**
     * 背包问题
     */
    public static int maxValue(int[] w, int[] v , int bag){
        if (w == null || v == null || w.length != v.length){
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];
        for (int index = N-1; index >= 0 ; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index +1][rest];
                int p2 =0;
                int next = rest- w[index] <0?-1:dp[index+1][rest -w[index]];
                if (next != -1){
                    p2 = next + v[index];
                }
                dp[index][rest] = Math.max(p1,p2);
            }
        }

        return processBag(w,v,0,bag);
    }

    private static int processBag(int[] w, int[] v, int index, int bag) {
        if (bag<0){
            return -1;
        }
        if (index == w.length){
            return 0 ;
        }
        //不要当前货物
        int p1 = processBag(w,v,index+1,bag);
        //要
        int p2 =0;
        if (bag -w[index] >= 0){
            p2 = v[index] + processBag(w,v,index+1,bag-w[index]);
        }

        return Math.max(p1,p2);
    }

    /**
     *  规定1对应A,2对应B，3对应C。。。26对应Z
     *  那么一个数字字符串比如"111"就可以转化为："AAA"，
     *  "KA"，"AK"
     *  给定一个只有数字字符组成的字符串str，返回有多少种转化结果
     */
    public static int transferNum(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        return process1(str.toCharArray(),0);
    }

    private static int process1(char[] toCharArray, int i) {
        if (i == toCharArray.length){
            return 1;
        }
        if (toCharArray[i] == '0'){
            return 0;
        }
        int ways = process1(toCharArray, i+1);
        if (i+1 < toCharArray.length &&(toCharArray[i]-'0') * 10 + toCharArray[i+1] -'0' < 27){
            ways += process1(toCharArray,i+2);
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] w = {3,2,4,7};
        int[] v = {5,6,3,19};
        System.out.println(maxValue(w,v,11));
  //      System.out.println(jump2(7,7,10));
    }

    public static int dp1(String str){
        int length = str.length();
        if (str == null || length == 0){
            return 0;
        }
        char[] toCharArray = str.toCharArray();
        int[] dp = new int[length+1];
        dp[length] = 1;
        for (int i = length-1;i>=0;i--){
            if (toCharArray[i] != '0'){
                dp[i] = dp[i+1];
                if (i+1 < toCharArray.length &&(toCharArray[i]-'0') * 10 + toCharArray[i+1] -'0' < 27){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }


    /**
     * 给定一个字符串str,给定一个字符串类型的数组arr，出现的字符都是小写英文。
     * arr每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来
     * 返回需要至少多少张贴纸可以完成任务。
     * 例子：str="babac",arr=["ba","c","abcd"]
     * 至少需要两张贴纸："ba","abcd"
     */
    public static int minStickers1(String[] stickers, String target){
        int ans = process2(stickers, target);
        return ans == Integer.MAX_VALUE? -1:ans;
    }

    static int process2(String[] stickers, String target){
        if (target.length() == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String first : stickers) {
            String rest = minus(target,first);
            if (rest.length() != target.length()){
                min = Math.min(min,process2(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0:1);
    }

    private static String minus( String target, String first) {
        char[] str1 = target.toCharArray();
        char[] str2 = first.toCharArray();
        int[] count = new int[26];
        for (char cha : str1){
            count[cha-'a']++;
        }
        for (char cha : str2){
            count[cha-'a']--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] >0){
                for (int j = 0; j < count[i]; j++) {
                    stringBuilder.append((char)(i+'a'));
                }
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 最长公共子序列
     * 模型：从左往右的尝试模型；范围模型（ab拿数）;样本对应；业务限制
     * str1："a12bc345def";  str2:"MNP123QRS45Z"
     */

    public static int longestCommonSubsequence1(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];
        dp[0][0] = str1[0] == str2[2] ? 1:0;
        for (int i = 1; i < M; i++) {
            dp[0][i] = str1[0] == str2[i] ? 1:dp[0][i-1];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1:dp[i-1][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i-1][j];
                int p2 = dp[i][j-1];
                int p3 = str1[i] == str2[j] ? (1+dp[i-1][j-1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2,p3));
            }
        }
        return dp[N-1][M-1];
        //return process1(str1, str2, str1.length-1, str2.length-1);
    }

    /**
     * str1【0。。。ℹ️】与str2[0....j]最长公共
     * @param str1
     * @param str2
     * @param i
     * @param j
     * @return
     */
    public static int process1(char[] str1, char[] str2, int i,int j){
        if (i==0 && j==0){
            return str1[i] == str2[j] ? 1:0;
        }else if (i == 0) {
            if (str2[j] == str1[i]){
                return 1;
            }else {
                return process1(str1, str2, i, j-1);
            }
        }else if (j == 0) {
            if (str2[j] == str1[i]){
                return 1;
            }else {
                return process1(str1, str2, i-1, j);
            }
        }else{
            int p1 = process1(str1, str2, i-1, j);
            int p2 = process1(str1, str2, i, j-1);
            int p3 = str1[i] == str2[j] ? (1+process1(str1, str2, i, j-1)):0;
            return Math.max(p1, Math.max(p2,p3));
        }

    }


    /**
     * 马从0，0出发，到a,b走k步到走法数
     */
        public static int jump(int a, int b, int k){
            return process3(0,0,k,a,b);
        }

        public static int process3(int x,int y, int rest,int a,int b){
            if (x == a && y==b && rest == 0){
                return 1;
            }
            if (x >8 || x<0 || y>9 || y<0 ||rest <0){
                return 0;
            }
            int p1 = process3(x+1,y+2,rest-1,a,b);
            int p2 = process3(x+1,y-2,rest-1,a,b);
            int p3 = process3(x-1,y+2,rest-1,a,b);
            int p4 = process3(x-1,y-2,rest-1,a,b);
            int p5 = process3(x+2,y+1,rest-1,a,b);
            int p6 = process3(x+2,y-1,rest-1,a,b);
            int p7 = process3(x-2,y+1,rest-1,a,b);
            int p8 = process3(x-2,y-1,rest-1,a,b);
            return p1+p2+p3+p4+p5+p6+p7+p8;
        }

        public static int jump2(int a, int b, int k){
            int [][][] dp = new int[10][9][k+1];
            dp[a][b][0] = 1;
            for (int rest = 1; rest <=k; rest++) {
                for (int x=0;x<10;x++){
                    for (int y = 0; y < 9; y++) {
                        int ways = pick(dp,x+2,y+1,rest-1);
                        ways += pick(dp,x+1,y+2,rest-1);
                        ways += pick(dp,x-1,y+2,rest-1);
                        ways += pick(dp,x-2,y+1,rest-1);
                        ways += pick(dp,x-2,y-1,rest-1);
                        ways += pick(dp,x+2,y-1,rest-1);
                        ways += pick(dp,x+1,y-2,rest-1);
                        ways += pick(dp,x-1,y-2,rest-1);
                        dp[x][y][rest] = ways;
                    }
                }
            }

            return dp[0][0][k];
        }

        public static int pick(int[][][] dp, int x,int y,int rest){
            if (x >9 || x<0 || y>8 || y<0 ||rest <0){
                return 0;
            }
            return dp[x][y][rest];
    }

    /**
     * 给定 一个数组arr,arr[i]代表第i号咖啡机泡一杯咖啡的时间
     * 给定一个正数N,表示N个人等着泡咖啡。每台咖啡机只能轮流泡咖啡
     * 只有一台咖啡机，一次只能洗一个杯子，时间消耗a，洗完才能洗下一杯
     * 每个咖啡机也可以自己挥发干净，耗时b，可以并行挥发
     * 假设所有人拿到咖啡之后立刻喝干净，
     * 返回从开始等到所有咖啡机变干净的最短时间
     * 三个参数：int[] arr, int N, int a,int b
     */

    public static class Machine{
        public int timePoint;
        public int workTime;
        public Machine(int t, int workTime){
            this.timePoint =t;
            this.workTime = workTime;
        }
    }

    public static class MachineComparator implements Comparator<Machine>{

        @Override
        public int compare(Machine o1, Machine o2) {
            return o1.timePoint + o1.workTime - o2.workTime - o2.timePoint;
        }
    }
}
