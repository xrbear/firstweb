package com.study.demo.leetcode;

public class 反转链表206 {
    public ListNode reverseList(ListNode head) {

        if (null == head || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}
