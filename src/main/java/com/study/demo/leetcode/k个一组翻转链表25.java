package com.study.demo.leetcode;

public class k个一组翻转链表25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode yummyNode = new ListNode(0);
        yummyNode.next = head;
        ListNode pre = yummyNode;
        while (true){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail ==null){
                    return yummyNode.next;
                }
            }
            ListNode cur = pre.next, next;
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre =cur;
        }
    }
}
