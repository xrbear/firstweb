package com.study.demo.biz;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ：xurong02
 * @date ：2022/11/4 4:30 下午
 */
@Service
public class CallableBiz implements Callable {
    @Override
    public Object call() throws Exception {

        System.out.println("CallableBiz start"+new Date());
        System.out.println("CallableBiz yield start"+new Date());
        Thread.yield();
        System.out.println("CallableBiz yield end"+new Date());
        Thread.sleep(2000);
        System.out.println("CallableBiz end"+new Date());
        return 1;
    }

    /**
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length-2; i++) {
            int left = i+1,right = length-1;
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(left<right){
                if (nums[left] + nums[right] == -nums[i]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                    while (left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left<right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if (nums[left] + nums[right] < -nums[i]){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
