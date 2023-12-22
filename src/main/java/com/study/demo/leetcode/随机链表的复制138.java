package com.study.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /**
     * 使用递归
     */
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {

        if (null == head){
            return head;
        }
        if (!map.containsKey(head)){
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
