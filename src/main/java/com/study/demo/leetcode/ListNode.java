package com.study.demo.leetcode;

import lombok.Data;

/**
 * @author ：xurong02
 * @date ：2023/3/1 3:50 下午
 */
@Data
public class ListNode {
    int val;
    ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
