package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/7 10:39 下午
 */
public class 快速排序 {
    public void quicksort(int[] array, int low, int high){
        int pivot, p_pos,i,t;
        if (low < high){
            p_pos = low;
            pivot =array[p_pos];
            for (i = low+1; i <= high; i++) {
                if (array[i]>pivot){
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] =t;
                }
            }
            t =array[low];
            array[low] = array[p_pos];
            array[p_pos] =t;
            quicksort(array, low, p_pos-1);
            quicksort(array, p_pos+1, high);
        }
    }
}
