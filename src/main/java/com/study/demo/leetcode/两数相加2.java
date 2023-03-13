package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/10 10:12 上午
 */

import org.apache.commons.lang3.StringUtils;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + jinwei;
            jinwei = num / 10;
            tmp.next = new ListNode(num%10);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l2 != null) {
            int num = l2.val + jinwei;
            jinwei = num / 10;
            tmp.next = new ListNode(num%10);
            tmp = tmp.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int num = l1.val + jinwei;
            jinwei = num / 10;
            tmp.next = new ListNode(num%10);
            tmp = tmp.next;
            l1 = l1.next;
        }

        if (jinwei != 0){
            tmp.next = new ListNode(jinwei);
        }

        return head.next;
    }
}
