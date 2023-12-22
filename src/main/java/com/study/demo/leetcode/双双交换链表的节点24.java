package com.study.demo.leetcode;

import java.util.List;

public class 双双交换链表的节点24 {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode next =  head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;

    }
}
