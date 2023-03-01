package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/22 10:50 下午
 */

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class 搜索旋转数组33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length ==0){
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l=0,r = length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]){
                    if (nums[0] <= target && target < nums[mid]){
                        r = mid -1;
                    }else{
                        l = mid+1;
                    }
            }else{
                if (nums[mid] < target && target <= nums[r]){
                    l=mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
