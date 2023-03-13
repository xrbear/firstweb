package com.study.demo.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：xurong02
 * @date ：2023/3/8 7:12 下午
 */

/**
 * 优先队列
 */
public class 合并K个升序链表23 {

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()){
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(new Status(tail.next.val, tail.next));
            }

        }
        return head.next;
    }

    public static void main(String[] args) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        queue.offer(node1);
        queue.offer(node2);
        queue.offer(node3);
    }
}
