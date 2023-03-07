package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/1 4:39 下午
 */

import java.util.*;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。有重复
 */
public class 排序链表148 {
    public ListNode sortList(ListNode head) {
        if (null ==head){
            return null;
        }
        ListNode temp =head;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();
        while (null != temp){
            keyList.add(temp.val);
            nodeMap.put(temp.val, temp);
            temp = temp.next;
        }
        Collections.sort(keyList);
        head = nodeMap.get(keyList.get(0));
        temp = head;
        for (int i=1; i<keyList.size();i++) {
            ListNode listNode = nodeMap.get(keyList.get(i));
            temp.next = listNode;
             temp = listNode;
        }
        temp.next = null;
        return head;
    }

    public ListNode sortList2(ListNode head){
        if (head == null){
            return null;
        }
        return sortList(head, null);

    }
    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return null;
        }
        if (head.next == tail){
            head.next =null;
            return head;
        }
        ListNode fast =head, slow = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (tail != fast){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while(list1 != null && list2 != null){
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null){
            temp.next = list1;
        }else if (list2!=null){
            temp.next = list2;
        }
        return dummyHead.next;
    }
}
