package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/22 10:29 上午
 */

import java.util.*;

/**
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：
 *
 * 1≤n≤10
 * 进阶：时间复杂度：
 *
 * O(n!) ，空间复杂度：
 *
 * O(n)
 */
public class 火车进站HJ77 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘数据
        Scanner sc = new Scanner(System.in);
        //使用next方式接收
        while(sc.hasNext()){
            int n = sc.nextInt();
            // 未进站的火车
            Queue<Integer> queue = new LinkedList<>();
            //已进站的
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                queue.offer(sc.nextInt());
            }
            List<String> outQueueList = new ArrayList<>();
            // 获取所有出站队列保存到outQueueList
            processOutQueue(queue, stack, "", outQueueList);
            // 排序
            Collections.sort(outQueueList);
            for (String str : outQueueList) {
                System.out.println(str);
            }
        }


        //及时关闭IO流的类，否则会一直占用资源
        sc.close();
    }

    private static void processOutQueue(Queue<Integer> queue, Stack<Integer> stack, String outQueue, List<String> outQueueList) {

        // 如果队列和栈都为空，则保存出站信息
        if (queue.isEmpty() && stack.isEmpty()) {
            outQueueList.add(outQueue.trim());
            return;
        }
        // 队列和栈有两种情况：出栈或进栈
        // 一：出栈
        if (!stack.isEmpty()) {
            // 先克隆
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
            String tempOutQueue = outQueue + (tempStack.pop() + " ");
            processOutQueue(tempQueue, tempStack, tempOutQueue, outQueueList);
        }

        // 二：队列进栈
        if (!queue.isEmpty()) {
            // 先克隆
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
            tempStack.push(tempQueue.poll());
            processOutQueue(tempQueue, tempStack, outQueue, outQueueList);
        }
    }


}
