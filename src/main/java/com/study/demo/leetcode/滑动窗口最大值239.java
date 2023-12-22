package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/8 11:21 上午
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * hard
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 */
public class 滑动窗口最大值239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0]-o1[0] : o2[1]-o1[1];
            }
        }) ;
        int[] ans =new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i],i});
        }
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1] <= i-k){
                queue.poll();
            }
            ans[i-k+1] = queue.peek()[0];
        }
        return ans;
    }
}
