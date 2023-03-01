package com.study.demo.leetcode;

import java.util.*;

/**
 * @author ：xurong02
 * @date ：2023/2/28 10:49 下午
 */
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size =0;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode linkedNode = cache.get(key);
        if (null == linkedNode){
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(linkedNode);
        return linkedNode.value;
    }

    private void moveToHead(DLinkedNode linkedNode) {
        remove(linkedNode);
        addToHead(linkedNode);
    }

    private void addToHead(DLinkedNode linkedNode) {
        linkedNode.prev = head;
        linkedNode.next = head.next;
        head.next.prev = linkedNode;
        head.next =linkedNode;
    }

    private void remove(DLinkedNode linkedNode) {
        DLinkedNode prev = linkedNode.prev;
        prev.next = linkedNode.next;
        linkedNode.next.prev = prev;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (null == node){
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);

            addToHead(newNode);
            ++size;
            if (size>capacity){
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else{
// 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
      }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        remove(res);
        return res;
    }
}
