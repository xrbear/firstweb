package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/6 2:02 下午
 */

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class 根据身高重建队列406 {
    public int[][] reconstructQueue(int[][] people) {
        int r = people.length;
        int c = people[0].length;
        int[][] result = new int[r][c];
        Set<Integer> shenGaoSet = new HashSet<>();

        Map<Integer, List<Integer>> shenGaoMap = new HashMap<>();
        for (int i = 0; i < r; i++) {
            int shengao = people[i][0];
            shenGaoSet.add(shengao);
            List<Integer> list = shenGaoMap.get(shengao);
            if (null == list){
                shenGaoMap.put(shengao, Collections.singletonList(people[i][1]));
            }else{
                list.add(people[i][1]);
                shenGaoMap.put(shengao,list);
            }
        }

        Object[] array = shenGaoSet.toArray();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            List<Integer> integerList = shenGaoMap.get(array[i]);
            Collections.sort(integerList);
            int nullCount = -1;
            int listCount =0;
            for (int j = 0; j < result.length; j++) {
                if (result[j][0] == 0){
                    nullCount++;
                    if (nullCount == integerList.get(listCount)){
                        result[j][0] = (int) array[i];
                        result[j][1] = nullCount;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        根据身高重建队列406 s = new 根据身高重建队列406();
        int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int[][] ints = s.reconstructQueue(people);
        System.out.println(ints);
    }
}
