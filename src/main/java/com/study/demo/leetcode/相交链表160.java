package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/1 3:49 下午
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 判断两个链表的相交节点，否则返回null
 */
public class 相交链表160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        if (headA == null || headB == null){
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while(null != headA){
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (nodeSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
